package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ClubListActivity extends AppCompatActivity {

    Button btView;
    int positionClicked = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_list);

        loadClub();
    }

    private void loadClub() {

        ListView listView = findViewById(R.id.lvClubList);

        List<String> ClubId = new ArrayList<>();
        List<String> ClubName = new ArrayList<>();
        List<String> ClubAddress = new ArrayList<>();
        List<String> ClubTypes = new ArrayList<>();
        List<String> ClubFee = new ArrayList<>();

        ClubDBOpenHelper openHelper = new ClubDBOpenHelper(ClubListActivity.this);
        Cursor cursor = openHelper.readClubDetail();

        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String address = cursor.getString(2);
            String type = cursor.getString(3);
            String fee = cursor.getString(4);

            ClubId.add(id);
            ClubName.add(name);
            ClubAddress.add(address);
            ClubTypes.add(type);
            ClubFee.add(fee);

        }
        MyListAdapter adapter = new MyListAdapter(ClubListActivity.this, ClubName, ClubAddress, ClubTypes, ClubFee);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PopupMenu popupMenu = new PopupMenu(ClubListActivity.this, view);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getItemId() == R.id.itemDelete) {
                            String id = ClubId.get(i);
                            Toast.makeText(ClubListActivity.this, "Club Detail of id " + id + "Deleted!", Toast.LENGTH_SHORT).show();
                            ClubDBOpenHelper openHelper1 = new ClubDBOpenHelper(ClubListActivity.this);
                            openHelper1.deleteClubDetail(id);
                            loadClub();
                        } else {
                            if (item.getItemId() == R.id.itemUpdate) {
                                Intent intent = new Intent(ClubListActivity.this, UpdateActivity.class);
                                intent.putExtra("id", ClubId.get(i));
                                intent.putExtra("clubname", ClubName.get(i));
                                intent.putExtra("clubaddress", ClubAddress.get(i));
                                intent.putExtra("clubtype", ClubTypes.get(i));
                                intent.putExtra("clubentryfee", ClubFee.get(i));
                                startActivity(intent);

                            }
                        }

                        return true;
                    }

                });
                popupMenu.show();
                positionClicked = i;
            }
        });

    }


}