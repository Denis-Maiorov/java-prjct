package com.haulmont.testtask.create;

import java.sql.*;
import java.util.ArrayList;

public class CreateRecipe{
    Connection connection = null;
    private Statement statement = null;

    public Statement getCreate(String tableName, String description, String patient, String doctor,
                               String dateCreate, String dateValidate, String priority) throws SQLException {
        create(tableName, description, patient, doctor, dateCreate, dateValidate, priority);
        return statement;
    }
    public Statement getDelete(String tableName, String id) throws SQLException {
        delete(tableName, id);
        return statement;
    }
    public Statement getChange(String tableName, String description, String patient,
                               String doctor, String dateValidate, String priority,
                               String id) throws SQLException {
        change(tableName, description, patient, doctor, dateValidate, priority, id);
        return statement;
    }
    public ArrayList<String> getSelecte(String tableName) throws SQLException {
        ArrayList<String> list = select(tableName);
        return list;
    }


    private Statement create(String tableName,
                             String description,
                             String patient,
                             String doctor,
                             String dateCreate,
                             String dateValidate,
                             String priority) throws SQLException {

        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        //Statement statement;
        String sqlSupport;
        sqlSupport = "INSERT INTO "
                + tableName + "(description, patient, doctor, dateCreate, dateValid, priority)" +" VALUES ('"
                + description + "', '"
                + patient + "', '"
                + doctor + "', '"
                + dateCreate + "', '"
                + dateValidate + "', '"
                + priority + "');";
        System.out.println(sqlSupport);
        statement = connection.createStatement();
        statement.executeUpdate(sqlSupport);

        //statement.close();
        connection.close();
        return statement;
    }


    private Statement delete(String tableName, String id) throws SQLException {
        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        Statement statement;
        String sqlSupport;
        sqlSupport = "DELETE FROM "
                + tableName +" WHERE ID = "
                //+ id + ", '"
                + id;
        System.out.println(sqlSupport);
        statement = connection.createStatement();
        statement.executeUpdate(sqlSupport);

        //statement.close();
        connection.close();
        return statement;
    }

    private Statement change(String tableName,
                       String description,
                       String patient,
                       String doctor,
                       //String dateCreate,
                       String dateValidate,
                       String priority,
                       String id) throws SQLException{
        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        Statement statement;
        String sqlSupport;
        sqlSupport = "UPDATE "
                + tableName +" SET "
                + "description='" + description + "', "
                + "patient='" + patient + "', "
                + "doctor='" + doctor + "', "
                //+ "dateCreate='" + dateCreate + "', "
                + "dateValid='" + dateValidate + "', "
                + "priority='" + priority + "' "
                + "WHERE id=" + id;
        System.out.println(sqlSupport);
        statement = connection.createStatement();
        statement.executeUpdate(sqlSupport);

        //statement.close();
        connection.close();
        return statement;
    }

    public ArrayList<String> select(String tableName) throws SQLException {
        ArrayList<String> arrayList = new ArrayList<>();

        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        Statement statement;
        String sqlSupport;
        sqlSupport = "SELECT * FROM " + tableName;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlSupport);
        while (resultSet.next()){
            String id = resultSet.getString("ID");
            String description = resultSet.getString("description");
            String patient = resultSet.getString("patient");
            String doctor = resultSet.getString("doctor");
            String dateCreate = resultSet.getString("dateCreate");
            String dateValidate = resultSet.getString("dateValid");
            String priority = resultSet.getString("priority");

            arrayList.add(id);
            arrayList.add(description);
            arrayList.add(patient);
            arrayList.add(doctor);
            arrayList.add(dateCreate);
            arrayList.add(dateValidate);
            arrayList.add(priority);

        }
        resultSet.close();
        statement.close();
        connection.close();
        return arrayList;
    }

}
