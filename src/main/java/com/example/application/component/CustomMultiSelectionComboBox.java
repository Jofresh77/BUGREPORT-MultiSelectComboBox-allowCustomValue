package com.example.application.component;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

import com.example.application.views.utils.ClientValueChangedListener;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;

public class CustomMultiSelectionComboBox extends MultiSelectComboBox<String> {
	public CustomMultiSelectionComboBox(
			String label,
			Predicate<String> validator
	) {
		super(label);

		setAllowCustomValue(true);
		setAutoExpand(AutoExpandMode.BOTH);

		addCustomValueSetListener(event -> {
			if (!event.isFromClient()) {
				return;
			}

			var itemToAdd = event.getDetail();
			if (itemToAdd.contains("||") || itemToAdd.contains(",")) {
				String[] values = itemToAdd.split("\\|\\||,");
				Set<String> currentItems = new LinkedHashSet<>(getValue());

				for (String value : values) {
					String trimmedValue = value.trim();
					if (!trimmedValue.isEmpty() && validator.test(trimmedValue)) {
						currentItems.add(trimmedValue);
					}
				}

				updateItems(currentItems);
			} else {
				String trimmedValue = itemToAdd.trim();
				if (!trimmedValue.isEmpty() && validator.test(trimmedValue)) {
					var items = new LinkedHashSet<>(getValue());
					if (!items.contains(trimmedValue)) {
						items.add(trimmedValue);
						updateItems(items);
					}
				}
			}

			focus();
		});

		addValueChangeListener(ClientValueChangedListener.of(event -> {
			var items = event.getValue();
			updateItems(items);
		}));
	}

	private void updateItems(Set<String> value) {
		setItems(value);
		setValue(value);
	}
}
