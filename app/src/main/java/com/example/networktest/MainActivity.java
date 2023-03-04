package com.example.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.networktest.TCP.TCPClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userInput = findViewById(R.id.et_main_matriculationNumber);
        Button submit = findViewById(R.id.btn_main_submit);
        //TextView solution = findViewById(R.id.tv_main_serverAnswer);

        submit.setOnClickListener(view -> {
            TCPClient client = new TCPClient(userInput.getText().toString());
            client.start();
        });
    }
}