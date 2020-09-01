package com.haulmont.testtask;

//for binder
public class Patient {
    private String firstName = "";
    private String lastName = "";
    private String patronymic = "";
    private String telephone = "";
    public Patient(){
        super();
        //System.out.println("initialization patient constructor default");
    }

    public Patient(String firstName, String lastName, String patronymic, String telephone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.telephone = telephone;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
        System.out.println(firstName);
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
        System.out.println(lastName);

    }


    public String getPatronymic(){
        return patronymic;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
        System.out.println(patronymic);

    }

    public String getTelephone(){
        return telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
        System.out.println(telephone);

    }
}
