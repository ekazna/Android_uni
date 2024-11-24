package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{


    Button btnGo;
    String TAG = "State";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        btnGo = findViewById(R.id.button);
        btnGo.setOnClickListener(this);

        Log.d(TAG, "Second onCreate");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Second Activity onRestart");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Second Activity onStart");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Second Activity onResume");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Second Activity onStop");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Second Activity onDestroy");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Second Activity onPause");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}