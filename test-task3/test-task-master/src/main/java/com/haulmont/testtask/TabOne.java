package com.haulmont.testtask;

import com.haulmont.testtask.create.CreatePatient;
import com.vaadin.data.Container;
import com.vaadin.ui.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class TabOne{

    private Container.SimpleFilterable container;

    public Component pacientComponent(){
        Label label = new Label("Create Patient");
        FormLayout formLayout = new FormLayout();
        TextField name1 = new TextField("Name");
        TextField name2 = new TextField("Lastname");
        TextField name3 = new TextField("Patronymic");
        TextField name4 = new TextField("Telephone");

        //button for create patient
        Button button = new Button("ok");
        button.addClickListener(clickEvent -> {
            formLayout.addComponent(new Label("добавлено " + name1.getValue()));
            try {
                new CreatePatient().create("patients", name1.getValue(), name2.getValue(), name3.getValue(), name4.getValue());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        Label labelIDPatient = new Label("Enter ID for delete. For change: all fields must be filled)");
        TextField textFieldForID = new TextField("field ID");
        //button for delete patient
        Button buttonDelete = new Button("delete");
        buttonDelete.addClickListener(clickEvent -> {
            formLayout.addComponent(new Label("delete "));
            try {
                new CreatePatient().delete("patients", textFieldForID.getValue());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        //button for change patient by ID
        Button buttonChange = new Button("change");
        buttonChange.addClickListener(clickEvent -> {
            formLayout.addComponent(new Label("change "));
            try {
                new CreatePatient().change("patients", name1.getValue(), name2.getValue(), name3.getValue(), name4.getValue(), textFieldForID.getValue());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        Grid grid = new Grid();
        grid.setEditorEnabled(true);

        grid.addColumn("ID", String.class);
        grid.addColumn("firstName", String.class);
        grid.addColumn("lastName", String.class);
        grid.addColumn("patronymic", String.class);
        grid.addColumn("telephone", String.class);
        ArrayList<String> pat = null;
        try {
            pat = new CreatePatient().select("patients");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < pat.size(); i += 5){
            grid.addRow(pat.get(i), pat.get(i+1), pat.get(i+2), pat.get(i+3), pat.get(i+4));
        }


        formLayout.addComponents(grid, label, name1, name2, name3, name4, button,
                labelIDPatient, textFieldForID, buttonDelete,
                buttonChange);

        return formLayout;
    }
}
