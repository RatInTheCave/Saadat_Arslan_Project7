package Part1_Bubble_Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bubble_Sort {
    public static void main(String[] args) {
        TheLoop();
    }

    public static void TheLoop() {
        boolean RestartFlag = true;
        while (RestartFlag) {
            String RestartString = GetUserString("Do you wish to try the program? Answer with Y or N");
            if (RestartString.toLowerCase().contains("y")) {
                ChooseArray();
            } else if (RestartString.toLowerCase().contains("n")) {
                System.out.println("Turning off...");
                RestartFlag = false;
            } else {
                System.out.println("I don't understand");
            }
        }
    }

    public static void ChooseArray() {
        boolean MenuFlag = false;
        while (!MenuFlag) {
            String UserChoice = GetUserString("Please choose: \n 1. Random Array \n 2. User Array");
            if (UserChoice.toLowerCase().contains("1")) {
                MenuFlag = true;
                System.out.println(Arrays.toString(BubbleSort(CreateRandomArray())));
            } else if (UserChoice.toLowerCase().contains("random")) {
                MenuFlag = true;
                System.out.println(Arrays.toString(BubbleSort(CreateRandomArray())));
            } else if (UserChoice.toLowerCase().contains("2")) {
                MenuFlag = true;
                System.out.println(Arrays.toString(BubbleSort(InputArray())));
            } else if (UserChoice.toLowerCase().contains("user")) {
                MenuFlag = true;
                System.out.println(Arrays.toString(BubbleSort(InputArray())));
            } else {
                System.out.println("I am not sure what you mean");
            }
        }
    }

    public static int[] BubbleSort(int[] array) {
        print("Initial Array: ");
        print(Arrays.toString(array));
        int InnerCount = 1;
        int OuterCount = 1;
        for (int i = 0; i < array.length; i++) {
            print(" ");
            System.out.println(("Outer loop, iteration " + OuterCount + ":"));
            OuterCount++;
            print(Arrays.toString(array));
            System.out.println("Inner loop:");
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    BubbleSwap(array, j, j - 1);
                    System.out.println("Iteration " + InnerCount + ":");
                    PrintBold(array, j);
                    InnerCount++;
                }
            }
        }
        return array;
    }

    public static void BubbleSwap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int ArrayLength() {
        return GetUserInt("Please input array length");
    }

    public static int[] CreateRandomArray() {
        int[] ResultArray = new int[ArrayLength()];
        Random rng = new Random();
        for (int i = 0; i < ResultArray.length; i++) {

            ResultArray[i] = rng.nextInt(0, 10);
        }
        return ResultArray;
    }

    public static int[] InputArray() {

        int[] ResultArray = new int[ArrayLength()];
        for (int i = 0; i < ResultArray.length; i++) {
            ResultArray[i] = GetUserInt("Please input " + i + " element of an array");
        }
        return ResultArray;
    }

    public static int GetUserInt(String systemMessage) {
        Scanner userScanner = new Scanner(System.in);
        print(systemMessage);
        return userScanner.nextInt();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static String GetUserString(String systemMessage) {
        Scanner userScanner = new Scanner(System.in);
        print(systemMessage);
        return userScanner.nextLine();
    }
    public static void PrintBold(int[] array, int i){
        System.out.print("[");
        for (int k = 0; k < array.length; k++){
            if ((k == i-1) || (k == i)){
                System.out.print("\033[0;1m" + array[k] + "\033[0m");
            }
            else {
            System.out.print(array[k]);
        }
            if (k < array.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
