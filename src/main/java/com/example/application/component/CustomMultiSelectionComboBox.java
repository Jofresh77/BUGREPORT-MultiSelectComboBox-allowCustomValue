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
