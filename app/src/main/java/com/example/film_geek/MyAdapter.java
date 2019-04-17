package com.example.film_geek;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {
    List<Movie> movieList;
    LayoutInflater li;
    private int resource;
    public MyAdapter(@NonNull Context context, int resource, List<Movie> movieList) {
        super(context, resource);
        this.li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.resource=resource;
        this.movieList=movieList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = (convertView==null)?li.inflate(this.resource,null):convertView;
        






        return super.getView(position, convertView, parent);

    }
}
