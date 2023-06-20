package com.example.crudandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtMa, txtTen, txtSoLuong;
    Button btnThem, btnSua, btnXoa, btnHienThi;
    ListView listView;

    ArrayAdapter<String> arrayAdapter;
    SanPhamDAO sanphamDao;
    List<String> list = new ArrayList<>();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMa = findViewById(R.id.txtMa);
        txtTen= findViewById(R.id.txtTen);
        txtSoLuong= findViewById(R.id.txtSoLuong);
        btnThem = findViewById(R.id.BtnThem);
        btnSua = findViewById(R.id.BtnSua);
        btnXoa = findViewById(R.id.BtnXoa);
        btnHienThi = findViewById(R.id.BtnHienThi);
        listView = findViewById(R.id.ListView);

        // khoi tao cac bien
        context = this;
        list.clear(); // xoa het nd trong list

        // hien thi du lieu
        sanphamDao =  new SanPhamDAO(context); // tao csdl va bang du lieu

        list = sanphamDao.getAllSanPhamToString();

        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(arrayAdapter);

        // button hien thi
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear(); // xoa het nd trong list

                // hien thi du lieu
                sanphamDao =  new SanPhamDAO(context); // tao csdl va bang du lieu

                list = sanphamDao.getAllSanPhamToString();

                arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);

                listView.setAdapter(arrayAdapter);
            }
        });

        // buton them

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham s = new SanPham(); // tao san pham chua du lieu nguoi dung nhap
                // dua du lieu vao doi tuong
                s.setMaSP(txtMa.getText().toString());
                s.setTenSP(txtTen.getText().toString());
                s.setSoLuongSP(Integer.parseInt(txtSoLuong.getText().toString()));

                int kq = sanphamDao.InsertSanPham(s);

                if (kq == - 1) {
                    Toast.makeText(context, "Insert that bai", Toast.LENGTH_LONG).show();
                }

                if (kq ==  1) {
                    Toast.makeText(context, "Insert thanh cong", Toast.LENGTH_LONG).show();

                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String masp = txtMa.getText().toString();
                int kq = sanphamDao.DeleteSanPham(masp);

                if (kq == - 1) {
                    Toast.makeText(context, "xoa that bai", Toast.LENGTH_LONG).show();
                }

                if (kq ==  1) {
                    Toast.makeText(context, "xoa thanh cong", Toast.LENGTH_LONG).show();

                }
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham s = new SanPham(); // tao san pham chua du lieu nguoi dung nhap
                // dua du lieu vao doi tuong
                s.setMaSP(txtMa.getText().toString());
                s.setTenSP(txtTen.getText().toString());
                s.setSoLuongSP(Integer.parseInt(txtSoLuong.getText().toString()));

                int kq = sanphamDao.UpdateSanPham(s);

                if (kq == - 1) {
                    Toast.makeText(context, "update that bai", Toast.LENGTH_LONG).show();
                }

                if (kq ==  1) {
                    Toast.makeText(context, "update thanh cong", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}