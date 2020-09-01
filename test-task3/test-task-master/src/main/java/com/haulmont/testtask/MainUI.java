package com.haulmont.testtask;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@Theme(ValoTheme.THEME_NAME)

public class MainUI extends UI{

    //private CreatePatient patient = new CreatePatient();

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout generallayout = new VerticalLayout();
        TabSheet tabSheet = new TabSheet();
        generallayout.addComponent(tabSheet);

        VerticalLayout layout = new VerticalLayout();

        layout.setSizeFull();
        layout.setMargin(true);

        //mark one
        TabOne tabOne = new TabOne();
        tabSheet.addTab(tabOne.pacientComponent(), "Patients");
        //mark two
        TabTwo tabTwo = new TabTwo();
        tabSheet.addTab(tabTwo.doctorComponent(), "Doctors");

        TabThree tabThree = new TabThree();
        tabSheet.addTab(tabThree.qwerty(), "Recipe");


        setContent(generallayout);
    }


}