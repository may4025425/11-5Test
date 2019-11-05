package com.fju.water3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

        String num = String.valueOf(edmonth.getText().toString().isEmpty());
        String num2 = String.valueOf(ednext.getText().toString().isEmpty());

        /*boolean isEmpty(){
            if (num == null || num.length() == 0) {
                return true;
            } else {
                return false;
            }
        }*/
        if(false){
            float n = Float.parseFloat(num);
            if(n <11){
                n = n * 7.35f;
            }else if (n < 31){
                n = n * 9.45f;
            }else if (n < 51){
                n = n *11.55f;
            }else {
                n = n * 12.075f;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用:" + n)
                    .show();
        }else {
            float n2 = Float.parseFloat(num2);
            if(n2 <20){
                n2 = n2 * 7.35f;
            }else if (n2 < 60){
                n2 = n2 * 9.45f + 21;
            }else if (n2 < 100){
                n2 = n2 *11.55f + 84;
            }else {
                n2 = n2 * 12.075f + 110.25f;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表費用")
                    .setMessage("費用:" + n2)
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
