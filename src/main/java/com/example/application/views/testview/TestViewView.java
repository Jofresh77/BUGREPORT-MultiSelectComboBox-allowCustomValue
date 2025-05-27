package com.example.application.views.testview;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("TestView")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
public class TestViewView extends Composite<VerticalLayout> {

    public TestViewView() {
        MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        multiSelectComboBox.setLabel("Multi-Select Combo Box");
        getContent().setAlignSelf(FlexComponent.Alignment.START, multiSelectComboBox);
        multiSelectComboBox.setWidth("min-content");
        setMultiSelectComboBoxSampleData(multiSelectComboBox);
        getContent().add(multiSelectComboBox);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectComboBoxSampleData(MultiSelectComboBox multiSelectComboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectComboBox.setItems(sampleItems);
        multiSelectComboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}
