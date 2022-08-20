package com.jr.multiplesactivitys;

import static java.lang.Math.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MenorEdad extends AppCompatActivity {
    TextView txtNum1;
    TextView txtNum2;
    TextView txtResultado;
    TextView txtMsgSuma;
    Button btnSalirSuma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menor_edad);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        txtResultado = findViewById(R.id.txtResultado);
        txtMsgSuma = findViewById(R.id.txtMsgSuma);
        btnSalirSuma = findViewById(R.id.btnSalirSuma);

        suma();
        this.click();
    }

    private void suma(){
        Double num1, num2, suma;
        num1 = random()*10;
        num2 = random()*10;
        suma = num1 + num2;

        num1 = round(num1*100d)/100d;
        num2 = round(num2*100d)/100d;
        suma = round(suma*100d)/100d;

        txtNum1.setText(String.valueOf(num1));
        txtNum2.setText(String.valueOf(num2));
        txtResultado.setText(String.valueOf(suma));
        txtMsgSuma.setText("Es correcto ya no eres tan Bebe.");


    }

    private void click(){
        btnSalirSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}