package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText etClubName,etClubAddress,etClubType,etClubFee;
    Button btUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etClubName= findViewById(R.id.etClubName);
        etClubAddress=findViewById(R.id.etClubAddress);
        etClubType= findViewById(R.id.etClubType);
        etClubFee= findViewById(R.id.etClubFee);
        btUpdate= findViewById(R.id.btUpdate);

        String id = getIntent().getStringExtra("id");
        String clubname= getIntent().getStringExtra("clubname");
        String clubaddress= getIntent().getStringExtra("clubaddress");
        String clubtype= getIntent().getStringExtra("clubtype");
        String clubentryfee= getIntent().getStringExtra("clubentryfee");


        etClubName.setText(clubname);
        etClubAddress.setText(clubaddress);
        etClubType.setText(clubtype);
        etClubFee.setText(clubentryfee);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,address,type ,entryfee;
                name= etClubName.getText().toString();
                address=etClubAddress.getText().toString();
                type= etClubType.getText().toString();
                entryfee= etClubFee.getText().toString();
                ClubDBOpenHelper clubdb= new ClubDBOpenHelper(UpdateActivity.this);
                clubdb.updateData(id,name,type,address,entryfee);

                Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UpdateActivity.this, ClubListActivity.class);
                startActivity(intent);
            }
        });
    }
}