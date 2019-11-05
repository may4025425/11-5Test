package com.fju.water3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edmonth;
    private EditText ednext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void find() {
        edmonth = findViewById(R.id.month);
        ednext = findViewById(R.id.next);
    }
    public void calculate(View v){
        TextUtils.isEmpty(String.valueOf(edmonth));
        if(false){
            double num = Double.parseDouble(edmonth.getText().toString());
            if(num <11){
                num = num * 7.35f;
            }else if (num < 31){
                num = num * 9.45f;
            }else if (num < 51){
                num = num *11.55f;
            }else {
                num = num * 12.075f;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用:" + num)
                    .show();
        }else {
            double num1 = Double.parseDouble(ednext.getText().toString());
            if(num1 <11){
                num1 = num1 * 7.35f;
            }else if (num1 < 31){
                num1 = num1 * 9.45f;
            }else if (num1 < 51){
                num1 = num1 *11.55f;
            }else {
                num1 = num1 * 12.075f;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表費用")
                    .setMessage("費用:" + num1)
                    .show();

        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
