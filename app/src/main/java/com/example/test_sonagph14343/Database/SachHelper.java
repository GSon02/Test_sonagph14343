package com.example.test_sonagph14343.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.test_sonagph14343.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachHelper extends SQLiteOpenHelper {
    public SachHelper(Context context) {
        super(context, "qls", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SACH ( ID INTEGER PRIMARY KEY, NAME NVARCHAR, EMAIL NVARCHAR)");
        db.execSQL("INSERT INTO SACH VALUES (1,\"SACH1\",\"S1\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SACH");
        onCreate(db);
    }

    public long insertSach(Sach sach){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ID",sach.getID());
        contentValues.put("NAME",sach.getName());
        contentValues.put("EMAIL",sach.getEmail());

        long result = sqLiteDatabase.insert("SACH", null, contentValues);
        return result;
    }
    public long updateSach(Sach sach){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ID",sach.getID());
        contentValues.put("NAME",sach.getName());
        contentValues.put("EMAIL",sach.getEmail());

        long result = sqLiteDatabase.update("SACH", contentValues,"ID=?",new String[]{String.valueOf(sach.getID())});
        return result;
    }
    public long deleteSach(Sach sach){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        long result = sqLiteDatabase.delete("SACH","ID=?",new String[]{String.valueOf(sach.getID())});
        return result;
    }

    public List<Sach> getAllSach(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<Sach> sachList = new ArrayList<>();
        String SELecT_AlL = "SeLeCt * FrOm SACH";
        Cursor cursor = sqLiteDatabase.rawQuery(SELecT_AlL,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String id = cursor.getString(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("NAME"));
                String ma = cursor.getString(cursor.getColumnIndex("EMAIL"));
                Sach sach = new Sach(Integer.parseInt(id),name,ma);
                sachList.add(sach);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sachList;
    }
}
