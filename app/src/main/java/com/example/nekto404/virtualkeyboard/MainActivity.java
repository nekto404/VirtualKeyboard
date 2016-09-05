package com.example.nekto404.virtualkeyboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nekto404.virtualkeyboard.VirtualButtons.VirtualButtons;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent;
        intent = new Intent(this, VirtualButtons.class);
        startActivity(intent);
    }
}
