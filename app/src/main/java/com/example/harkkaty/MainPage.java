package com.example.harkkaty;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainPage<onStart> extends AppCompatActivity {
    private ImageButton logOut;
    FirebaseAuth auth;
    BottomNavigationItemView bottomNavigationItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        logOut = findViewById(R.id.LogOut);
        auth = FirebaseAuth.getInstance();



        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //bottomNavigationItemView = findViewById(R.id.bottomNavigationView);

        logOut.setOnClickListener(view -> {
            auth.signOut();
            startActivity(new Intent( MainPage.this, MainLogin.class));
        });
/*
        bottomNavigationItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainPage.this, "Toimiiii", Toast.LENGTH_SHORT).show();
            }
        });

 */


    }
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(MainPage.this, MainLogin.class));
        }
    }

}