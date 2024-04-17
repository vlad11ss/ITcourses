package com.example.itcurces;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.itcurces.adapter.CategoryAdapter;
import com.example.itcurces.adapter.CourseAdapter;
import com.example.itcurces.model.Category;
import com.example.itcurces.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> coursesList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Языки"));
        categoryList.add(new Category(3, "сайты"));
        categoryList.add(new Category(4, "БД"));
        categoryList.add(new Category(5, "Прочее"));

        setCategoryRecycler(categoryList);


        coursesList.add(new Course(1, "java", "Основы\n программирования на\n Java с нуля", "17.04.23", "#B9EAFA",
                "На данных уроках вы будите изучать основы программирования на примере языка Java в интерактивной форме\n" +
                        "Узнаете, что такое выражения, условные операции, циклы, массивы, функции, алгоритмы и много чего ещё интересного и полезного. ", 2,"от 60000р"));

        coursesList.add(new Course(2, "python", "Основы\n программирования на\n Python с нуля", "15.05.23", "#B9FAC0",
                "В курсе вы конкретно научитесь переменным и функциям,\n" +
                        "парсингу вакансий с сайтов по поиску работы и еще куче полезной информации", 2,"от 55000р"));

        coursesList.add(new Course(3, "charp", "C#:от новичка до\n специалиста\n", "11.07.23", "#ABB8F9",
                "Все как и написано в заголовке: начнёте с основ .NET, а закончите уже более сложными темами, такие как ООП.\n" +
                        "Также, этот курс покрывает все основные возможности C# и даёт рекомендации по написанию грамотного, \"чистого\" кода", 2,"от 40000р"));

        coursesList.add(new Course(4, "unity", "основы разработки\n на Unity\n", "28.07.23", "#EECCAD", "в этом курсе вы научитесь лучшим практикам на примере\n" +
                "создания игры-шутера с нуля и выучите движок Unity 2d и C# с полного нуля", 1,"от 35000р"));

        coursesList.add(new Course(5, "spring", "Spring для начинающих\n с нуля\n ", "19.11.23", "#CEFAB9",
                "За курс изучите ого-го какой стэк Spring технологий: Boot, MVC, Rest, Security. Плюсом, еще и супер популярный Hibernate подучите.", 3,"от 45000р"));

        coursesList.add(new Course(6, "type_script", "TypeScript для\n современной разработки\n с нуля ", "14.12.23", "#534755",
                "О, ну этот курсик, вам точно должен понравиться) Ведь, с этим языком вы сможете работать, как во фронтенде, так и бэкенде, либо вообще FullStack\n" +
                        "За курс узнаете, что такое Тупэскрипт, как он дополняет возможности языка JavaSctipt и как его использовать.", 3,"от 75000р"));

        coursesList.add(new Course(7, "java_script", "Основы современного\n JavaScript с нуля для\n начинающих", "15.01.24", "#EAF9AE",
                "Вы без знаний изучите основы современного JavaScript с нуля, познакомитесь с переменными, логикой, условными операторами и т.д." +
                        " Но самое интересное, что вас ждет куча практики", 3,"от 50000р"));

        coursesList.add(new Course(8, "bd", "Практический курс для\n новичков по SQL и\n PostgreSQL", "13.03.24", "#555F6E",
                "Курс позволит вам понять что такое реляционная модель и SQL, познакомится с типами данных PostgreSQL, научится создавать" +
                        " БД с таблицами и еще много чего полезного, что не влезео в описание.", 4,"от 25000р"));

        coursesList.add(new Course(9, "git", "Основы Git для новичков\n\n", "18.05.24", "#ACB4C1",
                "Вы узнаете, почему она важна в современной разработке. Изучите базовые понятия: репозиторий, коммиты, ветки и тэги. Освоите ключевые операции:" +
                        " создание и клонирование репозитория, слияние веток, запрос истории изменений и многое другое.", 5,"от 10000р"));

        fullCoursesList.addAll(coursesList);
        setCourseRecycler(coursesList);

        ImageButton exit_btn = findViewById(R.id.exit_btn);
        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, OneActivity.class);
                startActivity(i);
            }
        });
    }


    private void setCourseRecycler(List<Course> coursesList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, coursesList);
        courseRecycler.setAdapter(courseAdapter);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }

    public static void showCoursesByCategory(int category) {

        coursesList.clear();
        coursesList.addAll(fullCoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c : coursesList) {
            if (c.getCategory() == category)
                filterCourses.add(c);


        }
        coursesList.clear();
        coursesList.addAll(filterCourses);


        courseAdapter.notifyDataSetChanged();
    }

    public void openShopCart(View view){
        Intent intent = new Intent(MenuActivity.this, OrderPage.class);
        startActivity(intent);
    }

}