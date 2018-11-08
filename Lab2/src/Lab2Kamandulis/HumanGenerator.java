/* @author Pijus Kamandulis */
package Lab2Kamandulis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HumanGenerator {
    private static Random rng = new Random();
    
    private static long generatePersonalCode() {
        long theCode = rng.nextInt(6) + 1;
        for(int i = 0; i < 9; i++) {
            theCode*=10;
            theCode+=rng.nextInt(10);
        }
        theCode*=10;
        theCode+=Human.generateControlNumberForPersonalCode(theCode);
        return theCode;
    }
    
    public static Human[] generateHumanArray(int quantity) {
        List<String> names = readNames();
        Human[] humans = new Human[quantity];
        for(int i = 0; i < quantity; i++) {
            String firstName    = names.get(rng.nextInt(names.size()));
            String lastName     = names.get(rng.nextInt(names.size()));
            long   ms = -946771200000L + (Math.abs(rng.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
            Date   dateOfBirth  = new Date(ms);
            long   personalCode = generatePersonalCode();
            humans[i] = new Human(dateOfBirth, firstName, lastName, personalCode);
        }
        return humans;
    }
    
    public static Human generateHuman() {
        List<String> names = readNames();
        String firstName    = names.get(rng.nextInt(names.size()));
        String lastName     = names.get(rng.nextInt(names.size()));
        long   ms = -946771200000L + (Math.abs(rng.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        Date   dateOfBirth  = new Date(ms);
        long   personalCode = generatePersonalCode();
        return new Human(dateOfBirth, firstName, lastName, personalCode);
    }
    
    private static List<String> readNames() {
        BufferedReader abc = null;
        try {
            abc = new BufferedReader(new FileReader("data/names.txt"));
            List<String> lines = new ArrayList<String>();
            try {
                String line;
                while((line = abc.readLine()) != null) {
                    lines.add(line);
                }
                abc.close();
            } catch (IOException ex) {
                Logger.getLogger(HumanGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lines;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HumanGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                abc.close();
            } catch (IOException ex) {
                Logger.getLogger(HumanGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new ArrayList<String>();
    }
}
