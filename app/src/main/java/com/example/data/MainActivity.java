package com.example.data;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText usr,pass,repass;
    Button btt1;
    //String chk1,chk2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB=new DatabaseHelper(this);
        usr=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        repass=findViewById(R.id.repass);
        btt1=findViewById(R.id.btt1);
        AddData();

    }
    public void AddData(){
       // chk1=pass.getText().toString();
       // chk2=repass.getText().toString();

        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
               // if(chk1.equals(chk2)) {



                boolean Inserted = myDB.Insert(usr.getText().toString(), pass.getText().toString());
                if (Inserted = true) {
                    Toast.makeText(MainActivity.this, "the data is inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "the data doesn't inserted", Toast.LENGTH_SHORT).show();
                }
                 //} else {
                //Toast.makeText(MainActivity.this, "the password isn't matching", Toast.LENGTH_SHORT).show();
                // }
            }
        });
    }
}