package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(SplashScreen.this,"Successfully Splash the screen",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SplashScreen.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}