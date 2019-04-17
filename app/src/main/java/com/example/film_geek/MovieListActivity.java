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
    ArrayAdapter ListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);
        movieList = new ArrayList<>();


    }

    public void fillListView(List<Movie> list) {

        listView.setAdapter(ListAdapter);

    }
}
