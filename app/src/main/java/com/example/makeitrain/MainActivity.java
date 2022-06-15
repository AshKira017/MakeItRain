package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
    private TextView moneyValue;
    private Button showInfo;
    private int moneyCounter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeItRain = findViewById(R.id.buttonMakeItRain);
        moneyValue = findViewById(R.id.moneyValue);
//        makeItRain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("MainActivity", "onClick:Make It Rain!! ");
//            }
//        });

    }

    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter +=1000;
//        if(moneyCounter>=20000) {
//            moneyValue.setTextColor(getColor(R.color.Red));
//
//        }
        switch (moneyCounter){
            case 10000:
                moneyValue.setTextColor(getColor(R.color.Red));
                break;
            case 20000:
                moneyValue.setTextColor(Color.CYAN);
                break;
            case 30000:
                moneyValue.setTextColor(Color.DKGRAY);
                break;
            default:
                moneyValue.setTextColor(getColor(R.color.black));
                break;

        }
        if(moneyCounter==20000){
            Toast.makeText(MainActivity.this,R.string.myat20k,Toast.LENGTH_SHORT)
                    .show();
        }
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
        //Log.d("Mir", "onClick: "+ moneyCounter);
    }

    public void showInfo(View view) {
//        Toast.makeText(MainActivity.this,R.string.app_info,Toast.LENGTH_SHORT)
//                .show();
        Snackbar.make(makeItRain,R.string.app_info,Snackbar.LENGTH_SHORT)
                .setAction("more", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("Sbmg", "onClick:mg ");
                        Snackbar.make(makeItRain,R.string.mg,Snackbar.LENGTH_SHORT)
                                .show();
                    }
                })
                .show();

    }
}