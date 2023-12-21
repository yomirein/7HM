package com.msaggik.sixthlessonexponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // поля
    // строка для анализа
    private String pi = "3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196442881097566593344612847564823378678316527120190914564856692346034861045432664821339360726024914127372458700660631558817488152092096282925409171536436789259036001133053054882046652138414695194151160943305727036575959195309218611738193261179";

    private int[] arrayInt;
    private int volume5;
    private int volume3;

    private int rarestDigit;
    private int[] sortArrayInt;

    private TextView infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayInt = arrayInt(pi);
        volume3 = volume3(arrayInt);
        volume5 = volume5(arrayInt);
        rarestDigit = rarestDigit(arrayInt);

        sortArrayInt = Arrays.copyOf(arrayInt, arrayInt.length);
        Arrays.sort(sortArrayInt);
        sortArrayInt = reversArrayInt(sortArrayInt);

        // привязка поля к разметке по id
        infoApp = findViewById(R.id.infoApp);

        // вывод информации на экран смартфона
        infoApp.setText("Массив из строки: " + Arrays.toString(arrayInt) + "\n"
                + "Количество цифр 3: " + volume3 + "\n"
                + "Количество цифр 5: " + volume5 + "\n"
                + "Самая редкая цифра: " + rarestDigit + "\n"
                + "Отсортированный массив наоборот: " + Arrays.toString(sortArrayInt));
    }

    private int[] reversArrayInt(int[] arrayDigit) {
        int[] revers = new int[arrayDigit.length];
        for (int i = arrayDigit.length - 1; i >= 0; i--) {
            revers[arrayDigit.length - (i + 1)] = arrayDigit[i];
        }
        return revers;
    }



    private int rarestDigit(int[] arrayDigit) {
        int[] count = new int[10];
        for (int i : arrayDigit) {
            switch (i) {
                case 0: count[0]++; break;
                case 1: count[1]++; break;
                case 2: count[2]++; break;
                case 3: count[3]++; break;
                case 4: count[4]++; break;
                case 5: count[5]++; break;
                case 6: count[6]++; break;
                case 7: count[7]++; break;
                case 8: count[8]++; break;
                case 9: count[9]++; break;
            }
        }
        int rarest = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] < count[rarest]) rarest = i;
        }
        return rarest;
    }

    private int volume3(int[] arrayDigit) {
        int count = 0;
        for (int i : arrayDigit) {
            if (i == 3) {
                count++;
            }
        }
        return count;
    }

    private int volume5(int[] arrayDigit) {
        int count = 0;
        for (int i : arrayDigit) {
            if (i == 5) {
                count++;
            }
        }
        return count;
    }
    private int[] arrayInt(String string) {
        String stringNew = string.replace(".", "");
        String[] arrayString = stringNew.split("");
        int[] arrayInteger = new int[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayInteger[i] = Integer.parseInt(arrayString[i]);
        }
        return arrayInteger;
    }
}