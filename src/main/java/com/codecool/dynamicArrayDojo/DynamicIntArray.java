package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    public int[] array;
    public int size = 0;

    public DynamicIntArray(int length) {
        array = new int[length];
    }

    public DynamicIntArray() {
        array = new int[size];
    }

    public void add(int number) {
        int size = array.length + 1;
        int[] result = Arrays.copyOf(array, size);
        result[array.length] = number;
        array = result;
    }

    public int[] remove(int number) {
        int index = findNumberIndexToRemove(number);

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
        return array = Arrays.copyOf(array, array.length-1);
    }

    public int[] insert(int index, int number) {
        array = Arrays.copyOf(array, array.length+1);

        if (index < array.length - 1) {

            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = number;
        }
        else {
            array[array.length - 1] = number;
        }
        return array;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < array.length; i++) {
            sb.append(" ").append(array[i]);
        }
        return sb.toString();
    }

    private int findNumberIndexToRemove(int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException("There is no number with this index");
    }


}
