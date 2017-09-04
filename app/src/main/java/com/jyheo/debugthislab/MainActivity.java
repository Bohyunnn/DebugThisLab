package com.jyheo.debugthislab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.jyheo.debugthislab.R.id.Name;

public class MainActivity extends AppCompatActivity {
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btnOK = (Button)findViewById(R.id.OK);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etName = (EditText)findViewById(Name);
                EditText etPhone = (EditText)findViewById(R.id.Phone);

                btnOK.setText("FAILED");
                if (etName.getText().toString().equals("john")) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
