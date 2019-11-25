package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void levels(View View) {
        setContentView(R.layout.level);
    }
    public void level1(View View){
        Intent i = new Intent(MainActivity.this,Level.class);
        startActivity(i);

    }

    public void onStop(View View) {
        super.onStop();
    }

}
