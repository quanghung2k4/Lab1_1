package com.learn.lab1_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.learn.lab1_1.model.Cat;

public class MainActivity2 extends AppCompatActivity {


    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Cat data = (Cat) getIntent().getSerializableExtra("data");
        Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.text);
        textView.setText(data.toString());
        button = findViewById(R.id.button);
        button.setOnClickListener( v-> finish());
    }
}