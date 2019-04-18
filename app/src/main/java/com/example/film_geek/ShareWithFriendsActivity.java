package com.example.film_geek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShareWithFriendsActivity extends AppCompatActivity {
    Button shareButton;
    ListView listViewFriends;
    Button backButton;
    ArrayAdapter<String> listAdapter;
    ArrayAdapter<String> selectedFriendsAdapter;
    List<String> friendList;
    List<String> listSelectedFriends;

    ListView selectedFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_with_friends);
        shareButton = findViewById(R.id.shareButton);
        listViewFriends = findViewById(R.id.listViewFriends);
        backButton = findViewById(R.id.backButton);
        selectedFriends = findViewById(R.id.selectedFriends);
        friendList = new ArrayList<>();
        listSelectedFriends = new ArrayList<>();
        friendList.add("Valentin Kellermair");
        friendList.add("Sebastian Kronschläger");
        friendList.add("Laurenz Popostecha");
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendList);
        selectedFriendsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSelectedFriends);
        listViewFriends.setAdapter(listAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShareWithFriendsActivity.this, OnClickActivity.class);
                startActivity(intent);
            }
        });
        listViewFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = (String) adapterView.getItemAtPosition(i);
                listSelectedFriends.add(s);
                friendList.remove(i);
                listAdapter.notifyDataSetChanged();
                selectedFriends.setAdapter(selectedFriendsAdapter);

            }
        });
        selectedFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = (String) adapterView.getItemAtPosition(i);
                friendList.add(s);
                listSelectedFriends.remove(i);
                selectedFriendsAdapter.notifyDataSetChanged();
                listViewFriends.setAdapter(listAdapter);
            }
        });



        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
