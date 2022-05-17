package com.example.shopee.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopee.R;
import com.example.shopee.controllers.DAO.UserDAO;
import com.example.shopee.views.Admin.ManagerUserActivity;
import com.example.shopee.views.NguoiBan.NguoiBanActivity;
import com.example.shopee.views.NguoiMua.NguoiMuaActivity;

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
                        Intent intent = new Intent(LoginActivity.this, NguoiMuaActivity.class);
                        startActivity(intent);
                    }
                    if (userDAO.getUser(taiKhoan).phanQuyen == 2){
                        Intent intent = new Intent(LoginActivity.this, NguoiBanActivity.class);
                        startActivity(intent);
                    }
                    if (userDAO.getUser(taiKhoan).phanQuyen == 3){
                        Intent intent = new Intent(LoginActivity.this, ManagerUserActivity.class);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}