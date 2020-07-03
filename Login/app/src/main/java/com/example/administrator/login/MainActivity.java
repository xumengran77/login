package com.example.administrator.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et1;
    private EditText et2;
    private Button btn1;
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.ed1);
        et2=(EditText) findViewById(R.id.ed2);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.btn1):
                gotoMain();
        }
    }

    public void gotoMain() {
        try {
            if (et1.getText().toString().equals("") || et2.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "请账号名与密码", Toast.LENGTH_SHORT).show();
            } else if (!et1.getText().toString().equals("xmr") || !et2.getText().toString().equals("xmr123")) {
                Toast.makeText(MainActivity.this, "账号名与密码不正确", Toast.LENGTH_SHORT).show();
                et1.getText().clear();
                et2.getText().clear();
            } else {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyMainActivity.class);
                startActivity(intent);
            }
        } catch (Exception e) {
            Log.e("xmr", e.toString());
        }
    }
}
