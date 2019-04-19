package com.example.film_geek;

class Recommendation {
    String from, to, movieName;

    public Recommendation(String from, String to, String movieName) {
        this.from = from;
        this.to = to;
        this.movieName = movieName;
    }

    public Recommendation() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
