package ru.geekbrains.Home_Work_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        byte byteValue = 120;
        short shortValue = 1250;
        int intValue = 32000;
        long longValue = 505050L;
        float floatValue = 3.2f;
        double doubleValue = 5.9d;
        char charValue = 'x';
        String strvalue = "kjsdghfkh";
        boolean boolValue = true;

        int a = 4;
        int b = 5;
        int c = 6;
        int d = 3;

        Scanner console = new Scanner(System.in);

        System.out.println(a + "* (" + b + " + (" + c + " / " + d + ")) = " + calc(a, b, c, d));

        System.out.println(summ(a,b));

        System.out.println("Введите число от 100 до 999 включительно");
        invers(console.nextInt());

        System.out.println("Введите год");
        leapYear(console.nextInt());

        console.close();
    }

    //метод вычисляющий выражение a * (b + (c / d))
    public static int calc(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    //метод, принимающий на вход два числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно)
    public static boolean summ(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    //метод, который принимает число. Если данное число больше 100 и меньше 999 включительно -
    // выводит в консоль цифры данного числа в обратном порядке
    public static void invers(int val) {
        int units;
        int tens;
        int hundreds;
        if (val>100 && val<=999){
            hundreds = val/100;
            tens = (val - hundreds*100)/10;
            units = val - hundreds*100 - tens*10;
            System.out.println("Инвертированное число равно "+ units + tens+ hundreds);
        }
    }

    //метод, который определяет является ли год високосным
    public static void leapYear(int year){
        boolean conLeapYear = (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
        if (conLeapYear) System.out.println("Год "+ year +" - високосный");
        else System.out.println("Год "+ year +" - не високосный");
    }

}