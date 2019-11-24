package com.example.game;

import android.app.Activity;
import android.os.Bundle;

public class Level extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
    }
    public void MainMenue(){
        setContentView(R.layout.main_activity);
    }
}
