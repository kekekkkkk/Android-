package com.example.course;

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
    public CourseAdapter(List<Course>courseList) {
        mCourseList = courseList;
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
        holder.imageCurld.setImageResource(course.getImageCurld());
        holder.title.setText(course.getTitle());
        holder.lecturer.setText(course.getLecturer());

    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageCurld;
        TextView title;
        TextView lecturer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCurld=(ImageView)itemView.findViewById(R.id.img_cur);
            title=(TextView)itemView.findViewById(R.id.txt_cur);
            lecturer=(TextView) itemView.findViewById(R.id.txt_lec);

        }
    }
}
