package com.example.film_geek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

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
        Movie testMovie = new Movie("The Wolf of Wall Street", "Martin Scorsese", "Leonardo DiCaprio", "Jonah Hill", 2013, 180, "Comedy");
        movieList.add(testMovie);
        listAdapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movieList);
        listView.setAdapter(listAdapter);
    }


}
