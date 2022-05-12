package com.example.shopee.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopee.R;
import com.example.shopee.controllers.DAO.UserDAO;
import com.example.shopee.models.User;

public class SignUpActivity extends AppCompatActivity {
    RadioButton rdNguoiMua, rdNguoiBan;
    EditText edHoTen, edTaiKhoan, edMatKhau, edReMatKhau;
    TextView btnHuy, btnDangKy;
    UserDAO userDAO;
    int nguoiMua = 1 ,nguoiBan = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edHoTen = findViewById(R.id.edHoTen);
        edTaiKhoan = findViewById(R.id.edTaiKhoan);
        edMatKhau = findViewById(R.id.edMatKhau);
        edReMatKhau = findViewById(R.id.edReMatKhau);
        rdNguoiMua = findViewById(R.id.rdNguoiMua);
        rdNguoiBan = findViewById(R.id.rdNguoiBan);
        btnHuy = findViewById(R.id.btnHuy);
        btnDangKy = findViewById(R.id.btnDangKy);
        userDAO = new UserDAO(getApplicationContext());
        rdNguoiMua.setChecked(true);
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
        int phanQuyen = 0;
        if (validate()>0){
            String hoTen = edHoTen.getText().toString().trim();
            String taiKhoan = edTaiKhoan.getText().toString().trim();
            String matKhau = edMatKhau.getText().toString().trim();
            if (rdNguoiMua.isChecked()==true){
                phanQuyen = nguoiMua;
            }
            if (rdNguoiBan.isChecked()== true){
                phanQuyen = nguoiBan;
            }

            User user = new User();
            user.taiKhoan = taiKhoan;
            user.matKhau = matKhau;
            user.hoTen = hoTen;
            user.phanQuyen = phanQuyen;


            if (userDAO.insert(user) > 0){
                Toast.makeText(getApplicationContext(), "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(getApplicationContext(), "Tạo tài khoản không thành công", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public int validate(){
        int check = 1 ;
        if (edHoTen.getText().length() == 0 || edTaiKhoan.getText().length() == 0 || edMatKhau.getText().length() == 0 || edReMatKhau.getText().length() == 0){
            Toast.makeText(getApplicationContext(),"Bạn phải nhập đầy đủ thông tin !",Toast.LENGTH_LONG).show();
            check = -1;
        }
        String pass = edMatKhau.getText().toString();
        String rePass = edReMatKhau.getText().toString();
        if (!pass.equals(rePass)) {
            Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_LONG).show();
            check = -1;
        }
        return check;
    }


}