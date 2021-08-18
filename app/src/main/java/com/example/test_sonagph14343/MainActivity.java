package com.example.test_sonagph14343;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pgBar;
    private int temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pgBar = (ProgressBar) findViewById(R.id.pgBar);
        pgBar.setMax(100);
        temp = 10;
        pgBar.setProgress(temp);
        CountDownTimer countDownTimer = new CountDownTimer(3000,100) {
            @Override
            public void onTick(long l) {
                temp+=10;
                pgBar.setProgress(temp);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}