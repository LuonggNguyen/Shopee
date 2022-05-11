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
                "phanQuyen TEXT NOT NULL)";
        sqLiteDatabase.execSQL(User);
        String SanPham = "CREATE TABLE SanPham " +
                "(maSP INTEGER PRIMARY KEY AUTOINCREMENT, " +
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists User");
        sqLiteDatabase.execSQL("drop table if exists SanPham");
        sqLiteDatabase.execSQL("drop table if exists PhieuMua");

    }
}
