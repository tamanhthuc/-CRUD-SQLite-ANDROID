package com.example.crudandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;
    private Context context;

    public SanPhamDAO(Context context) {
        this.context = context;
        dbHelper = new SQLiteHelper(context); // thuc thi tao database
        db = dbHelper.getWritableDatabase(); //cho phep ghi du lieu vao database

    }

    //1. them du lieu
    public int InsertSanPham(SanPham s) {
        ContentValues values = new ContentValues(); // tao doi tuong chua du lieu
        // du du lieu vao doi tuong chua value

        values.put("maSP", s.getMaSP());
        values.put("tenSP", s.getTenSP());
        values.put("soLuongSP", String.valueOf(s.getSoLuongSP()) );

        // thuc thi insert
        long kq = db.insert("sanpham", null, values);

        // kiem ket qua

        if (kq <= 0) {
            return -1; // insert that bai
        }
        return 1; // insert thanh cong
    }

    // hien thi du lieu dang string

    public List<String> getAllSanPhamToString()
    {
        List<String> ls = new ArrayList<>();

        // tao con tro doc du lieu san pham

        Cursor c = db.query("sanpham", null, null, null, null, null , null);

        c.moveToFirst(); // di chuyen con tro be ban ghi dau tien

        // doc
        while(c.isAfterLast() == false)  {
            SanPham s = new SanPham(); // tao doi tuong moi de chua du lieu

            s.setMaSP(c.getString(0)); // doc du lieu truong masp dua vao doi tuong;
            s.setTenSP(c.getString(1));
            s.setSoLuongSP(c.getInt(2));

            // chuyen doi tuong thanh chuoi

            String chuoi = s.getMaSP() + " - " + s.getTenSP()  + " - " + s.getSoLuongSP();

            ls.add(chuoi);

            c.moveToNext();
        }
        c.close();


        return ls;

    }

    // xoa
    public int DeleteSanPham(String masp) {
        int kq = db.delete("sanpham", "maSP=?", new String[]{masp});

        if (kq <= 0) {
            return -1; // xoa that bai
        }
        return 1; // xoa thanh cong
    }

    // sua

    public int UpdateSanPham(SanPham s) {
        ContentValues values = new ContentValues(); // tao doi tuong chua du lieu
        // du du lieu vao doi tuong chua value

        values.put("maSP", s.getMaSP());
        values.put("tenSP", s.getTenSP());
        values.put("soLuongSP", String.valueOf(s.getSoLuongSP()) );

        // thuc thi update
        long kq = db.update("sanpham", values, "maSP=?", new String[] {s.getMaSP()});

        // kiem ket qua

        if (kq <= 0) {
            return -1; // update that bai
        }
        return 1; // update thanh cong
    }
}
