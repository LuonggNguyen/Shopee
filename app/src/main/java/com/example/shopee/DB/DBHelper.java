package com.example.shopee.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static final String dbName = "DB";
    static final int dbVersion = 4;

    public DBHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String User = "CREATE TABLE User " +
                "(taiKhoan TEXT PRIMARY KEY , " +
                "matKhau TEXT NOT NULL, " +
                "hoTen TEXT NOT NULL, " +
                "phanQuyen INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(User);
        String SanPham = "CREATE TABLE SanPham " +
                "(maSP INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "maLoaiSP INTEGER NOT NULL, " +
                "tenSP TEXT NOT NULL, " +
                "moTa TEXT NOT NULL, " +
                "giaSP INTEGER NOT NULL, " +
                "danhGia TEXT NOT NULL, " +
                "hinhAnh BLOB)";
        sqLiteDatabase.execSQL(SanPham);
        String PhieuMua = "CREATE TABLE PhieuMua " +
                "(maPM INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "maSP INTEGER NOT NULL, " +
                "soLuong INTEGER NOT NULL, " +
                "tongTien INTEGER NOT NULL, " +
                "taiKhoan TEXT NOT NULL )";
        sqLiteDatabase.execSQL(PhieuMua);
        String LoaiSanPham = "CREATE TABLE LoaiSanPham " +
                "(maLoaiSP INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenLoaiSP TEXT NOT NULL )";
        sqLiteDatabase.execSQL(LoaiSanPham);

        String INSERT_User = "Insert into User(taiKhoan,matKhau,hoTen, phanQuyen) values " +
                "('ngan','123','Nguyễn Phúc Ngân', 2)," +
                "('luong','123','Nguyễn Hoài Lương', 1)," +
                "('admin','123','Nguyễn Admin', 3)" ;
        sqLiteDatabase.execSQL(INSERT_User);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists User");
        sqLiteDatabase.execSQL("drop table if exists SanPham");
        sqLiteDatabase.execSQL("drop table if exists PhieuMua");

    }
}
