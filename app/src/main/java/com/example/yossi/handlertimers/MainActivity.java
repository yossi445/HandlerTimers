package com.example.yossi.handlertimers;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv1;
    Button btnPlus1, btnMin1;
    int start = 0;
    Handler handler;

    ThreadTimer timer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        btnPlus1 = findViewById(R.id.btnPlus1);
        btnMin1 = findViewById(R.id.btnMin1);

        btnPlus1.setOnClickListener(this);
        btnMin1.setOnClickListener(this);



        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                tv1.setText(String.valueOf(msg.arg1));

                return true;
            }
        });

        timer1 = new ThreadTimer(handler);
        timer1.start();


    }

    @Override
    public void onClick(View v) {
        if(v == btnPlus1)
            timer1.speedUp();
        else if(v == btnMin1)
            timer1.speedDown();

    }
}
