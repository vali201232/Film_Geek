package com.example.film_geek;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.SearchView;

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
    SearchView searchViewMovies;
    List<Friend> sendingList;
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
        searchViewMovies = findViewById(R.id.searchViewMovies);
        sendingList = new ArrayList<>();


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
        searchViewMovies.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                listAdapter.getFilter().filter(s);
                return false;
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
                String string="";
                String friendsString="";

                for (int i = 0; i < listSelectedFriends.size(); i++) {
                   sendingList.add(listSelectedFriends.get(i));
                }
                for (int i = 0; i < sendingList.size(); i++) {
                    string =string+ sendingList.get(i).getName().toString();

                }
                friendsString=friendsString+string+"\n";
                new AlertDialog.Builder(ShareWithFriendsActivity.this)
                        .setTitle("Do you wanna share this Movie with your Friends")
                        .setMessage(string)

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                //Connect with DB

                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.star_big_on)
                        .show();


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
                                Friend friend = new Friend();
                                String string =document.getData().toString().replace('{', ' ');

                                 String[] stringarr = string.split("=");
                                friend.setName(stringarr[0]);
                            friendList.add(friend);
                            }
                        } else {
                            Log.w("Read Data share", "Error getting documents.", task.getException());
                        }
                        listAdapter.notifyDataSetChanged();
                    }
                });


    }

}
