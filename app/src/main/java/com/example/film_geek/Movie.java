package com.example.film_geek;

import java.util.Date;

public class Movie {
    String name,regisseur, leadingActor, supportingActor,genre;
    int year;
    int movieLength;
    public Movie(String name, String regisseur, String leadingActor, String supportingActor, int year, int movieLength, String genre) {
        this.name = name;
        this.regisseur = regisseur;
        this.leadingActor = leadingActor;
        this.supportingActor = supportingActor;
        this.year = year;
        this.movieLength=movieLength;
        this.genre=genre;
    }

    @Override
    public String toString() {
        return name + "\n" +"Regie: " +regisseur+"\n"+"Actors "+leadingActor+", "+supportingActor+"\n"+"Year: "+year+"\n"+movieLength+" min";

    }
}
