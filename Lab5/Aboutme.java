package com.company;

import java.util.ArrayList;

public class Aboutme {
    private static int counter = 0;
    private int id;
    private String name;
    private String hobby;
    private String eyes;
    private String stat;
    private int age;
    private ArrayList<Partner> partner;

    public Aboutme(){
        partner = new ArrayList<>();
        id = counter++;
    }
    public static void cleanAboutme(){

        counter = 0;
    }
    public void addPartner(Partner part){

        partner.add(part);
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {

        this.hobby = hobby;
    }

    public String getEyes() {

        return eyes;
    }

    public void setEyes(String eyes) {

        this.eyes = eyes;
    }
    public String getStat() {

        return stat;
    }

    public void setStat(String stat) {

        this.stat = stat;
    }
    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public int getId() {

        return id;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("-----------------------------------------\n");
        str.append("ID: ").append(id).append("\n");
        str.append("Ім'я: ").append(name).append("\n");
        str.append("Хобі: ").append(hobby).append("\n");
        str.append("Колір очей: ").append(eyes).append("\n");
        str.append("Стать: ").append(stat).append("\n");
        str.append("Вік: ").append(age).append("у.о.\n");
        str.append("Вимоги до партнера:\n");
        int count = 0;
        for(Partner part : partner){
            str.append("\t").append(count).append(". ").append(part.toString()).append("\n");
        }
        str.append("-----------------------------------------");
        return str.toString();
    }
}
