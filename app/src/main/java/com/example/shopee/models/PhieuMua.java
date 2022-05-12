package com.example.shopee.models;

import java.util.Date;

public class PhieuMua {
    public int maPM,maSP,soLuong,tongTien;
    public String taiKhoan;
    public Date ngay;

    public PhieuMua() {
    }

    public PhieuMua(int maPM, int maSP, int soLuong, int tongTien, String taiKhoan, Date ngay) {
        this.maPM = maPM;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.taiKhoan = taiKhoan;
        this.ngay = ngay;
    }
}
