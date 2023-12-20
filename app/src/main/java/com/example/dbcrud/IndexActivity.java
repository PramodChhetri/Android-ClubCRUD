package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Button btAdd = findViewById(R.id.btAddClub);
        Button btView= findViewById(R.id.btViewClubs);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(IndexActivity.this, AddClubActivity.class);
                startActivity(i);
            }
        });

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(IndexActivity.this, ClubListActivity.class);
                startActivity(i);
            }
        });


    }
}