import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        File theOutputFile = new File("output.txt");
        Scanner theReader = new Scanner(theOutputFile);

        ArrayList<String> theGames = new ArrayList<String>();
        int sumOfAll = 0;

        while (theReader.hasNextLine()) {
            theGames.add(theReader.nextLine());
        }
        theReader.close();

        for (int i = 0; i < theGames.size(); i++) {
            String theGameLine = theGames.get(i);
            if (hasReds(theGameLine)) {
                theGames.remove(i);
                i--;
            } else if (hasGreens(theGameLine)) {
                theGames.remove(i);
                i--;
            } else if (hasBlues(theGameLine)) {
                theGames.remove(i);
                i--;
            }
        }
        for (int o = 0; o < theGames.size(); o++) {
            String newGameLine = theGames.get(o);
            newGameLine = new String(newGameLine.substring(0,8));
            int x = Integer.parseInt(newGameLine.replaceAll("\\D+",""));
            sumOfAll += x;
            System.out.println(x);
        }
        System.out.println(sumOfAll);
    }

    static Boolean hasReds(String checkMe) {
        Boolean hasNoReds = false;
        int num = 13;
        for (int i = 0; i < checkMe.length(); i++) {
            if (checkMe.contains(num + " red")) {
                return hasNoReds = true;
            } else {
                num++;
            }
        }
        return hasNoReds;
    }

    static Boolean hasGreens(String checkMe) {
        Boolean hasNoGreen = false;
        int num = 14;
        for (int i = 0; i < checkMe.length(); i++) {
            if (checkMe.contains(num + " green")) {
                return hasNoGreen = true;
            } else {
                num++;
            }
        }
        return hasNoGreen;
    }

    static Boolean hasBlues(String checkme) {
        Boolean hasNoBlue = false;
        int num = 15;
        for (int i = 0; i < checkme.length(); i++) {
            if (checkme.contains(num + " blue")) {
                return hasNoBlue = true;
            } else {
                num++;
            }
        }
        return hasNoBlue;
    }
}