package com.learn.lab1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.lab1_1.adapter.Adapter;
import com.learn.lab1_1.adapter.OnItemListener;
import com.learn.lab1_1.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemListener {


    RecyclerView recyclerView;
    Adapter adapter;
    List<Cat> catList = new ArrayList<>();
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.btn);

        catList.add( new Cat(R.drawable.school,"Cat 1","So cuteeee"));
        catList.add( new Cat(R.drawable.school_1,"Cat 2","So cuteeee"));
        catList.add( new Cat(R.drawable.school_2,"Cat 3","So cuteeee"));
        catList.add( new Cat(R.drawable.school_3,"Cat 4","So cuteeee"));
        catList.add( new Cat(R.drawable.school_4,"Cat 5","So cuteeee"));
        catList.add( new Cat(R.drawable.school_6,"Cat 5","So cuteeee"));
        catList.add( new Cat(R.drawable.school_7,"Cat 5","So cuteeee"));
        catList.add( new Cat(R.drawable.school_7,"Cat 5","So cuteeee"));

        adapter = new Adapter(this,catList);
        recyclerView.setAdapter(adapter);
        adapter.setListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra("data",catList.get(2));
            startActivity(intent);
        });
    }

    @Override
    public void onCick(int position) {
        Toast.makeText(this, catList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void longClick(int position) {

    }
}