package lab1;

import java.util.Scanner;

public class q04_StringSortLength {
    public record StoredResult(String sortedString, int length){}

    private static  void merge(char[] stringArray, int low, int mid, int high){
        int left = low;
        int right = mid + 1;
        int i = low;
        char[] temp = new char[high + 1];

        while (left <= mid && right <= high){
            if(stringArray[left] <= stringArray[right])
                temp[i++] = stringArray[left++];
            else
                temp[i++] = stringArray[right++];
        }

        while (left <= mid){
            temp[i++] = stringArray[left++];
        }

        while (right <= high){
            temp[i++] = stringArray[right++];
        }

        for (int k = low; k <= high; k++) {
            stringArray[k] = temp[k];
        }
    }

    private static void mergeSort(char[] stringArray, int low, int high){
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(stringArray, low, mid);
            mergeSort(stringArray, mid + 1, high);
            merge(stringArray, low, mid, high);
        }
    }

    private static StoredResult alphabeticOrderSorter(String string){
        char[] stringArray = string.toCharArray();
        int length = string.length();

        mergeSort(stringArray, 0, length - 1);

        String sortedString = String.valueOf(stringArray);

        return new StoredResult(sortedString, length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = sc.nextLine();

        StoredResult sr = alphabeticOrderSorter(string);
        System.out.println("Sorted string: " + sr.sortedString());
        System.out.println("String length: " + sr.length());
    }
}
