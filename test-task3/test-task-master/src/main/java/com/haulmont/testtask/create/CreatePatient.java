package com.haulmont.testtask.create;

import java.sql.*;
import java.util.ArrayList;

public class CreatePatient {
    Connection connection = null;

    public void create(String tableName,
                       String firstName,
                       String lastName,
                       String patronymic,
                       String telephone) throws SQLException {
        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
        Statement statement;
        String sqlSupport;
        sqlSupport = "INSERT INTO "
                + tableName + "(firstName, lastName, patronymic, telephone)" +" VALUES ('"
                //+ id + ", '"
                + firstName + "', '"
                + lastName + "', '"
                + patronymic + "', '"
                + telephone + "');";
        System.out.println(sqlSupport);
        statement = connection.createStatement();
        statement.executeUpdate(sqlSupport);
        System.out.println(statement);

        statement.close();
        connection.close();
    }

    public void delete(String tableName, String id) throws SQLException {
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

        statement.close();
        connection.close();
    }

    public void change(String tableName,
                       String firstName,
                       String lastName,
                       String patronymic,
                       String telephone,
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
                + "telephone='" + telephone + "' "
                + "WHERE id=" + id;
        System.out.println(sqlSupport);
        statement = connection.createStatement();
        statement.executeUpdate(sqlSupport);

        statement.close();
        connection.close();
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
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String patronymic = resultSet.getString("patronymic");
            String telephone = resultSet.getString("telephone");

            /*
            System.out.print(id);
            System.out.print(firstName);
            System.out.print(lastName);
            System.out.print(patronymic);
            System.out.println(telephone);
             */
            arrayList.add(id);
            arrayList.add(firstName);
            arrayList.add(lastName);
            arrayList.add(patronymic);
            arrayList.add(telephone);

        }

        resultSet.close();
        statement.close();
        connection.close();
        return arrayList;
    }


}
