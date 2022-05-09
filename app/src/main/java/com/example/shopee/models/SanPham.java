package com.example.shopee.models;

public class SanPham {
    public String tenSP,moTa,danhGia;
    public int maSP,giaSP;
    public byte[] hinhAnh;

    public SanPham() {
    }

    public SanPham(String tenSP, String moTa, String danhGia, int maSP, int giaSP, byte[] hinhAnh) {
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.danhGia = danhGia;
        this.maSP = maSP;
        this.giaSP = giaSP;
        this.hinhAnh = hinhAnh;
    }
}
