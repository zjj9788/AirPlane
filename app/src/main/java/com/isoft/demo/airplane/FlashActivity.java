package com.isoft.demo.airplane;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FlashActivity extends AppCompatActivity {
    Handler handler = new Handler();
    Handler skipHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            skip.setText("跳过" + MaxNum);
        }
    };
    Timer timer;
    TimerTask task;
    int MaxNum = 5;
    TextView skip;
    Runnable runnable;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        skip = (TextView) findViewById(R.id.skip);
      SharedPreferences sharedPreferences= getSharedPreferences("loginStaus",MODE_PRIVATE);
      final String frist= sharedPreferences.getString("frist","0");
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                Intent intent = new Intent();
                if(frist.equals("0"))
                intent.setClass(FlashActivity.this, GuideActivity.class);
               else
                intent.setClass(FlashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        if(runnable==null)
       runnable=  new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                if(!frist.equals("1"))
                intent.setClass(FlashActivity.this, GuideActivity.class);
                else
                intent.setClass(FlashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable, 5000);
        if (timer == null)//单例模式
            timer = new Timer();
        if (task == null)
            task = new TimerTask() {
                @Override
                public void run() {
                    skipHandler.sendEmptyMessage(0);
                    MaxNum--;
                    if (MaxNum == 0)
                        timer.cancel();

                }
            };
        timer.schedule(task, 1000, 1000);
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }
}
