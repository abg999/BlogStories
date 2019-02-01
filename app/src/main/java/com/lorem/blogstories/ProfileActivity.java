package com.lorem.blogstories;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    String email,username,photo;
    FirebaseAuth mAuth;

    Uri url;

    TextView u,e;

    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        u = (TextView) findViewById(R.id.username);
        e = (TextView) findViewById(R.id.email);

        logout = (Button) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });



        email = getIntent().getStringExtra("email");
        username = getIntent().getStringExtra("username");
        photo = getIntent().getStringExtra("photo");
//
//       url = Uri.parse(  photo);

       u.setText(username);
       e.setText(email);


    }
    public void onStart(){
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();

        if(user == null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
