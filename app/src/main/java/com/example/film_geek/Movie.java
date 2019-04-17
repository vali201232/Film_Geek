package com.example.film_geek;

import java.util.Date;

public class Movie {
    String name,regisseur, leadingActor, supportingActor,genre;
    Date launchDate;
    int movieLength;
    public Movie(String name, String regisseur, String leadingActor, String supportingActor, Date launchDate, int movieLength, String genre) {
        this.name = name;
        this.regisseur = regisseur;
        this.leadingActor = leadingActor;
        this.supportingActor = supportingActor;
        this.launchDate = launchDate;
        this.movieLength=movieLength;
        this.genre=genre;
    }

    @Override
    public String toString() {
        return name + "\n" +"Regie: " +regisseur+"\n "+"Actors "+leadingActor+", "+supportingActor+"\n"+"Launchdate: "+launchDate+"\n"+movieLength+" min";

    }
}
