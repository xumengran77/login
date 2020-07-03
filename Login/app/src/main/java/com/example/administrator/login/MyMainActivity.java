package com.example.administrator.login;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import Fragments.MyFragment2;
import Fragments.myFragment;

public class MyMainActivity extends AppCompatActivity  implements View.OnClickListener{

    private TextView txt_topbar;
    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    private FrameLayout ly_content;

    //Fragment Object
    private myFragment fg1,fg2,fg3;
    private MyFragment2 fg4;
    public FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        bindViews();
    }

    private void bindViews(){
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_better = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);
        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            FragmentTransaction fTransaction = fManager.beginTransaction();
            hideAllFragment(fTransaction);
            switch (v.getId()) {
                case R.id.txt_channel:
                    setSelected();
                    txt_channel.setSelected(true);
                    if (fg1 == null) {
                        fg1 = new myFragment();
                        fTransaction.add(R.id.ly_content, fg1);
                    } else {
                        fTransaction.show(fg1);
                    }
                    break;
                case R.id.txt_message:
                    setSelected();
                    txt_message.setSelected(true);
                    if (fg2 == null) {
                        fg2 = new myFragment();
                        fTransaction.add(R.id.ly_content, fg2);
                    } else {
                        fTransaction.show(fg2);
                    }
                    break;
                case R.id.txt_better:
                    setSelected();
                    txt_better.setSelected(true);
                    if (fg3 == null) {
                        fg3 = new myFragment();
                        fTransaction.add(R.id.ly_content, fg3);
                    } else {
                        fTransaction.show(fg3);
                    }
                    break;
                case R.id.txt_setting:
                    setSelected();
                    txt_setting.setSelected(true);
                    if (fg4 == null) {
                        fg4 = new MyFragment2();
                        fTransaction.add(R.id.ly_content, fg4);
                    } else {
                        fTransaction.show(fg4);
                    }
                    break;
            }
            fTransaction.commit();
        } catch (Exception e) {
            Log.e("xmr", e.toString());
        }
    }

    private void setSelected(){
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_better.setSelected(false);
        txt_setting.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }

}
