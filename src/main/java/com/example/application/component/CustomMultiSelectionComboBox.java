package com.example.application.component;

import java.util.Set;

import com.example.application.views.utils.ClientValueChangedListener;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;

public class CustomMultiSelectionComboBox extends MultiSelectComboBox<String> {
	public CustomMultiSelectionComboBox(
			String label
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
