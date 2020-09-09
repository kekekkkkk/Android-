package com.example.topline.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.example.topline.MainActivity;
import com.example.topline.R;
import java.util.Timer;
import java.util.TimerTask;

public class AdverActivity extends AppCompatActivity implements View.OnClickListener{

    private int recLen = 5;//跳过倒计时提示5秒
    private ImageView advert;
    private ImageView delete;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adver);
        initView();
//        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒


        /**
         * 正常情况下不点击跳过
         */
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(AdverActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);//延迟5S后发送handler信息
    }
    private void initView() {
        delete = findViewById(R.id.delete);//跳过
        delete.setOnClickListener(this);//跳过监听
        advert = findViewById(R.id.advert);
        advert.setOnClickListener(this);
    }
    /**
     * 点击跳过
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.delete:
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(AdverActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
            case R.id.advert:
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.addCategory(Intent.CATEGORY_BROWSABLE);
                intent2.setData(Uri.parse("http://www.itcast.cn/"));
                startActivity(intent2);
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }
}
