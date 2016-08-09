package com.example.koki.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void confirmDelete(View view) {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(this);
        builder.setTitle("Delete")
                .setMessage("Are you sure you?")
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "OK Pressed",
                                        Toast.LENGTH_SHORT).show();
                            }})
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"Cancel Pressed",
                                        Toast.LENGTH_SHORT).show();
                            }});
        builder.create().show();
    }
}
