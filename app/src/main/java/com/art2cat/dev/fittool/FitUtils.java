package com.art2cat.dev.fittool;


import java.text.DecimalFormat;

/**
 * Created by Art2Cat
 * on 6/13/2017.
 */

public class FitUtils {

    public static String calculateBMI(String height, String weight) {
        Double heightD = Double.valueOf(height);
        Double weightD = Double.valueOf(weight);
        Double bmi = weightD / (heightD * heightD);
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        bmi = Double.valueOf(decimalFormat.format(bmi));
        String result;
        if (bmi > 32) {
            result = "BMI: " + bmi + "\n How could you still have the courage to alive?";
        } else if (32 >= bmi && bmi > 28) {
            result = "BMI: " + bmi+ "\n You should keep you body weight";
        } else if (28 >= bmi && bmi > 25) {
            result = "BMI: " + bmi+ "\n overweight";
        } else if (25 >= bmi && bmi > 18.5) {
            result = "BMI: " + bmi+ "\n You have a good shape!";
        } else {
            result = "BMI: " + bmi+ "\n Maybe the wind can make you fly~~~";
        }
        return result;
    }

    public static Double kjToKcal(Double kj) {
        return kj * 0.239;
    }

    public static Double kcalToKj(Double kcal) {
        return kcal * 4.184;
    }
}
