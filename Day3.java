import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
        int j = 0;
        while (j < rows) {
            int k = 0;
            String foundNumber = "";
            while (k < columns) {
                boolean markerFound = false;
                if (isNumber(charArray[j][k])) {
                    foundNumber = foundNumber.concat(String.valueOf(charArray[j][k]));
                    int schematicRow = j;
                    int schematicCol = k;
                    for (int c = 0; c < 9; c++) {
                        System.out.println("starting to check...");
                        while (c == 1) {
                            try {
                                schematicRow = schematicRow-1;
                                if (isSchematicMarker(charArray[schematicRow][schematicCol])) {
                                    System.out.println("I have found a marker at : "+schematicRow+"/"+schematicCol);
                                    markerFound = true;
                                }
                            } catch (Exception e) {
                                c++;
                            }
                        }
                        while (c == 2) {
                            try {
                                schematicCol= schematicCol-1;
                                if (isSchematicMarker(charArray[schematicRow][schematicCol])) {
                                    System.out.println("I have found a marker at : "+schematicRow+"/"+schematicCol);
                                    markerFound = true;
                                }
                            } catch (Exception e) {
                                c++;
                            }
                        }
                        while (c > 2 && c < 5) {
                            try {
                                schematicRow = schematicRow+1;
                                if (isSchematicMarker(charArray[schematicRow][schematicCol])) {
                                    System.out.println("I have found a marker at : "+schematicRow+"/"+schematicCol);
                                    markerFound = true;
                                }
                            } catch (Exception e) {
                                c++;
                            }
                        }
                        while (c > 4 && c < 7) {
                            try {
                                schematicCol = schematicCol+1;
                                if (isSchematicMarker(charArray[schematicRow][schematicCol])) {
                                    System.out.println("I have found a marker at : "+schematicRow+"/"+schematicCol);
                                    markerFound = true;
                                }
                            } catch (Exception e) {
                                c++;
                            }
                        }
                        while (c > 6 && c < 9) {
                            try {
                                schematicRow = schematicRow-1;
                                if (isSchematicMarker(charArray[schematicRow][schematicCol])) {
                                    System.out.println("I have found a marker at : "+schematicRow+"/"+schematicCol);
                                    markerFound = true;
                                }
                            } catch (Exception e) {
                                c++;
                            }
                        }

                    }
                    try{
                        if (!isNumber(charArray[j][k+1])){
                            if (markerFound){
                                System.out.println("I have found schematic number : " + foundNumber + ".\n The current engine sum is : " + engineSum);
                                engineSum += Integer.parseInt(foundNumber);
                                foundNumber = "";
                                markerFound = false;
                            } else {
                                System.out.println("A number was found but it is not a schematic number");
                                foundNumber ="";
                                markerFound = false;
                            }
                        }
                    } catch (Exception e){
                        j++;
                    }
                }
//                System.out.println("Currently in row : " + j + ". And at column : " + k + ".\n I have found a number : " + isNumber(charArray[j][k]) + ".\n I have found a schematic marker : " + isSchematicMarker(charArray[j][k]) + ".\n The current foundNumber is : " + foundNumber);
                k++;
            }
            j++;
        }
        System.out.println(engineSum);
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

}