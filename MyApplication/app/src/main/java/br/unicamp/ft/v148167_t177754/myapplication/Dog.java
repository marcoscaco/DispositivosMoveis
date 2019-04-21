package br.unicamp.ft.v148167_t177754.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    private int picture;
    private String overview;
    private String age;
    private String sex;
    private String raca;
    private String name;

    public Dog(int picture, String overview, String age, String sex, String raca, String name) {
        this.picture = picture;
        this.overview = overview;
        this.age = age;
        this.sex = sex;
        this.raca = raca;
        this.name = name;
    }




    public String getName() { return name; }

    public void setName(String name) { this.name = name;  }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
