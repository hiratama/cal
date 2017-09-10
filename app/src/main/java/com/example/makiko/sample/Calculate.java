package com.example.makiko.sample;

import java.math.BigDecimal;

public class Calculate {
    

    public static double add(double value1, double value2) {
        return value1 + value2;
    }

    public static double subtraction(double value1, double value2){
        return value1 - value2;
    }

    public static double multiplication(double value1, double value2){
        return value1 * value2;
    }

    public static double division(double value1, double value2){
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
