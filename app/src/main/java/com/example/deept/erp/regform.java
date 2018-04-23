package com.example.deept.erp;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class regform extends AppCompatActivity {
    Button btnsub;
    EditText fname,lname,dob,eid,mobno;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = openOrCreateDatabase("Registration", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Regform(fname VARCHAR, lname VARCHAR, eid VARCHAR, mobno VARCHAR, dob VARCHAR)");

        setContentView(R.layout.activity_regform);
        fname=(EditText) findViewById(R.id.fname);
        lname=(EditText) findViewById(R.id.lname);
        dob=(EditText) findViewById(R.id.dob);
        eid=(EditText) findViewById(R.id.mail);
        mobno=(EditText) findViewById(R.id.mobno);
        btnsub=(Button) findViewById(R.id.buttonsub);
        btnsub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                if (v == btnsub)
                {
                    if (fname.getText().toString().trim().length()==0
                            ||lname.getText().toString().trim().length()==0
                            ||eid.getText().toString().trim().length()==0
                            ||mobno.getText().toString().trim().length()==0
                            ||dob.getText().toString().trim().length()==0)
                    {
                        showMessage ("Error", "Please enter all values");
                        return;
                    }
                    db.execSQL("INSERT INTO Regform VALUES('" + fname.getText() + "','" + lname.getText() + "', '" + eid.getText() + "', '" + mobno.getText() + "', '" + dob.getText() + "');");
                    showMessage("Success", "Form Submitted");
                    ClearText();
                }

            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void ClearText()
    {
        fname.setText("");
        lname.setText("");
        eid.setText("");
        mobno.setText("");
        dob.setText("");

    }

}
