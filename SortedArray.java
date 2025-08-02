package dev.lpa;
import java.util.Scanner;

public class SortedArray {

     public static int[] getIntegers(int size) {
         Scanner input = new Scanner(System.in);
        int[] array = new int[size];

        for (int i = 0; i < size; i++){
            System.out.print("Enter an integer: " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        input.close();
        return array;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ": " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array){
        int[] sortedArray = new int[array.length];

        //Copy the original array to the sorted array
        for (int i =0; i < array.length; i++){
            sortedArray[i] = array[i];
        }

        //Sort array in descending order using bubble sort
        for (int i = 0; i < sortedArray.length; i++){
            for (int j = i + 1; j < sortedArray.length; j++){
                if (sortedArray[i] < sortedArray[j]){
                    //Swap elements
                    int temp =  sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray;
    }
}
