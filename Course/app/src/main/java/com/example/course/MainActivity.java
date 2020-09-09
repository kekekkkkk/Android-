package com.example.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Course> courseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCurses();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CourseAdapter adapter = new CourseAdapter(courseList);
        recyclerView.setAdapter(adapter);

    }

    private void initCurses() {
        for (int i=0;i<2;i++) {
            Course android = new Course(R.drawable.android, "Android", "遆佳   收藏41111");
            courseList.add(android);
            Course java = new Course(R.drawable.java, "Java", "杨仁怀");
            courseList.add(java);
            Course office = new Course(R.drawable.office, "office", "唐国强   收藏1221");
            courseList.add(office);
            Course dian = new Course(R.drawable.dian, "电工与电子技术", "张丽霞等");
            courseList.add(dian);
            Course chuang = new Course(R.drawable.chuang, "大学生创业之路", "刘武德等");
            courseList.add(chuang);
            Course xin = new Course(R.drawable.xin, "信息技术", "张雪峰");
            courseList.add(xin);
            Course tu = new Course(R.drawable.tu, "图形图像处理", "周静");
            courseList.add(tu);
            Course shu = new Course(R.drawable.shu, "高等数学", "深圳大学 赵冰（副教授）等");
            courseList.add(shu);
            Course cheng = new Course(R.drawable.cheng, "大学生成功学", "北京林业大学");
            courseList.add(cheng);
            Course chuang2 = new Course(R.drawable.chuang2, "创新创业", "张玉臣等");
            courseList.add(chuang2);
        }
    }
}
