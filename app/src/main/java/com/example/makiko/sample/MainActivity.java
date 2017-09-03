package com.example.makiko.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cal_btn = (Button)findViewById(R.id.cal_btn);
        Button startBtn = (Button)findViewById(R.id.start_btn);

        cal_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), CalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}
