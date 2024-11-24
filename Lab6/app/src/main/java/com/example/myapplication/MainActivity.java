package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnInsert, btnFetch, btnDrop;
    EditText etFirstName, etLastName;
    MyDBHelper dbHelper;

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

        btnInsert = findViewById(R.id.btnAdd);
        btnFetch = findViewById(R.id.btnRead);
        btnDrop = findViewById(R.id.btnDelete);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);

        btnDrop.setOnClickListener(this);
        btnFetch.setOnClickListener(this);
        btnInsert.setOnClickListener(this);

        dbHelper = new MyDBHelper(this);


    }

    @Override
    public void onClick(View view) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (view.getId() == R.id.btnAdd){
            ContentValues cv = new ContentValues();
            cv.put("first_name", etFirstName.getText().toString());
            cv.put("last_name", etLastName.getText().toString());
            db.insert("myTable", null, cv);

        } else if (view.getId() == R.id.btnRead){
            Cursor c = db.query("myTable", null, null, null, null, null, null);
            int rows = c.getCount();
            Toast.makeText(this, "Строк в базе данных: " + rows, Toast.LENGTH_SHORT).show();
            c.close();
        }else if (view.getId() == R.id.btnDelete){
            int count = db.delete("myTable", null, null);
            Toast.makeText(this, "Удалено строк: " + count, Toast.LENGTH_SHORT).show();
        }


        dbHelper.close();
    }

    class MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(@Nullable Context context) {
            super(context, "MyDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table myTable ("
                                    + "id integer primary key autoincrement,"
                                    + "first_name text,"
                                    + "last_name text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}