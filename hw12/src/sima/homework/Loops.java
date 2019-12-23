package sima.homework;


import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
    /*    { Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number for calculation the factorial: ");
        int number = scan.nextInt();
        System.out.println("Factorial is " + factorial(number));
        }*/

        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the number for calculation the pow: ");
            System.out.println("Power is: " + pow(scan.nextInt(), scan.nextInt()));
        }

    }


    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int pow(int a, int b) {
        int pow = a;
        for (int i = 0; i < b - 1; i++) {
            pow *= a;
        }
        return pow;
    }

}
