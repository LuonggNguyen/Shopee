package com.example.shopee.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopee.R;
import com.example.shopee.controllers.DAO.UserDAO;

public class LoginActivity extends AppCompatActivity {
    EditText edTaiKhoan, edMatKhau;
    TextView btnHuy, btnDangNhap;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edTaiKhoan = findViewById(R.id.edTaiKhoan);
        edMatKhau = findViewById(R.id.edMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnHuy = findViewById(R.id.btnHuy);
        userDAO = new UserDAO(getApplicationContext());
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taiKhoan = edTaiKhoan.getText().toString();
                String matKhau = edMatKhau.getText().toString();
                if (userDAO.checkLogin(taiKhoan, matKhau)){
                    //Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    if (userDAO.getUser(taiKhoan).phanQuyen == 1){
                        Toast.makeText(getApplicationContext(),"Người Mua",Toast.LENGTH_SHORT).show();
                    }
                    if (userDAO.getUser(taiKhoan).phanQuyen == 2){
                        Toast.makeText(getApplicationContext(),"Người Bán",Toast.LENGTH_SHORT).show();
                    }
                    if (userDAO.getUser(taiKhoan).phanQuyen == 3){
                        Toast.makeText(getApplicationContext(),"Admin",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}