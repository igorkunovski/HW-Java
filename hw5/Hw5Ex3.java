/*
Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */

import java.util.Arrays;
import java.util.Random;


public class Hw5Ex3 {
    public static void main(String[] args) {

        int n = 25;
        int[] generated = generateArray(20);
        System.out.println(Arrays.toString(generated));

        heapSortArr(generated);
        System.out.println(Arrays.toString(generated));

    }

    private static void heapSortArr(int[] array) {

        int n = array.length;
        for (int i = n/2 -1; i>=0; i--) {
            updateHeap(array, i, n);
        }
        for (int i = n -1; i>= 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            updateHeap(array, 0, i);
        }
    }

    private static void updateHeap(int[] array, int i, int n) {
        int left = i * 2 +1;
        int right = i * 2 +2;
        int largest = i;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (i!=largest){
            swapLargest(array, i, largest);

            updateHeap(array, largest, n);
        }
    }

    private static void swapLargest(int[] array, int i, int largest) {
        int temp = array[i];
        array[i] = array[largest];
        array[largest] = temp;
    }

    private static int[] generateArray(int n) {
        int [] array = new int[n];
        Random rnd = new Random();
        for (int i = 0; i< n; i++) {
            array[i] = rnd.nextInt(-10, 50);
        }
        return array;
    }
}
