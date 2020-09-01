package com.haulmont.testtask.create;

import java.sql.*;
import java.util.ArrayList;

public class CreateDoctor extends CreatePatient{
    Connection connection = null;

    @Override
    public void create(String tableName,
                       String firstName,
                       String lastName,
                       String patronymic,
                       String specialization) throws SQLException {
        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        Statement statement;
        String sqlSupport;
        sqlSupport = "INSERT INTO "
                + tableName + "(firstName, lastName, patronymic, specialization)" +" VALUES ('"
                + firstName + "', '"
                + lastName + "', '"
                + patronymic + "', '"
                + specialization + "');";
        System.out.println(sqlSupport);
        statement = connection.createStatement();
        statement.executeUpdate(sqlSupport);

        statement.close();
        connection.close();
    }

    @Override
    public void change(String tableName,
                       String firstName,
                       String lastName,
                       String patronymic,
                       String specialization,
                       String id) throws SQLException{
        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        Statement statement;
        String sqlSupport;
        sqlSupport = "UPDATE "
                + tableName +" SET "
                //+ id + ", '"
                + "firstName='" + firstName + "', "
                + "lastName='" + lastName + "', "
                + "patronymic='" + patronymic + "', "
                + "specialization='" + specialization + "' "
                + "WHERE id=" + id;
        System.out.println(sqlSupport);
        statement = connection.createStatement();
        statement.executeUpdate(sqlSupport);

        statement.close();
        connection.close();
    }

    @Override
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
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String patronymic = resultSet.getString("patronymic");
            String specialization = resultSet.getString("specialization");

            arrayList.add(id);
            arrayList.add(firstName);
            arrayList.add(lastName);
            arrayList.add(patronymic);
            arrayList.add(specialization);

        }

        resultSet.close();
        statement.close();
        connection.close();
        return arrayList;
    }


}
