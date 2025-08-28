package com.example.tech;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class LoginPage extends AppCompatActivity {

    private FirebaseAuth auth;
  private EditText loginemail, loginpass;
    private Button login;

    private TextView gotosignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        auth = FirebaseAuth.getInstance();
        loginemail = findViewById(R.id.loginemail);
        loginpass = findViewById(R.id.loginpass);
        login = findViewById(R.id.loginbtn);
        gotosignup = findViewById(R.id.gosinup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginemail.getText().toString();
                String pass = loginpass.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!pass.isEmpty()){
                        auth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(LoginPage.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                Intent home = new Intent(LoginPage.this,MainActivity.class);
                                startActivity(home);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginPage.this, "Login Filed", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }else {
                        loginpass.setError("Password can't be empty");
                    }
                    }else {
                        loginemail.setError("Enter vaild email");
                    }
                }
        });

        gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(LoginPage.this,SignupPage.class);
                startActivity(signup);
            }
        });
    }
}