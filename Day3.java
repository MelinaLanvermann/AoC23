import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input_day3.txt");
        Scanner readFile = new Scanner(inputFile);
        ArrayList<String> fileLines = new ArrayList<String>();

        while (readFile.hasNextLine()) {
            fileLines.add(readFile.nextLine());
        }
        readFile.close();

        int rows = fileLines.size();
        int columns = fileLines.get(0).length();
        char[][] charArray = new char[rows][columns];
        ArrayList<String> schematicNumbers = new ArrayList<String>();
        int engineSum = 0;
        // copy to 2D Array
        for (int i = 0; i < rows; i++) {
            String thisLine = fileLines.get(i);
            for (int u = 0; u < thisLine.length(); u++) {
                charArray[i][u] = thisLine.charAt(u);
            }
        }


        for(int i = 0; i < charArray.length; i++){
            int number = 0;
            int digitCount = 0;
            for(int j = charArray[i].length - 1; j >= 0; j--){
                if(isNumber(charArray[i][j])){
                    number += (int) (Integer.parseInt(String.valueOf(charArray[i][j])) * Math.pow(10, digitCount));
                    digitCount++;
                    if(j == 0){
                        if (hasSchematicMarker2(j + 1, j + digitCount - 1, i, charArray)) {
                            System.out.println("Adding :" + number);
                            if(number == 863){
                                System.out.println("Params:" + (j+1) + " " + (j+digitCount) + " " + i);
                            }
                            engineSum += number;
                        }
                        number = 0;
                        digitCount = 0;
                    }
                }
                else{
                    if(number != 0) {
                        //System.out.println("Parameters:" + (j + 1) + " " + (j + digitCount) + " " + i);
                        if (hasSchematicMarker2(j + 1, j + digitCount, i, charArray)) {
                            System.out.println("Adding :" + number);
                            engineSum += number;
                        }
                        number = 0;
                        digitCount = 0;
                    }
                }
            }
        }

        /*int j = rows - 1;

        while (j > -1) {
            int k = columns - 1;
            int foundNumber = 0;
            boolean markerFound = true;
            int digitCounter = 0;
            int firstindex = 0; //last digit in nr but first one found
            int lastindex = 0; //first digit in nr but last one found
            while (k > -1) {
                if (isNumber(charArray[j][k])) {
                    foundNumber += (int) (Integer.parseInt(String.valueOf(charArray[j][k])) * Math.pow(10, digitCounter));
                    digitCounter++;

                    if (digitCounter == 0) {
                        firstindex = k;
                    }
                    if (k == 0) {
                        System.out.println(foundNumber);
                        engineSum += foundNumber;
                        foundNumber = 0;
                        digitCounter = 0;
                        lastindex = k;
                    } else if (!isNumber(charArray[j][k - 1])) {
                        System.out.println(foundNumber);
                        engineSum += foundNumber;
                        foundNumber = 0;
                        digitCounter = 0;
                        lastindex = k;
                    }
                    markerFound = hasSchematicMarker2(lastindex, firstindex, j, charArray);
                    if (markerFound) {
                        System.out.println("hi");
                    }
                }
                k--;
            }
            j--;
        }*/
        System.out.println(engineSum);
        System.out.println(hasSchematicMarker2(0, 2, 137, charArray));
        System.out.println(Arrays.toString(findSymbols(charArray).toArray()));
    }

    static boolean isNumber(char checkme) {
        try {
            int a = Integer.parseInt(String.valueOf(checkme));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    static boolean isSchematicMarker(char checkme) {
        return switch (checkme) {
            case '+', '-', '*', '/', '=', '&', '%', '$', '@', '#' -> true;
            default -> false;
        };
    }

    static boolean hasSchematicMarker(int first, int last, int row, char[][] charArray) {
//        int lengthofnr = (last +1) - first;
        for (int c = -1; c < 2; c++) {
            if (row == 0) {
                c = 0;
            }
            for (int v = first; v < last + 1; v++) {
                if (isSchematicMarker(charArray[row + c][v - 1])) {
                    return true;
                }
            }
            if (row == charArray.length - 1) {
                break;
            }
        }
        return false;
    }

    static boolean hasSchematicMarker2(int first, int last, int row, char[][] charArray) {
        int pos1;
        int pos2;
        if(first == 0){
            pos1 = first;
        }
        else {
            pos1 = first - 1;
        }

        if(last == charArray[row].length - 1){
            pos2 = last;
        }
        else {
            pos2 = last + 1;
        }
        int currentRow = row - 1;
        while(currentRow < charArray.length && currentRow <= row + 1) {
            if(currentRow >= 0) {
                for (int i = pos1; i <= pos2; i++) {
                    if(isSchematicMarker(charArray[currentRow][i])){
                        return true;
                    }
                }
            }
            currentRow++;
        }
        return false;
    }

    static Set<Character> findSymbols(char[][] arr){
        Set<Character> list = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(!isNumber(arr[i][j]) && arr[i][j] != '.'){
                    list.add(arr[i][j]);
                }
            }
        }
        return list;
    }
}