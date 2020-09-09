package com.example.topline.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.example.topline.R;
import com.example.topline.bean.WeatherBean;
import com.example.topline.utils.HttpUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et1;
    private TextView todayText,futureText,future,today,TodayTime,Todaywendu;
//    private TextView cityText;
    private WeatherBean weatherBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
//        getSupportActionBar().hide();
        Button sendRequest = (Button) findViewById(R.id.send_request);
        et1 = (EditText) findViewById(R.id.etxt_city);
//        cityText=(TextView) findViewById(R.id.txt_city);
        today=(TextView)findViewById(R.id.today) ;
        todayText=(TextView)findViewById(R.id.txt_today) ;
        future=(TextView)findViewById(R.id.future) ;
        futureText=(TextView)findViewById(R.id.text_future) ;
        TodayTime=(TextView)findViewById(R.id.today_time) ;
        Todaywendu=(TextView)findViewById(R.id.wendu) ;
//        responseText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request) {
//            sendRequestWithHttpURLConnection();
            sendRequestWithOkHttp();

        }
    }

    private void sendRequestWithOkHttp() {
        String city = et1.getText().toString().trim();
//        cityText.setText("所查询的城市："+city);
        HttpUtil.sendOkHttpRequest("http://v.juhe.cn/weather/index?format=2&cityname="+city+"&key=23b2b3289fa95310948c794a4b511859",new okhttp3.Callback(){
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                String responseData=response.body().string();
                parseJSONWithGSON(responseData);
            }

        });
    }

    private void parseJSONWithGSON(String jsonData) {
        weatherBean = JSON.parseObject(jsonData, WeatherBean.class);
        String city=weatherBean.getResult().getToday().getCity(); //城市
        String wind=weatherBean.getResult().getToday().getWind();  //风向
        String tem=weatherBean.getResult().getToday().getTemperature(); //温度
        String date=weatherBean.getResult().getToday().getDate_y();
        String dressing_advice=weatherBean.getResult().getToday().getDressing_advice();
        String dressing_index=weatherBean.getResult().getToday().getDressing_index();

        String all="";
        String week2="";
        String today=("风向："+wind+"\n\n穿衣："+dressing_advice+dressing_index+"\n");
        String connectString="";
        List<WeatherBean.ResultBean.FutureBean> futureBeanList=weatherBean.getResult().getFuture();
        for (int i=1;i<3;i++){
            if (i==1)
                week2="明天";
            else
                week2=futureBeanList.get(i).getWeek();
            String weather2=futureBeanList.get(i).getWeather();
            String tem2=futureBeanList.get(i).getTemperature();
            String wind2=futureBeanList.get(i).getWind();

            connectString=connectString+week2+"        "+weather2+"      "+tem2+"    "+wind2+"\n\n";
        }
        all=today+"\n"+connectString;
        showResponse(all);
        showResponseTody(today);
        showResponseFuture(connectString);
        showResponseTodayTime(date);
        showResponseTodaywendu(tem);

    }


    private void showResponseTody(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                today.setText("今日天气");
                todayText.setText(response);
            }
        });
    }
    private void showResponseFuture(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                future.setText("未来两天");
                futureText.setText(response);

            }
        });
    }
    private void showResponseTodayTime(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                TodayTime.setText(response);

            }
        });
    }
    private void showResponseTodaywendu(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                Todaywendu.setText(response);

            }
        });
    }


    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行UI操作，将结果显示到界面上
                Log.d("abc",response);
//                responseText.setText(response);
            }
        });
    }

}
