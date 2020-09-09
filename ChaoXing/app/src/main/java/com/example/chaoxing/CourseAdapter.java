package com.example.chaoxing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private List<Course> mCourseList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView courseimage;
        TextView coursename;
        TextView courselecturer;

        public ViewHolder(@NonNull View view) {
            super(view);
            courseimage=(ImageView) view.findViewById(R.id.img_cur);
            coursename=(TextView) view.findViewById(R.id.txt_cur);
            courselecturer=(TextView) view.findViewById(R.id.txt_lec);
        }
    }

    public CourseAdapter(List<Course> courseList){
        mCourseList=courseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.crouse_layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course=mCourseList.get(position);
        holder.courseimage.setImageResource(course.getImageCourse());
        holder.coursename.setText(course.getTitle());
        holder.courselecturer.setText(course.getLecturer());
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }
}