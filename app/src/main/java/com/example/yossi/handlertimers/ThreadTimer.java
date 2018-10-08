package com.example.yossi.handlertimers;

import android.os.Handler;
import android.os.Message;


public class ThreadTimer extends Thread {

    int n;
    Handler handler;
    int speed;

    public ThreadTimer(Handler handler) {
        this.n = 0;
        this.handler = handler;
        speed = 1000;
    }

    public void speedUp()
    {

        if(speed - 200 >= 0)
            speed-=200;
    }

    public void speedDown()
    {

            speed+=200;
    }

    @Override
    public void run() {
        super.run();


        while (n != 1000)
        {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message msg = new Message();
            msg.arg1 = n;
            handler.sendMessage(msg);
            n++;

        }
    }
}
