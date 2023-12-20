package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddClubActivity extends AppCompatActivity {

    EditText etClubName,etClubAddress,etClubType,etClubFee;
    Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_club);

        etClubName= findViewById(R.id.etClubName);
        etClubAddress= findViewById(R.id.etClubAddress);
        etClubType= findViewById(R.id.etClubType);
        etClubFee= findViewById(R.id.etClubFee);
        btSave= findViewById(R.id.btSave);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name,address,type ,entryfee;
                name= etClubName.getText().toString();
                address=etClubAddress.getText().toString();
                type= etClubType.getText().toString();
                entryfee= etClubFee.getText().toString();
                ClubDBOpenHelper clubdb= new ClubDBOpenHelper(AddClubActivity.this);
                clubdb.insertClubDetails(name,address,type,entryfee);

                Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

            }
        });


    }
}