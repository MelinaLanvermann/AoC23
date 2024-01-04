import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input_day1.txt");
        Scanner readFile = new Scanner(inputFile);
        int sumOfAll = 0;
        ArrayList<String> linesOfFile = new ArrayList<String>();

        while (readFile.hasNextLine()) {
//            linesOfFile.add(readFile.nextLine().replaceAll("\\D+", "")); //part 1
            linesOfFile.add(readFile.nextLine()); //part 2
        }
        readFile.close();
        // part 1
//        for (int i = 0; i < linesOfFile.size(); i++) {
//            String thisLine = linesOfFile.get(i);
//            int first = Integer.parseInt(String.valueOf(thisLine.charAt(0)))*10;
//            int last = Integer.parseInt(String.valueOf(thisLine.charAt(thisLine.length()-1)));
//            sumOfAll += (first+last);
//        }

        for (int i = 0; i < linesOfFile.size(); i++) {
            System.out.println("line nr." + i);
            String thisLine = linesOfFile.get(i);
            String numbersLine = "";
            for (int j = 0; j < thisLine.length(); j++) {
                char checkPossibility = thisLine.charAt(j);
                Boolean possiblyNumber = possiblyNumberWord(checkPossibility);
                if (possiblyNumber) {
                    System.out.println("possibly a numberword");
                    try {
                        String find3Word = thisLine.substring(j, j + 3);
                        int x = Integer.parseInt(find3Word(find3Word));
                        numbersLine = numbersLine.concat(String.valueOf(x));
                        System.out.println("I found " + x + " the current Numbersline is : " + numbersLine);
                    } catch (Exception e) {
                        System.out.println("It wasn't a 3-letter numberword after all....");
                    }
                    try {
                        String find4Word = thisLine.substring(j, j + 4);
                        int x = Integer.parseInt(find4Word(find4Word));
                        numbersLine = numbersLine.concat(String.valueOf(x));
                        System.out.println("I found " + x + " the current NumbersLine is : " + numbersLine);
                    } catch (Exception e) {
                        System.out.println("It wasn't a 4-letter numberword after all....");
                    }
                    try {
                        String find5Word = thisLine.substring(j, j + 5);
                        int x = Integer.parseInt(find5Word(find5Word));
                        numbersLine = numbersLine.concat(String.valueOf(x));
                        System.out.println("I found " + x + " the current NumbersLine is : " + numbersLine);
                    } catch (Exception e) {
                        System.out.println("It wasn't a number after all....");
                    }
//                    String find4Word = thisLine.substring(j, j + 4);
//                    String find5Word = thisLine.substring(j, j + 5);
//                    System.out.println(find3Word+" "+find4Word+" "+find5Word);
                } else if (isNumber(checkPossibility)) {
                    numbersLine = numbersLine.concat(String.valueOf(thisLine.charAt(j)));
                }
            }
            int first = Integer.parseInt(String.valueOf(numbersLine.charAt(0)))*10;
            int last = Integer.parseInt(String.valueOf(numbersLine.charAt(numbersLine.length()-1)));
            System.out.println(numbersLine+" "+ first +" "+ last);
            sumOfAll += (first+last);

        }
        System.out.println(sumOfAll);
    }

    static Boolean possiblyNumberWord(char checkMe) {
        return switch (checkMe) {
            case 'o', 'n', 'e', 's', 'f', 't' -> true;
            default -> false;
        };
    }

    static Boolean isNumber(char checkMe) {
        return switch (checkMe) {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> true;
            default -> false;
        };
    }

    static String find3Word(String checkMe) {
        switch (checkMe) {
            case "one":
                return "1";
            case "two":
                return "2";
            case "six":
                return "6";
            default:
                break;
        }
        return "";
    }

    static String find4Word(String checkMe) {
        switch (checkMe) {
            case "four":
                return "4";
            case "five":
                return "5";
            case "nine":
                return "9";
            default:
                break;
        }
        return "";
    }

    static String find5Word(String checkMe) {
        switch (checkMe) {
            case "three":
                return "3";
            case "seven":
                return "7";
            case "eight":
                return "8";
            default:
                break;
        }
        return "";
    }
}
