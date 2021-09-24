package com.itca.evalnotas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class vista extends AppCompatActivity {

    private EditText edit1, edit2, edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista);

        AdminBase admin = new AdminBase(this, "EvalNotas", null, 1);

        edit1 = findViewById(R.id.titulores);
        edit2 = findViewById(R.id.desre);
        edit3 = findViewById(R.id.autorres);




    }



    public void borrar(View view) {
        AdminBase admin = new AdminBase(this, "EvalNotas", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String t = edit1.getText().toString();
        String d = edit2.getText().toString();
        String a = edit3.getText().toString();

        if (!t.isEmpty() && !d.isEmpty() && a.isEmpty()) {


            Toast.makeText(this, "Rellene todos los campos antes de eliminar", Toast.LENGTH_LONG).show();
        }

        }

    public void back(View view) {

        Intent i = new Intent(this, registro.class);
        startActivity(i);

    }
}
