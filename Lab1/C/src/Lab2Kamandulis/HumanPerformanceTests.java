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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import studijosKTU.ListKTU;
import studijosKTU.Timekeeper;

public class HumanPerformanceTests {
    private static Random rng = new Random();
    private static int[]  quantityArrayForTests = {2_000, 4_000, 8_000, 16_000};
    
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
    
    private static ListKTU<Human> generateHumanList(int quantity) throws FileNotFoundException {
        ListKTU<String> names = readNames();
        ListKTU<Human> humans = new ListKTU<>();
        for(int i = 0; i < quantity; i++) {
            String firstName    = names.get(rng.nextInt(names.size()));
            String lastName     = names.get(rng.nextInt(names.size()));
            long   ms = -946771200000L + (Math.abs(rng.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
            Date   dateOfBirth  = new Date(ms);
            long   personalCode = generatePersonalCode();
            humans.add(new Human(dateOfBirth, firstName, lastName, personalCode));
        }
        return humans;
    }
    
    private static ListKTU<String> readNames() throws FileNotFoundException {
        BufferedReader abc = new BufferedReader(new FileReader("data/names.txt"));
        ListKTU<String> lines = new ListKTU<String>();
        try {
            String line;
            while((line = abc.readLine()) != null) {
                lines.add(line);
            }
            abc.close();
        } catch (IOException ex) {
            Logger.getLogger(HumanPerformanceTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }
    
    private static void simpleTest(int quantity) throws FileNotFoundException{
        long t0=System.nanoTime();
        ListKTU<Human> humans = generateHumanList(quantity);
        ListKTU<Human> humansClone1 = humans.clone();
        ListKTU<Human> humansClone2 = humans.clone();
        ListKTU<Human> humansClone3 = humans.clone();
        ListKTU<Human> humansClone4 = humans.clone();
        long t1=System.nanoTime();
        System.gc(); System.gc(); System.gc();
        long t2=System.nanoTime();
        humansClone1.sortSystem();
        long t3=System.nanoTime();
        humansClone2.sortSystem(Human.byDate);
        long t4=System.nanoTime();
        humansClone3.sortBuble();
        long t5=System.nanoTime();
        humansClone4.sortBuble(Human.byDate);
        long t6=System.nanoTime();
        System.out.println(String.format("%7d %7.4f %7.4f %7.4f %7.4f %7.4f %7.4f \n", quantity,
                (t1-t0)/1e9, (t2-t1)/1e9, (t3-t2)/1e9,
                (t4-t3)/1e9, (t5-t4)/1e9, (t6-t5)/1e9 ));
    }
    
    private static void startTests() throws FileNotFoundException{
        long memTotal = Runtime.getRuntime().totalMemory();
        System.out.println("memTotal= "+memTotal);
        ListKTU<Human> humans = generateHumanList(20);
        for(Human human: humans) System.out.println(human.toString());
        System.out.println("1 - Pasiruošimas tyrimui - duomenų generavimas");
        System.out.println("2 - Pasiruošimas tyrimui - šiukšlių surinkimas");
        System.out.println("3 - Rūšiavimas sisteminiu greitu būdu be Comparator");
        System.out.println("4 - Rūšiavimas sisteminiu greitu būdu su Comparator");
        System.out.println("5 - Rūšiavimas List burbuliuku be Comparator");
        System.out.println("6 - Rūšiavimas List burbuliuku su Comparator");
        System.out.println(String.format("%6d %7d %7d %7d %7d %7d %7d \n", 0,1,2,3,4,5,6));
        for(int n: quantityArrayForTests) 
            simpleTest(n);
        systemTest();
    }
    
    private static void systemTest() throws FileNotFoundException {
        Timekeeper tk = new Timekeeper(quantityArrayForTests);
        for (int n : quantityArrayForTests) {
            ListKTU<Human> humans = generateHumanList(n);
            ListKTU<Human> humansClone1 = humans.clone();
            ListKTU<Human> humansClone2 = humans.clone();
            ListKTU<Human> humansClone3 = humans.clone();

            tk.start();
            humans.sortSystem();
            tk.finish("SysNoCom");
            humansClone1.sortSystem(Human.byDate);
            tk.finish("SysWithCom");
            humansClone2.sortBuble();
            tk.finish("BurNoCom");
            humansClone3.sortBuble(Human.byDate);
            tk.finish("BurWithCom");
            tk.seriesFinish();
        }
    }
    
    // ====== From excel ====== //
    public static void Nr4() { // Math.sqrt(x) <-> Math.cbrt(x)
        System.out.println(String.format("\nMath.sqrt(x) <-> Math.cbrt(x)\n%8s %7s %7s", "quantity", "sqrt", "cbrt"));
        for(int n : quantityArrayForTests){
            // Setup
            double[] numbers = new double[n];
            for(int i = 0; i < n; i++) {
                numbers[i] = rng.nextDouble();
            }
            // Generate results
            long t1=System.nanoTime();
            for(int i = 0; i < n; i++) {
                Math.sqrt(numbers[i]);
            }
            long t2=System.nanoTime();
            for(int i = 0; i < n; i++) {
                Math.cbrt(numbers[i]);
            }
            long t3=System.nanoTime();
            // Output results
            System.out.println(String.format("%8d %7.4f %7.4f", n, (t2-t1)/1e9, (t3-t2)/1e9));
        }
    }
    
    public static void Nr8() { // ArrayList<Integer> <-> LinkedList<Integer> metodas get(i)
        System.out.println(String.format("\nArrayList<Integer> <-> LinkedList<Integer> metodas get(i)\n%6s %9s %9s", "Test", "ArrayList", "LinkedList"));
        // Setup
        ArrayList<Integer> al = new ArrayList<Integer>();
        LinkedList<Integer> ll = new LinkedList<Integer>();
        int arrayLen = Arrays.stream(quantityArrayForTests).max().getAsInt();
        
        for(int i = 0; i < arrayLen; i++) {
            int number = rng.nextInt();
            al.add(number);
            ll.add(number);
        }
        
        for(int n : quantityArrayForTests){
            // Generate results
            long t1=System.nanoTime();
            for(int i = 0; i < n; i++) {
                al.get(i);
            }
            long t2=System.nanoTime();
            for(int i = 0; i < n; i++) {
                ll.get(i);
            }
            long t3=System.nanoTime();
            // Output results
            System.out.println(String.format("%6d %9.4f %9.4f", n, (t2-t1)/1e9, (t3-t2)/1e9));
        }
        
    }
    
    public static void startExcelTests() {
        Nr4();
        Nr8();
    }

    public static void main(String[] args) throws FileNotFoundException {
        startExcelTests();
        startTests();
    }
}
