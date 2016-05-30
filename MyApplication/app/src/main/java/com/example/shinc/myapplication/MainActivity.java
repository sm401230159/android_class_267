package com.example.shinc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView aaaaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aaaaa = (TextView) findViewById(R.id.aaaaa);
        aaaaa.setText("You're gonna be replaced.");

    }
}
