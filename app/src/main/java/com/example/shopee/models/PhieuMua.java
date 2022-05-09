package com.example.shopee.models;

public class PhieuMua {
    public int maPM,maSP,soLuong,tongTien;
    public String taiKhoan;

    public PhieuMua() {
    }

    public PhieuMua(int maPM, int maSP, int soLuong, int tongTien, String taiKhoan) {
        this.maPM = maPM;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.taiKhoan = taiKhoan;
    }
}
