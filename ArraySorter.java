package dev.lpa;

import java.util.Arrays;

class ArraySorter {
    int[] sortArray = {50, 25, 80, 5, 15};

    public ArraySorter(int[] sortArray) {
        this.sortArray = sortArray;
    }

    public void setSortArray(int[] sortArray) {
        this.sortArray = sortArray;
    }

    public int[] getSortArray() {
        return sortArray;
    }

    public void sortDescending(){
        Arrays.sort(sortArray);
    }

    public void countBackwards(){
        for (int i = sortArray.length - 1; i >= 0; i--) {
            System.out.println(sortArray[i]);
        }
    }

    public void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public void printArray(){
        for (int i = 0; i < sortArray.length; i++){
            System.out.println(sortArray[i] + " ");
        }
    }
}
