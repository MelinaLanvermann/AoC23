import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input_day1.txt");
        Scanner readFile = new Scanner(inputFile);
        int sumOfAll = 0;
        ArrayList<String> linesOfFile = new ArrayList<String>();

        while (readFile.hasNextLine()) {
            linesOfFile.add(readFile.nextLine().replaceAll("\\D+", ""));
        }
        readFile.close();
        for (int i = 0; i < linesOfFile.size(); i++) {
            String thisLine = linesOfFile.get(i);
            int first = Integer.parseInt(String.valueOf(thisLine.charAt(0)))*10;
            int last = Integer.parseInt(String.valueOf(thisLine.charAt(thisLine.length()-1)));
            sumOfAll += (first+last);
        }
        System.out.println(sumOfAll);
    }
}
