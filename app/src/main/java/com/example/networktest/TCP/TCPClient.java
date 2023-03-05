package com.example.networktest.TCP;

import java.io.*;
import java.net.*;

public class TCPClient extends Thread {
    private String matriculationNumber;
    private String serverAnswer;

    public TCPClient(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public void run() {
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(matriculationNumber + '\n');
            serverAnswer = inFromServer.readLine();
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getServerAnswer() {
        return serverAnswer;
    }
}
