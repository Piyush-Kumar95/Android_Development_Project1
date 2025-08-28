package com.example.tech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupPage extends AppCompatActivity {

    private FirebaseAuth auth;

   private EditText email,password;
    private Button sign;
    private TextView gologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page);

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.signemail);
        password = findViewById(R.id.signpass);
        gologin = findViewById(R.id.gologinpage);
        sign = findViewById(R.id.signupbtn);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if (user.isEmpty()|| pass.isEmpty()){
                    Toast.makeText(SignupPage.this, "Emter email and password", Toast.LENGTH_SHORT).show();
                }else {
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignupPage.this, "Successfully Sign Up", Toast.LENGTH_SHORT).show();
                                Intent login = new Intent(SignupPage.this,LoginPage.class);
                                startActivity(login);
                            }else {
                                Toast.makeText(SignupPage.this, "Sign Up failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }

            }
        });

        gologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginpage = new Intent(SignupPage.this,LoginPage.class);
                startActivity(loginpage);
            }
        });

    }
}