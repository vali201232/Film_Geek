package com.example.film_geek;

import java.io.Serializable;

public class Friend implements Serializable {
    String name;

    public Friend(String name) {
        this.name = name;
    }

    public Friend() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Email: "+name;
    }
}
