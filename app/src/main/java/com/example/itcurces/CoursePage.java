package com.example.itcurces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itcurces.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseText.setText(getIntent().getStringExtra("courseText"));


        TextView passcourse = findViewById(R.id.passTheCourse);
        passcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CoursePage.this, VideoCourse.class);
                startActivity(intent);
                Toast.makeText(CoursePage.this,"Вы не cможете проити полный крус",Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("courseId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this,"Добавленно!",Toast.LENGTH_LONG).show();
    }

}