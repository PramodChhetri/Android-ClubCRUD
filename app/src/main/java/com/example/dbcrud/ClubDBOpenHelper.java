package com.example.dbcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClubDBOpenHelper extends SQLiteOpenHelper {

    public ClubDBOpenHelper(@Nullable Context context) {
        super(context, "clubdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStatement = "CREATE TABLE club(id INTEGER PRIMARY KEY, clubname TEXT, clubaddress TEXT, clubtype TEXT, clubentryfee TEXT)";
        db.execSQL(createStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "clubdb");
    }

    public void insertClubDetails(String name,String location, String type, String entryfee){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("clubname",name);
        cv.put("clubaddress",location);
        cv.put("clubtype",type);
        cv.put("clubentryfee",entryfee);
        sqLiteDatabase.insert("club", null, cv);
        sqLiteDatabase.close();
    }

    public Cursor readClubDetail(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String readQuery = "SELECT * FROM club";
        Cursor cursor= sqLiteDatabase.rawQuery(readQuery,null);
        return cursor;
    }

    public void updateData(String id, String name, String type, String address,String entryfee){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("clubname",name);
        cv.put("clubaddress",address);
        cv.put("clubtype",type);
        cv.put("clubentryfee",entryfee);
        sqLiteDatabase.update("club",cv,"id=?", new String[]{id});
        sqLiteDatabase.close();
    }

    public void deleteClubDetail(String id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("club","id=?", new String[]{id});
    }

}
