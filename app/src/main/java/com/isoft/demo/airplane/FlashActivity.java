package com.isoft.demo.airplane;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

public class FlashActivity extends AppCompatActivity {
    Handler handler=new Handler();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(FlashActivity.this,GuideActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
