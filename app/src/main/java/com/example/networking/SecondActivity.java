package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String name = getIntent().getStringExtra("keyName");
        String info = getIntent().getStringExtra("keyInfo");

        TextView tvName = findViewById(R.id.sa_tv_name);
        TextView tvInfo = findViewById(R.id.sa_tv_info);

        tvName.setText(name);
        tvInfo.setText(info);

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                finish();
                return false;
            }
        });
    }
}