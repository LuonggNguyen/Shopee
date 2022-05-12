package com.example.shopee.models;

public class User {
    public String taiKhoan,matKhau,hoTen;
    public int phanQuyen;

    public User() {
    }

    public User(String taiKhoan, String matKhau, String hoTen, int phanQuyen) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.phanQuyen = phanQuyen;
    }
}
