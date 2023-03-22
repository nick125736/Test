package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("keyname");
        double hh = bundle.getDouble("keyheight",100.0);
        double ww = bundle.getDouble("keyweight",50.0);

        TextView showbmi = findViewById(R.id.tvShowBMI);
        showbmi.setText(name+String.valueOf(hh)+String.valueOf(ww));

    }

    public void Gohome(View view) {
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}