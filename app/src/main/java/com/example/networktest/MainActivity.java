package com.example.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.networktest.TCP.TCPClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText userInput = findViewById(R.id.et_main_matriculationNumber);
        Button submit = findViewById(R.id.btn_main_submit);
        TextView serverAnswer = findViewById(R.id.tv_main_serverAnswer);
        TextView solution = findViewById(R.id.tv_main_solution);

        submit.setOnClickListener(view -> {
            TCPClient client = new TCPClient(userInput.getText().toString());
            SolutionCalculation solutionCalculation = new SolutionCalculation(userInput.getText().toString());
            client.start();
            solutionCalculation.start();
            try {
                client.join();
                serverAnswer.setText(client.getServerAnswer());
                solutionCalculation.join();
                solution.setText(solutionCalculation.getSolution());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}