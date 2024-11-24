package com.example.lab52;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{


    Button btnSave, btnLoad;
    EditText myText;
    SharedPreferences SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        myText = findViewById(R.id.editText);


        SP = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);

        btnSave.setOnClickListener(v -> saveData());

        btnLoad.setOnClickListener(v -> loadData());

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
        Log.d("Lifecycle", "onPause: DATA SAVED");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveData();
        Log.d("Lifecycle", "onDestroy: DATA SAVED");

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
        Log.d("Lifecycle", "OnResume: " + SP.getString("myString", ""));
    }


    private void saveData() {
        String textToSave = myText.getText().toString();
        SharedPreferences.Editor editor = SP.edit();
        editor.putString("myString", textToSave);
        editor.apply();
    }

    private void loadData() {
        String savedText = SP.getString("myString", "");
        myText.setText(savedText);
    }

}