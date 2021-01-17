package com.example.se_app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import static com.example.se_app.StudentPerformance.STUDENT_ID_KEY;

public class StudentRecViewAdapter extends RecyclerView.Adapter<StudentRecViewAdapter.ViewHolder> {
    private static final String TAG = "StudentRecViewAdapter";
    private ArrayList<Student> students = new ArrayList<>();
    private Context sContext;

    public StudentRecViewAdapter(Context sContext){
        this.sContext = sContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Log.d(TAG, "onBindViewHolder: Called.");
        holder.txtName.setText(students.get(position).getSurname());
//        Glide.with(sContext).asBitmap().load(students.get(position).getImageUrl().into(holder.avatar));
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sContext, StudentPerformance.class);
                intent.putExtra(STUDENT_ID_KEY, students.get(position).getId());
                sContext.startActivity(intent);
            }
        });

        holder.txtName.setText(students.get(position).getSurname());
        holder.studentName.setText(students.get(position).getName());
        holder.attendance.setText(students.get(position).getAttendanceNumber());


        if(students.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }

    } // onBindViewHolder


    public void setStudents(ArrayList<Student> students){
        this.students = students;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return students.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView avatar;
        private TextView studentName;
        private TextView txtName;
        private TextView attendance;
        private  ImageView downArrow, upArrow;
        private RelativeLayout expandedRelLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            avatar = itemView.findViewById(R.id.avatar);
            txtName = itemView.findViewById(R.id.txtStudent);
            studentName = itemView.findViewById(R.id.studentName);
            attendance = itemView.findViewById(R.id.totalAttendance);
            avatar = itemView.findViewById(R.id.avatar);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student student = students.get(getAdapterPosition());
                    student.setExpanded(!student.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student student = students.get(getAdapterPosition());
                    student.setExpanded(!student.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }



    }
}
