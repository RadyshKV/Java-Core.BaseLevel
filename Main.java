package Home_Work_6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static String file1 = "file1.txt";
    public static String file2 = "file2.txt";
    public static String file3 = "file3.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word;
        String path;

        //2. Написать программу, «склеивающую» эти файлы,
        // то есть вначале идет текст из первого файла, потом текст из второго.
        mergeFiles(file1, file2, file3);

        //3. * Написать программу, которая проверяет присутствует
        // ли указанное пользователем слово в файле.
        System.out.println("Введите слово для поиска в файле");
        word = scanner.nextLine();
        System.out.println(searchWordInFile(file3, word) ? "Слово найдено" : "Слово не найдено");

        //4** Написать метод, проверяющий, есть ли указанное слово в папке,
        // внутри есть файлы, в которых может содержатся это слово
        System.out.println("Введите слово для поиска в папке");
        word = scanner.nextLine();
        System.out.println("Введите путь к папке");
        path = scanner.nextLine();
        System.out.println(searchWordInFolder(path, word) ? "Слово найдено" : "Слово не найдено");

    }

    public static void mergeFiles(String fileName1, String fileName2, String fileNameOut){
        StringBuilder stringBuilder = new StringBuilder();
        readFromFile(fileName1, stringBuilder);
        readFromFile(fileName2, stringBuilder);
        writeToFile(fileNameOut, stringBuilder);
    }

    public static boolean searchWordInFile(String fileName, String word){
        StringBuilder stringBuilder = new StringBuilder();
        readFromFile(fileName, stringBuilder);
        return stringBuilder.toString().toUpperCase().contains(word.toUpperCase());

    }

    public static boolean searchWordInFolder(String path, String word){

        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files == null) {
            return false;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && searchWordInFile(files[i].getName(), word)){
                return true;
            }
        }
        return false;
   }

    public static void readFromFile (String fileName, StringBuilder stringBuilder) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            int singleCharFile;
            while ((singleCharFile = isr.read()) != -1) {
                stringBuilder.append((char)singleCharFile);
            }
            isr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void writeToFile (String fileName, StringBuilder stringBuilder) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            osw.write(stringBuilder.toString());
            osw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
