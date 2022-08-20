package com.jr.multiplesactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    EditText etxtNombre;
    EditText etxtEdad;
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtNombre = findViewById(R.id.etxtNombre);
        etxtEdad = findViewById(R.id.etxtEdad);
        btnEnter = findViewById(R.id.btnEnter);

        this.click();
        Log.d(TAG, "onCreate()");
    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }










    private void click(){
        Intent intentMenor = new Intent(this, MenorEdad.class);
        Intent intentMayor = new Intent(this, MayorEdad.class);
        btnEnter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {



                int edad;

                try {

                    edad = Integer.parseInt(etxtEdad.getText().toString());;

                    if (edad<18){
                        startActivity(intentMenor);

                    }else startActivity(intentMayor);


                }catch (Exception e){
                    System.err.println("[MM1}: "+ e.getMessage());
                }



            }
        });

    }



}