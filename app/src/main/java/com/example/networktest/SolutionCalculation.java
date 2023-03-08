package com.example.networktest;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionCalculation extends Thread {
    private String matriculationNumber;
    private String solution;

    public SolutionCalculation(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }
    public void run() {
        ArrayList<Integer> matriculationNumberArrayList = convertStringToIntArrayList(matriculationNumber);
        Collections.sort(matriculationNumberArrayList);
        solution = matriculationNumberArrayList.toString();
    }

    public ArrayList<Integer> convertStringToIntArrayList(String matriculationNumber) {
        ArrayList<Integer> numberArrayList = new ArrayList<>();
        for (int i = 0; i < matriculationNumber.length(); i++) {
            numberArrayList.add(Character.getNumericValue(matriculationNumber.charAt(i)));
        }
        return numberArrayList;
    }

    public String getSolution() {
        return solution;
    }

}
