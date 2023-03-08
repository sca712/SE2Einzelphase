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
        solution = getPrimeArray(matriculationNumberArrayList).toString();
    }

    public ArrayList<Integer> convertStringToIntArrayList(String matriculationNumber) {
        ArrayList<Integer> numberArrayList = new ArrayList<>();
        for (int i = 0; i < matriculationNumber.length(); i++) {
            numberArrayList.add(Character.getNumericValue(matriculationNumber.charAt(i)));
        }
        return numberArrayList;
    }

    public ArrayList<Integer> getPrimeArray(ArrayList<Integer> arrayList) {
        ArrayList<Integer> numberArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (!isPrime(arrayList.get(i))) {
                numberArrayList.add(arrayList.get(i));
            }
        }
        return numberArrayList;
    }

    //The simplest primality test is trial division: given an
    // input number, n, check whether it is evenly divisible by any prime number
    // between 2 and √n (i.e. that the division leaves no remainder).
    // If so, then n is composite. Otherwise, it is prime.
    //Source = https://en.wikipedia.org/wiki/Primality_test
    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public String getSolution() {
        return solution;
    }

}
