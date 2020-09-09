package com.example.chaoxing;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目的主Activity，所有的Fragment都嵌入在这里。
 *
 * @author guolin
 */
public class MainActivity extends Activity implements View.OnClickListener {

    /**
     * 用于展示首页的Fragment
     */
    private HomeFragment homeFragment;

    /**
     * 用于展示消息的Fragment
     */
    private MessFragment messFragment;

    /**
     * 用于展示笔记的Fragment
     */
    private WriteFragment writeFragment;

    /**
     * 用于展示我的的Fragment
     */
    private MeFragment meFragment;

    /**
     * 首页界面布局
     */
    private View homeLayout;

    /**
     * 消息界面布局
     */
    private View messLayout;

    /**
     * 笔记界面布局
     */
    private View writeLayout;

    /**
     * 我的界面布局
     */
    private View meLayout;

    /**
     * 在Tab布局上显示首页图标的控件
     */
    private ImageView homeImage;

    /**
     * 在Tab布局上显示消息图标的控件
     */
    private ImageView messImage;

    /**
     * 在Tab布局上显示笔记图标的控件
     */
    private ImageView writeImage;

    /**
     * 在Tab布局上显示我的图标的控件
     */
    private ImageView meImage;

    /**
     * 在Tab布局上显示首页标题的控件
     */
    private TextView homeText;

    /**
     * 在Tab布局上显示消息标题的控件
     */
    private TextView messText;

    /**
     * 在Tab布局上显示笔记标题的控件
     */
    private TextView writeText;

    /**
     * 在Tab布局上显示我的标题的控件
     */
    private TextView meText;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 初始化布局元素
        initViews();



        fragmentManager=getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */
    private void initViews() {
        homeLayout = findViewById(R.id.home_layout);
        messLayout = findViewById(R.id.mess_layout);
        writeLayout = findViewById(R.id.write_layout);
        meLayout = findViewById(R.id.me_layout);
        homeImage = (ImageView) findViewById(R.id.home_image);
        messImage = (ImageView) findViewById(R.id.mess_image);
        writeImage = (ImageView) findViewById(R.id.write_img);
        meImage = (ImageView) findViewById(R.id.me_image);
        homeText = (TextView) findViewById(R.id.home_text);
        messText = (TextView) findViewById(R.id.mess_text);
        writeText = (TextView) findViewById(R.id.write_text);
        meText = (TextView) findViewById(R.id.me_text);
        homeLayout.setOnClickListener(this);
        messLayout.setOnClickListener(this);
        writeLayout.setOnClickListener(this);
        meLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.mess_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.write_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            case R.id.me_layout:
                // 当点击了设置tab时，选中第4个tab
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了首页tab时，改变控件的图片和文字颜色
                homeImage.setImageResource(R.drawable.homeon);
                homeText.setTextColor(Color.parseColor("#0092f4"));
                if (homeFragment == null) {

                    // 如果HomeFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    // 如果HomeFragment不为空，则直接将它显示出来
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                messImage.setImageResource(R.drawable.msgon);
                messText.setTextColor(Color.parseColor("#0092f4"));
                if (messFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    messFragment = new MessFragment();
                    transaction.add(R.id.content, messFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(messFragment);
                }
                break;
            case 2:
                // 当点击了笔记tab时，改变控件的图片和文字颜色
                writeImage.setImageResource(R.drawable.writeon);
                writeText.setTextColor(Color.parseColor("#0092f4"));
                if (writeFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    writeFragment = new WriteFragment();
                    transaction.add(R.id.content, writeFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(writeFragment);
                }
                break;
            case 3:
            default:
                // 当点击了我的tab时，改变控件的图片和文字颜色
                meImage.setImageResource(R.drawable.meon);
                meText.setTextColor(Color.parseColor("#0092f4"));
                if (meFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    meFragment = new MeFragment();
                    transaction.add(R.id.content, meFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(meFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        homeImage.setImageResource(R.drawable.home);
        homeText.setTextColor(Color.parseColor("#000000"));
        messImage.setImageResource(R.drawable.msg);
        messText.setTextColor(Color.parseColor("#000000"));
        writeImage.setImageResource(R.drawable.write);
        writeText.setTextColor(Color.parseColor("#000000"));
        meImage.setImageResource(R.drawable.me);
        meText.setTextColor(Color.parseColor("#000000"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (messFragment != null) {
            transaction.hide(messFragment);
        }
        if (writeFragment != null) {
            transaction.hide(writeFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }


}