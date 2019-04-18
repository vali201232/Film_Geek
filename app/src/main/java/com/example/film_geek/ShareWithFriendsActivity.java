package com.example.film_geek;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShareWithFriendsActivity extends AppCompatActivity {
    FirebaseFirestore db;
    Button shareButton;
    ListView listViewFriends;
    Button backButton;
    ArrayAdapter<Friend> listAdapter;
    ArrayAdapter<Friend> selectedFriendsAdapter;
   List<Friend> friendList;
   List<Friend> listSelectedFriends;
    ListView selectedFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_with_friends);
         db = FirebaseFirestore.getInstance();
        shareButton = findViewById(R.id.shareButton);
        listViewFriends = findViewById(R.id.listViewFriends);
        backButton = findViewById(R.id.backButton);
        selectedFriends = findViewById(R.id.selectedFriends);
        friendList = new ArrayList<>();
        listSelectedFriends = new ArrayList<>();


        //friendList.add("Valentin Kellermair");
        //friendList.add("Sebastian Kronschläger");
        //friendList.add("Laurenz Popostecha");
        listAdapter = new ArrayAdapter<Friend>(this, android.R.layout.simple_list_item_1, friendList);
        selectedFriendsAdapter = new ArrayAdapter<Friend>(this, android.R.layout.simple_list_item_1, listSelectedFriends);
        listViewFriends.setAdapter(listAdapter);
        readData();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listViewFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Friend f = (Friend) adapterView.getItemAtPosition(i);
                listSelectedFriends.add(f);
                friendList.remove(i);
                listAdapter.notifyDataSetChanged();
                selectedFriends.setAdapter(selectedFriendsAdapter);

            }
        });
        selectedFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Friend friend = (Friend) adapterView.getItemAtPosition(i);
                friendList.add(friend);
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

    public void readData(){
        db.collection("user")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Read Data share", document.getId() + " => " + document.getData());
                            friendList.add(document.toObject(Friend.class));
                            }
                        } else {
                            Log.w("Read Data share", "Error getting documents.", task.getException());
                        }
                        listAdapter.notifyDataSetChanged();
                    }
                });


    }
}
