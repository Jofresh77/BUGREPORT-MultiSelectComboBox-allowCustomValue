package com.example.application.views.utils;

import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;

public final class ClientValueChangedListener<E extends ValueChangeEvent<?>> implements ValueChangeListener<E> {
	private final ValueChangeListener<E> listener;

	private ClientValueChangedListener(ValueChangeListener<E> listener) {
		this.listener = listener;
	}

	@Override
	public void valueChanged(E event) {
		if (event.isFromClient()) {
			listener.valueChanged(event);
		}
	}

	public static <E extends ValueChangeEvent<?>> ClientValueChangedListener<E> of(ValueChangeListener<E> listener) {
		return new ClientValueChangedListener<>(listener);
	}
}
