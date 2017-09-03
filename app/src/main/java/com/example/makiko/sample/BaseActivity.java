package com.example.makiko.sample;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by makiko on 2017/09/03.
 */

public class BaseActivity extends AppCompatActivity {
    protected Button setButtonView(View view){
        Button btn = (Button)view;
        return btn;
    }
}
