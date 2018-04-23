package com.example.deept.erp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class base extends AppCompatActivity {
EditText usrname,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Button btn = (Button)findViewById(R.id.button);
        usrname = (EditText)findViewById(R.id.editText);
        pass = (EditText)findViewById(R.id.editText3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usrname.getText().toString().equals("vaishnavi") && pass.getText().toString().equals("12345"))
                {

                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),News.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Enter Correct Username and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
//
//    public void openmain2(View view) {
//        Intent intent = new Intent(this, News.class);
//        startActivity(intent);
//    }
    public void regForm(View view) {
        Intent intent = new Intent(this, regform.class);
        startActivity(intent);
    }
}
