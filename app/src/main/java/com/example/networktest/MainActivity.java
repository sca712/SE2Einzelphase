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

        EditText userInput = findViewById(R.id.editText_matriculation_number);
        Button submit = findViewById(R.id.button_submit);
        //TextView solution = findViewById(R.id.text_solution);

        submit.setOnClickListener(view -> {
            TCPClient client = new TCPClient(userInput.getText().toString());
            client.start();
        });
    }
}