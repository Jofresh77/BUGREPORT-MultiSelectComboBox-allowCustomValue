package com.example.application.views.bugview;

import com.example.application.component.CustomMultiSelectionComboBox;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("TestView")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
public class TestView extends Composite<VerticalLayout> {

    public TestView() {
        CustomMultiSelectionComboBox multiSelectComboBox = new CustomMultiSelectionComboBox(
                "test",
                (e) -> true);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        multiSelectComboBox.setLabel("Multi-Select Combo Box");
        getContent().setAlignSelf(FlexComponent.Alignment.START, multiSelectComboBox);
        multiSelectComboBox.setWidth("min-content");
        getContent().add(multiSelectComboBox);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }
}
