package lab1;

import java.util.Scanner;

public class q05_Palindrome {
    private static String stringReverse(String string){
        int length = string.length();
        char[] stringArray = string.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            char temp = stringArray[i];
            stringArray[i] = stringArray[length - i - 1];
            stringArray[length - i - 1] = temp;
        }

        return String.valueOf(stringArray);
    }

    private static boolean isPalindrome(String string){
        String filteredString = string.replace(" ", "");
        String reversedString = stringReverse(filteredString);
        return  filteredString.equals(reversedString) ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String string = sc.nextLine();

        System.out.println("Is " + string + " palindrome? " + (isPalindrome(string) ? "YES" : "NO"));
    }
}
