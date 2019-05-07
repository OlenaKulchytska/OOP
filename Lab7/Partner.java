package com.company;

import java.io.Serializable;

public class Partner implements Serializable{
    private String hobby;
    private int age;
    private String eyes;

    public String getHobby() {

        return hobby;
    }

    public void setHobby(String hobby) {

        this.hobby = hobby;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public String getEyes() {

        return eyes;
    }

    public void setEyes(String eyes) {

        this.eyes = eyes;
    }
    public String toString(){
        return new String("Хобі: " + hobby + ", Вік: " + age + " Колір очей: " + eyes );
    }
}

