package com.example.film_geek;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
    Button shareButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click);
        name = findViewById(R.id.nameMovie);
        regisseur = findViewById(R.id.Regie);
        shareButton = findViewById(R.id.share);
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

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(OnClickActivity.this)
                        .setTitle("Share with your Frieds")
                        .setMessage("Do you wanna share " + movieName +" with your Friends?")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(OnClickActivity.this, ShareWithFriendsActivity.class);
                                startActivity(intent);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

    }
}
