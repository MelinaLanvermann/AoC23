import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input_day3.txt");
        Scanner readFile = new Scanner(inputFile);
        ArrayList<String> charArray = new ArrayList<String>();

        while (readFile.hasNextLine()) {
            charArray.add(readFile.nextLine());
        }
        readFile.close();
        int rows = charArray.size();
        int columns = charArray.get(0).length();
        char[][] workMe = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            String thisLine = charArray.get(i);
            for (int u = 0; u < thisLine.length(); u++) {
                workMe[i][u] = thisLine.charAt(u);
            }
        }

        for (int c = 0; c < rows; c++) {
            for (int cc = 0; cc < columns; cc++) {
                Boolean isNumber = isNumber(workMe[c][cc]);
                if (isNumber){
                    System.out.println("it works");
                } else{
                    System.out.println("it didn't work");
                }
            }
        }
    }

    static Boolean isNumber (char checkme){
        try{
            int a = Integer.parseInt(String.valueOf(checkme));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    static void findSymbol (char checkme){
        switch (checkme){
            case "+"
        }
    }
}