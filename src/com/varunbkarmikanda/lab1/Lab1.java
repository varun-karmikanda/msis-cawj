package com.varunbkarmikanda.lab1;

public class Lab1 {

    public record SortedResult(String sortedString, int length){}

    private static SortedResult alphabeticOrderSorter(String string){

        char[] stringArray = string.toCharArray();
        int length = string.length();

        for (int i = 0; i< length; i++){
            for (int j = i + 1; j < length; j++){
                if(stringArray[j] < stringArray[i]){
                    char temp = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }

        String sortedString = String.valueOf(stringArray);

        return new SortedResult(sortedString, length);
    }

    private static String stringReverse(String string){
        int length = string.length();
        char[] stringArray = string.toCharArray();
        for (int i = 0; i < length / 2; i++){
            char temp = stringArray[i];
            stringArray[i] = stringArray[length - i - 1];
            stringArray[length - i - 1] = temp;
        }
        return String.valueOf(stringArray);
    }

    public static boolean isPalindrome(String string){
        String filteredString = string.replace(" ", "");
        String reversedString = stringReverse(filteredString);
        if(!filteredString.equals(reversedString)) return  false;
        return true;
    }

    public static int vovelCount(String string){
        int count = 0;
        String loweredString = string.toLowerCase();
        int length = loweredString.length();
        for (int i = 0; i < length;i++){
            char ch = string.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') count++;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println("Hello, World!");

        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);

        int result = Integer.parseInt(args[0]) + Integer.parseInt(args[1]) + Integer.parseInt(args[2]);
        System.out.println("sum of three arguments: " + result);

        SortedResult sr = alphabeticOrderSorter("varun");
        System.out.println("Sorted string: " + sr.sortedString);
        System.out.println("String length: " + sr.length);


        System.out.println("Is racecar palindrome: " + isPalindrome("racecar"));
        System.out.println("Is racecar palindrome: " + isPalindrome("nitr0x"));
        System.out.println("Is racecar palindrome: " + isPalindrome("6776"));

        System.out.println("Vovels in 'varun' is: " + vovelCount("varun"));
        System.out.println("Vovels in 'msis manipal' is: " + vovelCount("msis manipal"));
    }
}
