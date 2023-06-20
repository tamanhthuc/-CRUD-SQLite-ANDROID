package com.example.crudandroid;

public class SanPham {
    private String maSP;
    private String tenSP;
    private int soLuongSP;

    public SanPham(String maSP, String tenSP, int soLuongSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuongSP = soLuongSP;
    }

    public SanPham() {
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }
}
