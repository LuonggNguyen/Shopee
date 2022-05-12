package com.example.shopee.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopee.R;

public class SignUpActivity extends AppCompatActivity {
    EditText edHoTen, edTaiKhoan, edMatKhau, edReMatKhau;
    TextView btnHuy, btnDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edHoTen = findViewById(R.id.edHoTen);
        edTaiKhoan = findViewById(R.id.edTaiKhoan);
        edMatKhau = findViewById(R.id.edMatKhau);
        edReMatKhau = findViewById(R.id.edReMatKhau);
        btnHuy = findViewById(R.id.btnHuy);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangKy();
            }
        });
    }
    private void DangKy(){
        String User = edTaiKhoan.getText().toString().trim();
        String HoTen = edHoTen.getText().toString().trim();
        String MatKhau = edHoTen.getText().toString().trim();
        Toast.makeText(getApplicationContext(),"User:"+User,Toast.LENGTH_SHORT).show();

    }
}