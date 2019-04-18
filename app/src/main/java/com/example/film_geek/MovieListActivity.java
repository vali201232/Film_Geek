package com.example.film_geek;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listView;
    SearchView searchView;
    List<Movie> movieList;
    ArrayAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);
        movieList = new ArrayList<>();
        final Movie testMovie = new Movie("The Wolf of Wall Street", "Martin Scorsese", "Leonardo DiCaprio",
                "Comedy", "English", "United States of America", "2013", "180");
        movieList.add(testMovie);

        listAdapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movieList);
        listView.setAdapter(listAdapter);

        readData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MovieListActivity.this, OnClickActivity.class);

                Movie movie= (Movie) adapterView.getItemAtPosition(i);
                intent.putExtra("movieObject", movie);
                startActivity(intent);


            }
        });

    }

    public void readData() {
        final String TAG = "readData";
        db.collection("movie")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                movieList.add(document.toObject(Movie.class));

                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                        listAdapter.notifyDataSetChanged();
                    }
                });
    }



}
