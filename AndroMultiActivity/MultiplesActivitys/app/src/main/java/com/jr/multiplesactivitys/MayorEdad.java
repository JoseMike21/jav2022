package com.jr.multiplesactivitys;

import static java.lang.Math.random;
import static java.lang.Math.round;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MayorEdad extends AppCompatActivity {
    TextView txtNumM1;
    TextView txtNumM2;
    TextView txtResultadoM;
    TextView txtMsgMulti;
    Button btnSalirMulti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayor_edad);

        txtNumM1 = findViewById(R.id.txtNumM1);
        txtNumM2 = findViewById(R.id.txtNumM2);
        txtResultadoM = findViewById(R.id.txtResultadoM);
        txtMsgMulti = findViewById(R.id.txtMsgMulti);
        btnSalirMulti = findViewById(R.id.btnSalirMulti);

        multi();
        this.click();

    }

    private void multi(){
        Double num1, num2, multi;
        num1 = random()*10;
        num2 = random()*10;
        multi = num1 * num2;

        num1 = round(num1*100d)/100d;
        num2 = round(num2*100d)/100d;
        multi = round(multi*100d)/100d;

        txtNumM1.setText(String.valueOf(num1));
        txtNumM2.setText(String.valueOf(num2));
        txtResultadoM.setText(String.valueOf(multi));
        txtMsgMulti.setText("Excelente, Eres todo un Adulto.");


    }

    private void click(){
        btnSalirMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}