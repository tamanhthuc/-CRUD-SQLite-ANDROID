package com.example.crudandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final  String SQL_SANPHAM = "CREATE TABLE sanpham (maSP text PRIMARY KEY, tenSP text, soLuongSP text)";

    public SQLiteHelper(@Nullable Context context) {
        super(context, "QlBH.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_SANPHAM );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sanpham");
    }
}
