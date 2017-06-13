package com.example.tarun.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activityb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        TextView textView =(TextView)findViewById(R.id.t) ;
        Intent intent = getIntent();
        String te = intent.getExtras().getString("te");
        textView.setText(te);
    }
}