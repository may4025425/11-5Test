package com.fju.water3;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
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
        /*錯誤的地方...why?
        String num = String.valueOf(edmonth.getText().toString().isEmpty());
        String num2 = String.valueOf(ednext.getText().toString().isEmpty());*/
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                edmonth.setText("");
                ednext.setText("");
            }
        };

        float supplement;
        float price = 0; //要用它計算時就得設初值，不然會出錯

        if(TextUtils.isEmpty(edmonth.getText())&&TextUtils.isEmpty(ednext.getText())){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("錯誤")
                    .setMessage("無法計算")
                    .setPositiveButton("ok",listener)
                    .show();

        }else if(!TextUtils.isEmpty(edmonth.getText())){
            float useddegrees = Float.parseFloat(edmonth.getText().toString());
            //int useddegrees = Integer.parseInt(edmonth.getText().toString());
            if(useddegrees <11){
                supplement = 0 ;
                price = useddegrees * 7.35f + supplement;
            }else if (useddegrees < 31){
                supplement = 21 ;
                price = useddegrees * 9.45f + supplement;
            }else if (useddegrees < 51){
                supplement = 84 ;
                price = useddegrees * 11.55f + supplement;

            }else {
                supplement = 110.25f ;
                price = useddegrees * 12.075f + supplement;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用:" + price)
                    .setPositiveButton("ok",listener)
                    .show();
        }
        else{
            float useddegrees = Float.parseFloat(ednext.getText().toString());
            //int useddegrees = Integer.parseInt(edmonth.getText().toString());
            if(useddegrees <11){
                supplement = 0 ;
                price = useddegrees * 7.35f + supplement;
            }else if (useddegrees < 31){
                supplement = 42 ;
                price = useddegrees * 9.45f + supplement;
            }else if (useddegrees < 51){
                supplement = 168 ;
                price = useddegrees * 11.55f + supplement;

            }else {
                supplement = 220.5f ;
                price = useddegrees * 12.075f + supplement;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用:" + price)
                    .setPositiveButton("ok",listener)
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
