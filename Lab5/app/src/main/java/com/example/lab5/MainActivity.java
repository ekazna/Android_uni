package com.example.lab5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


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

        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        SP = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);



    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSave){
            String textToSave = myText.getText().toString();
            SharedPreferences.Editor editor = SP.edit();
            editor.putString("myString", textToSave);
            editor.apply();

        } else if (view.getId() == R.id.btnLoad){
            if(SP.contains("myString")) {
                String savedText = SP.getString("myString", "");
                myText.setText(savedText);
            }
        }
    }
}