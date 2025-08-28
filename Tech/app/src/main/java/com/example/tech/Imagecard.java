package com.example.tech;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Imagecard extends AppCompatActivity {

    EditText name1,fname1,mname1,gender1,addresse1,mobile1;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imagecard);

        name1 = findViewById(R.id.addName);
        fname1 = findViewById(R.id.addFname);
        mname1 = findViewById(R.id.addMname);
        gender1 = findViewById(R.id.addGender);
        addresse1 = findViewById(R.id.addAddresse);
        mobile1 = findViewById(R.id.addMob);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = name1.getText().toString();
                String fname = fname1.getText().toString();
                String mname = mname1.getText().toString();
                String gender = gender1.getText().toString();
                String addresse = addresse1.getText().toString();
                String mobile = mobile1.getText().toString();

                DatabaseReference db = FirebaseDatabase.getInstance().getReference("Add Details");
                String user =  db.push().getKey();
                HelperAdddetails hp = new HelperAdddetails(name,fname,mname,gender,addresse,mobile);
                db.child(user).setValue(hp);

                Toast.makeText(Imagecard.this,"Add Details Successfully",Toast.LENGTH_SHORT).show();


            }
        });


    }
}