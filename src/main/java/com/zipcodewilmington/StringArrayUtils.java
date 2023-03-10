package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        int l = array.length;
        return array[l-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        int l = array.length;
        return array[l-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(int i = 0; i<array.length; i++ )
            if(array[i].equals(value)){
                return true;
            }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String reverse[] = new String[array.length];
        int pos = (array.length -1);
        for(int i =0; i < array.length; i++){
            reverse[pos] = array[i];
            pos--;
        }
        return reverse;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        boolean isPalindromic = false;
        for(int i = 0; i<array.length; i++) {
            if(array[i].equals(reverse(array)[i])){
                isPalindromic = true;
            }
        }
        return isPalindromic;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i <array.length; i++) {
            sb.append(array[i].toLowerCase());
        }
        return sb.toString().replaceAll("[^a-z]", "").replaceAll("(.)(?=.*\\1)", "").length() == 26;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for(int i = 0; i<array.length; i++ )
            if(array[i].equals(value)){
               count++;
            }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        getNumberOfOccurrences(array, valueToRemove);
        int count = 0;
        String alteredArray[] = new String[array.length - getNumberOfOccurrences(array, valueToRemove)];
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                alteredArray[count] = array[i];
                count++;
            }
        }
        return alteredArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        int count = 0;
        int count1 = 0;
        for(int i = 0; i < array.length; i++) {
            //if end of the array, there is no next to compare to
            if (i == array.length-1) {
                break;
            } else {
            //compare the first value to the next value in the array
            if (array[i].equals(array[i + 1])) {
                count++;
                }
            }
        }
        String[] alteredArray = new String[array.length-count];
        for(int j = 0; j < array.length; j++){
            //if end of the array, there is no next to compare to
            if(j == array.length -1){
                alteredArray[count1] = array[j];
            }else{
                //compare the first value to the next value in the array
                if(!array[j].equals(array[j+1])){
                    //remove the value
                    alteredArray[count1] = array[j];
                    count1++;
                }
            }
        }
        return alteredArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        StringBuilder sb = new StringBuilder();
        String[] arrayResult = new String[100];
        ArrayList<String> arrayList = new ArrayList<>();

        sb.append(array[0]);
        if(!array[0].equals(array[1])){
            sb.append(" ");
        }
        for(int i = 1; i<array.length; i++){
            if(i!=array.length-1){
                if (array[i].equals(array[i+1])) {
                    sb.append(array[i]);
                }else {
                    sb.append(array[i]);
                    sb.append(" ");
                }
            }else{
                if(array[i].equals(array[i-1])){
                    sb.append(array[i]);
                }else{
                    sb.append(array[i]);
                }
            }
        }
        arrayResult = sb.toString().split(" ");

        for(int i = 0; i<arrayResult.length; i++){
            arrayList.add(arrayResult[i]);
        }
        return arrayList.toArray(new String[0]);
    }

}
