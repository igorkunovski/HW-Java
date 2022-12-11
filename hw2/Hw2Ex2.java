/*
Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Hw2Ex2 {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[]{5, 9, -12, 2, 58, -4, -5, 3, 17};
        System.out.println(Arrays.toString(bubbleSorted(arr)));
    }

    private static int[] bubbleSorted(int[] array) throws IOException {

        Logger logger = Logger.getLogger(Hw2Ex2.class.getName());
        FileHandler fh = new FileHandler("C:\\Users\\Laptop\\IdeaProjects\\HW-Java\\hw2\\logArr.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sForm = new SimpleFormatter();
        fh.setFormatter(sForm);

        for (int i = 0; i < array.length -1; i++){

            logger.log(Level.INFO, Arrays.toString(array));

            for (int j = 0; j < array.length -1 - i; j++){
                if (array[j] > array[j+1]){
                    swap(array, j);
                }
            }
        }
        logger.log(Level.INFO,"  **end** \n");
        return array;
    }

    private static void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j +1];
        array[j +1] = temp;
    }
}
