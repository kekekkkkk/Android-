package com.example.jinian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class LoginF extends AppCompatActivity implements View.OnClickListener{
private EditText editText;
private ImageView imageView;
private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏菜单栏
        setContentView(R.layout.activity_login_f);
        Button button=(Button) findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.edit_text);
        imageView=(ImageView)findViewById(R.id.image_view);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
        progressBar.setVisibility(View.VISIBLE);                                                    //设置进度条为可见
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                int progress=progressBar.getProgress();
                progress=progress+90;
                progressBar.setProgress(progress);
                progressBar.setBackgroundColor(getResources().getColor(R.color.prbbr));
                break;
            default:
                break;
        }
        switch(v.getId()) {
            case R.id.button:
                String inputText = editText.getText().toString();
                if(inputText.equals("牛牛")) {
                    Toast.makeText(LoginF.this, "欢迎进入牛牛成长记", Toast.LENGTH_LONG).show();
                    Intent i;
                    i=new Intent(LoginF.this,Login.class);
                    startActivity(i);

                }else{
                    Toast.makeText(LoginF.this, "暂时没有这个小可爱噢", Toast.LENGTH_LONG).show();
                }
                editText.setText("");
                break;
            default:
                break;
        }

    }
}
