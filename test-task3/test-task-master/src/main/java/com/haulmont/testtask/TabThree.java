package com.haulmont.testtask;

import com.haulmont.testtask.create.CreatePatient;
import com.haulmont.testtask.create.CreateRecipe;
import com.vaadin.ui.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TabThree {

    public Component qwerty(){
        Label label = new Label("Create Recipe");
        FormLayout formLayout = new FormLayout();

        TextField name1 = new TextField("description");
        TextField name2 = new TextField("patient");
        TextField name3 = new TextField("doctor");
        //TextField name4 = new TextField("dateCreate");
        TextField priorityChoose = new TextField("priority");
        priorityChoose.setReadOnly(true);

        MenuBar barmenu = new MenuBar();
        MenuBar.Command mycommandNormal = new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                priorityChoose.setReadOnly(false);
                priorityChoose.setValue("Normal");
                priorityChoose.setReadOnly(true);
            }
        };
        MenuBar.Command mycommandCito = new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                priorityChoose.setReadOnly(false);
                priorityChoose.setValue("Cito");
                priorityChoose.setReadOnly(true);
            }
        };
        MenuBar.Command mycommandStatim = new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                priorityChoose.setReadOnly(false);
                priorityChoose.setValue("Statim");
                priorityChoose.setReadOnly(true);
            }
        };
        barmenu.addItem("Normal", mycommandNormal);
        barmenu.addItem("Cito", mycommandCito);
        barmenu.addItem("Statim", mycommandStatim);


        TextField name5 = new TextField("dateValidate");
        TextField name6 = new TextField("priority");

        //button for create recipe
        Button button = new Button("ok");
        button.addClickListener(clickEvent -> {
            formLayout.addComponent(new Label("добавлено " + name1.getValue()));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();
            //new CreateRecipe().create("recipe", name1.getValue(), name2.getValue(), name3.getValue(), simpleDateFormat.format(date), name5.getValue(), priorityChoose.getValue());
            //CreateRecipe createRecipe = new CreateRecipe("recipe", name1.getValue(), name2.getValue(), name3.getValue(), simpleDateFormat.format(date), name5.getValue(), priorityChoose.getValue());
            //createRecipe.getStatement();
            try {
                new CreateRecipe().getCreate("recipe",
                        name1.getValue(), name2.getValue(),
                        name3.getValue(), simpleDateFormat.format(date),
                        name5.getValue(), priorityChoose.getValue());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        Label labelIDPatient = new Label("Enter ID for delete. For change: all fields must be filled)");
        TextField textFieldForID = new TextField("field ID");

        //button for delete recipe
        Button buttonDelete = new Button("delete");
        buttonDelete.addClickListener(clickEvent -> {
            formLayout.addComponent(new Label("delete "));
            try {

                new CreateRecipe().getDelete("recipe", textFieldForID.getValue() );
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        //button for change patient by ID
        Button buttonChange = new Button("change");
        buttonChange.addClickListener(clickEvent -> {
            formLayout.addComponent(new Label("change "));
            //new CreateRecipe().change("recipe", name1.getValue(), name2.getValue(), name3.getValue(), name5.getValue(), priorityChoose.getValue(), textFieldForID.getValue());
            try {
                new CreateRecipe()
                        .getChange("recipe",
                                name1.getValue(), name2.getValue(), name3.getValue(),
                                name5.getValue(), priorityChoose.getValue(), textFieldForID.getValue());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        Grid grid = new Grid();
        grid.addColumn("ID", String.class);
        grid.addColumn("description", String.class);
        grid.addColumn("patient", String.class);
        grid.addColumn("doctor", String.class);
        grid.addColumn("dateCreate", String.class);
        grid.addColumn("dateValidate", String.class);
        grid.addColumn("priority", String.class);

        ArrayList<String> pat = null;
        //pat = new CreateRecipe().select("recipe");
        try {
            pat = new CreateRecipe().getSelecte("recipe");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (int i = 0; i < pat.size(); i += 7){
            grid.addRow(pat.get(i), pat.get(i+1), pat.get(i+2), pat.get(i+3), pat.get(i+4), pat.get(i+5), pat.get(i+6));
        }




        formLayout.addComponents(grid, label,  name1, name2, name3, name5, priorityChoose, barmenu, button,
                                labelIDPatient, textFieldForID, buttonDelete, buttonChange);
        /*
                formLayout.addComponents(
                grid, label, name1, name2, name3, name4, button,
                labelIDPatient, textFieldForID, buttonDelete, buttonChange);
         */


        return formLayout;
    }


}
