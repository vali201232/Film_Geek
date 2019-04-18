package com.example.film_geek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class OnClickActivity extends AppCompatActivity {
    TextView name;
    TextView regisseur;
    TextView genre;
    Movie movie;
    String movieName;
    String regieName;
    String genreMovie;
    TextView year;
    RatingBar ratingBar;
    TextView actor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click);
        name = findViewById(R.id.nameMovie);
        regisseur = findViewById(R.id.Regie);
        genre = findViewById(R.id.genreMovie);
        year = findViewById(R.id.year);
        ratingBar = findViewById(R.id.ratingBar);
        actor = findViewById(R.id.Actor);
        movie = (Movie) getIntent().getSerializableExtra("movieObject");
        movieName = movie.getName();
        regieName = movie.getRegisseur();
        genreMovie = movie.getGenre();
        name.setText(movieName);
        regisseur.setText(regieName);
        genre.setText(genreMovie);
        year.setText(movie.getYear());
        actor.setText(movie.getLeadingActor());

    }
}
