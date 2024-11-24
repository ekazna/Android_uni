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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnGo;
    String TAG = "State";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnGo = findViewById(R.id.button);
        btnGo.setOnClickListener(this);

        Log.d(TAG, "Main Activity onCreate");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Main Activity onRestart");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Main Activity onStart");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Main Activity onResume");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Main Activity onStop");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Main Activity onDestroy");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Main Activity onPause");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
    }
}