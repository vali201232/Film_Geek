package com.example.film_geek;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button button;
    EditText emailText;
    EditText passwordText;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             String   email =emailText.getText().toString();
              String password = passwordText.getText().toString();
            register(email, password);

           }
       });

    }


public void register(String email, String password){
    mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        Log.d("Register ", "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent i = new Intent(MainActivity.this, MovieListActivity.class);
                        startActivity(i);

                    } else {

                        Log.w("Register", "createUserWithEmail:failure", task.getException());


                    }
                }
            });
}

}
