package com.company.dop;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Number of elements = ");

        Scanner sc = new Scanner(System.in);
        int lSize;
        lSize = sc.nextInt();
        System.out.println();
        System.out.println("Unsorted elements:");
        ArrayList<Integer> numList = new ArrayList<>();

        for (int n = 0; n < lSize; n++) {
            numList.add((int) (Math.random() * 128));
            System.out.println("Element №" + n + " = " + numList.get(n));

        }
        System.out.println();
        System.out.println("The sheet is sorted in ascending order:");
        for (int i = 0; i < lSize - 1; i++) {
            for (int j = 0; j < lSize - 1; j++){
                if (numList.get(j) > numList.get(j + 1)) {
                    int tmp = numList.get(j);
                    numList.set(j, numList.get(j + 1));
                    numList.set((j + 1), tmp);

                }
            }
        }
        for(int n = 0;n < lSize; n++) {
            System.out.println ("Element №" + n + " = " + numList.get(n));
        }
        System.out.println();
        System.out.println("The sheet is sorted in descending order:");
        for (int i = 0;i < lSize - 1;i++){
            for(int j = 0;j < lSize - 1;j++){
                if (numList.get(j) < numList.get(j+1)) {
                    int tmp = numList.get(j);
                    numList.set(j, numList.get(j + 1));
                    numList.set((j + 1), tmp);

                }
            }
        }
        for(int n = 0;n < lSize; n++) {
            System.out.println ("Element №" + n + " = " + numList.get(n));
        }
    }
}
