package com.example.film_geek;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable {
    String name,regisseur, leadingActor, genre, language, country;
    String year, movieLength;

    public Movie(String name, String regisseur, String leadingActor, String genre, String language, String country, String year, String movieLength) {
        this.name = name;
        this.regisseur = regisseur;
        this.leadingActor = leadingActor;
        this.genre = genre;
        this.language = language;
        this.country = country;
        this.year = year;
        this.movieLength = movieLength;
    }

    public Movie() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public String getLeadingActor() {
        return leadingActor;
    }

    public void setLeadingActor(String leadingActor) {
        this.leadingActor = leadingActor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(String movieLength) {
        this.movieLength = movieLength;
    }

    @Override
    public String toString() {
        return name + "\n" +"Regie: " +regisseur+"\n"+"Actors "+leadingActor+"\n"+"Year: "+year+"\n"+movieLength+" min";

    }
}
