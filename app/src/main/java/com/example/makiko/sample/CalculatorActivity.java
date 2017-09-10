package com.example.makiko.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import java.math.BigDecimal;

public class CalculatorActivity extends BaseActivity {

    @InjectView(R.id.btn_1)
    Button btn1;
    @InjectView(R.id.btn_2)
    Button btn2;
    @InjectView(R.id.btn_3)
    Button btn3;
    @InjectView(R.id.btn_4)
    Button btn4;
    @InjectView(R.id.btn_5)
    Button btn5;
    @InjectView(R.id.btn_6)
    Button btn6;
    @InjectView(R.id.btn_7)
    Button btn7;
    @InjectView(R.id.btn_8)
    Button btn8;
    @InjectView(R.id.btn_9)
    Button btn9;
    @InjectView(R.id.btn_0)
    Button btn0;
    @InjectView(R.id.btn_eq)
    Button btnEq;
    @InjectView(R.id.btn_add)
    Button btnAdd;
    @InjectView(R.id.btn_sub)
    Button btnSub;
    @InjectView(R.id.btn_mul)
    Button btnMul;
    @InjectView(R.id.btn_div)
    Button btnDiv;
    @InjectView(R.id.btn_dot)
    Button btnDot;
    @InjectView(R.id.btn_clear)
    Button btnClear;
    @InjectView(R.id.text)
    TextView text;


    private double result = 0;
    int recentOperator;
    boolean isOperatorKeyPushed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ButterKnife.inject(this);

    }

    private void setButtonToText(View view){
        Button btn = setButtonView(view);
        if (isOperatorKeyPushed == true) {
            text.setText(btn.getText());
        } else {
            text.append(btn.getText());
        }
        isOperatorKeyPushed = false;
    }

    private void operation(View view) {
        Button operatorBtn = setButtonView(view);
        double value = Double.parseDouble(text.getText().toString());
        if (operatorBtn.getId() == R.id.btn_eq) {
            result = cal(recentOperator, result, value);
            text.setText(format(result));
            clear();
        }else{
            result = cal(recentOperator, value, result);
        }

        recentOperator = operatorBtn.getId();
        isOperatorKeyPushed = true;
    }

    private void clear(){
        recentOperator = 0;
        result = 0;
        isOperatorKeyPushed = false;
    }

    private void reset(){
        clear();
        text.setText("");
    }
    private double cal(int operator, double value1, double value2) {
        switch (operator) {
            case R.id.btn_add:
                 return add(value1, value2);
            case R.id.btn_sub:
                return subtraction(value1, value2);
            case R.id.btn_mul:
                return multiplication(value1, value2);
            case R.id.btn_div:
                return division(value1, value2);
            default:
                return value1;
        }
    }


    @OnClick({
            R.id.btn_0, R.id.btn_dot,
            R.id.btn_1, R.id.btn_2, R.id.btn_3,
            R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_7, R.id.btn_8, R.id.btn_9,
    })
    public void onBtnClicked(View view) {
        setButtonToText(view);
    }

    @OnClick({R.id.btn_eq, R.id.btn_add, R.id.btn_sub, R.id.btn_mul, R.id.btn_div})
    public void onBtnAddClicked(View view) {
        operation(view);
    }

    @OnClick(R.id.btn_clear)
    public void onBtnClear(){
        reset();
    }


    public double add(double value1, double value2) {
        return value1 + value2;
    }

    public double subtraction(double value1, double value2){
        return value1 - value2;
    }

    public double multiplication(double value1, double value2){
        return value1 * value2;
    }

    public double division(double value1, double value2){
        if (String.valueOf(value2).equals(0)){
            return 0;
        }
        BigDecimal val1 = BigDecimal.valueOf(value1);
        BigDecimal val2 = BigDecimal.valueOf(value2);
        BigDecimal result = val2.divide(val1);
        return result.doubleValue();
    }

    public static String format(double d){
        if(d == (long)d){
            return String.format("%d", (int)d);
        }
        return String.format("%s", d);
    }
}
