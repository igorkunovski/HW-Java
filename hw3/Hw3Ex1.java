/*
Реализовать алгоритм сортировки слиянием
 */

import java.util.Arrays;
import java.util.Random;

public class Hw3Ex1 {
    public static void main(String[] args) {

        int n = 25;

        int[] generated = generateArray(20);
        System.out.println(Arrays.toString(generated));
        mergeSortArr(generated);
        System.out.println(Arrays.toString(generated));
    }

    private static void mergeSortArr(int[] input) {

        int inputLength = input.length;
        if (inputLength <2){
            return;
        }
        int mid = inputLength /2;
        int[] leftHalf = new int [mid];
        int[] rightHalf = new int [inputLength - mid];

        for (int i = 0; i < mid; i++){
            leftHalf[i] = input[i];
        }
        for (int i = mid; i< inputLength; i++){
            rightHalf[i - mid] = input[i];
        }

        mergeSortArr(leftHalf);
        mergeSortArr(rightHalf);

        mergeArrays(leftHalf, rightHalf, input);
    }

    private static void mergeArrays(int[] leftHalf, int[] rightHalf, int[] input) {
        int i= 0, j =0, k=0;
        while (i < leftHalf.length && j < rightHalf.length){
            if (leftHalf[i] <= rightHalf[j]){
                    input[k] = leftHalf[i];
                    i++;
            }else {
                input[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i< leftHalf.length){
            input[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j< rightHalf.length){
            input[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    private static int[] generateArray(int n) {
        int [] array = new int[n];
        Random rnd = new Random();
        for (int i = 0; i< n; i++) {
            array[i] = rnd.nextInt(1, 20);
        }
        return array;
    }
}
