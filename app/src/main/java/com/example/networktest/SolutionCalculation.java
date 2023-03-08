package com.example.networktest;

import java.util.Arrays;

public class SolutionCalculation extends Thread {
    private String matriculationNumber;
    private String solution;

    public SolutionCalculation(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public void run() {
        int[] matriculationNumberArray = convertStringToIntArray(matriculationNumber);
        Arrays.sort(matriculationNumberArray);
        solution = Arrays.toString(matriculationNumberArray);
    }

    public int[] convertStringToIntArray(String matriculationNumber) {
        int[] numberArray = new int[matriculationNumber.length()];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = Character.getNumericValue(matriculationNumber.charAt(i));
        }
        return numberArray;
    }

    public String getSolution() {
        return solution;
    }

}
