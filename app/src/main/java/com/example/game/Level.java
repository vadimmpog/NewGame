package com.example.game;

import android.app.Activity;
import android.os.Bundle;


public class Level extends Activity   {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

}
