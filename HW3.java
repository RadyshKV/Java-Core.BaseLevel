package ru.geekbrains.Home_Work_3;

import java.util.Random;
import java.util.Scanner;

public class HW3 {

    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    public static final int fieldSizeX = 5;
    public static final int fieldSizeY = 5;
    public static final int winSeries = 4; // выигрышный ряд
    public static char[][] field = new char[fieldSizeY][fieldSizeX];

    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    public static int pcDotX;
    public static int pcDotY;

    public static void initMap() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        System.out.print("\t ");
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print((x+1) + " ");
        }
        System.out.println();
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y+1+"\t|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static boolean isValidCell(int y, int x) {

        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    public static boolean isEmptyCell(int y, int x) {

        return checkCell(y, x, EMPTY_DOT);
    }

    public static boolean checkCell(int y, int x, char dot) {

        return field[y][x] == dot;
    }

    public static boolean isFullMap() {

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static void humanTurn() {

        int x;
        int y;
        do {
            System.out.println("Введите координаты - столбец и строка: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        field[y][x] = HUMAN_DOT;
    }

    public static void pcTurn() {

        if (!getPCTurnWin()) {
            if (!getPCTurnBlock()) {
                do {
                    pcDotX = random.nextInt(fieldSizeX);
                    pcDotY = random.nextInt(fieldSizeY);
                } while (!isEmptyCell(pcDotY, pcDotX));
            }
        }
        field[pcDotY][pcDotX] = PC_DOT;
    }

    // метод поиска выигрышного хода
    public static boolean getPCTurnWin() { return getPCTurn(PC_DOT); }

    // метод поиска блокирующего хода
    public static boolean getPCTurnBlock() { return getPCTurn(HUMAN_DOT); }

    public static boolean getPCTurn(char dot) {

        int count;
        int emptyCount;

        // поиск предвыигрышной строки
        for (int y = 0; y < fieldSizeY; y++) { // перебираем строки
            for (int x = 0; x <= fieldSizeX - winSeries; x++) { // перебираем первые элементы комбинаций (не превышаем длину комбинаций)
                count = 0;
                emptyCount = 0;

                for (int z = 0; z < winSeries; z++) { // проверяем комбинацию
                    if (checkCell(y, z + x, dot)) count++;
                    if (isEmptyCell(y, z + x)) {
                        pcDotY = y;
                        pcDotX = z + x;
                        emptyCount++;
                    }
                }
                if (count == winSeries-1 && emptyCount == 1) return true;
            }
        }

        // поиск предвыигрышного столбца
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y <= fieldSizeY - winSeries; y++) {
                count = 0;
                emptyCount = 0;

                for (int z = 0; z < winSeries; z++) {
                    if (checkCell(z + y, x, dot)) count++;
                    if (isEmptyCell(z + y, x)) {
                        pcDotY = z + y;
                        pcDotX = x;
                        emptyCount++;
                    }
                }
                if (count == winSeries-1 && emptyCount == 1) return true;
            }
        }

        // поиск предвыигрышной косой линии
        for (int x = 0; x <= fieldSizeX-winSeries; x++) {
            for (int y = 0; y <= fieldSizeY-winSeries; y++) {
                count = 0;
                emptyCount = 0;
                for (int z = 0; z < winSeries; z++) {
                    if (checkCell(y + z, x + z, dot)) count++;
                    if (isEmptyCell(y + z, x + z)) {
                        pcDotY = y + z;
                        pcDotX = x + z;
                        emptyCount++;
                    }
                }
                if (count == winSeries-1 && emptyCount == 1) return true;
            }

            for (int y = 0; y <= fieldSizeY-winSeries; y++) {
                count = 0;
                emptyCount = 0;
                for (int z = 0; z < winSeries; z++) {
                    if (checkCell(fieldSizeY - 1 - y - z, x + z, dot)) count++;
                    if (isEmptyCell(fieldSizeY - 1 - y - z, x + z)) {
                        pcDotY = fieldSizeY - 1 - y - z;
                        pcDotX = x + z;
                        emptyCount++;
                    }
                }
                if (count == winSeries-1 && emptyCount == 1) return true;
            }
        }
        return false;
    }

    public static boolean checkWin(char dot) {

        int count;

        // проверка строк
        for (int y = 0; y < fieldSizeY; y++) {
            count = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkCell(y, x, dot)){
                    count ++;
                } else {
                    count = 0;
                }
                if (count == winSeries) return true;
            }
        }

        // проверка столбцов
        for (int x = 0; x < fieldSizeX; x++) {
            count = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (checkCell(y, x, dot)){
                    count ++;
                } else {
                    count = 0;
                }
                if (count == winSeries) return true;
            }
        }

        // проверка косых линий
        for (int x = 0; x <= fieldSizeX-winSeries; x++) {
            for (int y = 0; y <= fieldSizeY-winSeries; y++) {
                count = 0;
                for (int z = 0; z < winSeries; z++) {
                    if (checkCell(y + z, x + z, dot)) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                if (count == winSeries) return true;
            }

            for (int y = 0; y <= fieldSizeY-winSeries; y++) {
                count = 0;
                for (int z = 0; z < winSeries; z++) {
                    if (checkCell(fieldSizeY - 1 - y - z, x + z, dot)) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                if (count == winSeries) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Выиграл человек!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья.");
                break;
            }
            System.out.println();
            pcTurn();
            printMap();
            if (checkWin(PC_DOT)) {
                System.out.println("Выиграл ПК!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья.");
                break;
            }
            System.out.println();
        }
    }
}
