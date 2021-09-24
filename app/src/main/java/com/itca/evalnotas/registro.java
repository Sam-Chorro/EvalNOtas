package com.itca.evalnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class registro extends AppCompatActivity {

    private ListView list;
    ArrayList<String> listinfo;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        AdminBase admin = new AdminBase(this, "EvalNotas", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        list = findViewById(R.id.list_titulo);

        listinfo= admin.llenarinfo();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listinfo);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Bundle enviar = new Bundle();
                Intent intent = new Intent(registro.this, vista.class);
                startActivity(intent);
            }
        });

    }


    public void back(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}