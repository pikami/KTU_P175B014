/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3Kamandulis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import laborai.studijosktu.MapADT;

/**
 *
 * @author pk
 */
public class PerformanceTests {
    private static int[] quantityArrayForTests = {2_000, 4_000, 8_000, 16_000};
    private static List<String> words;
    private static Random rng = new Random();
    
    public static void main(String[] args) {
        words = readWords();
        long memTotal = Runtime.getRuntime().totalMemory();
        System.out.println("memTotal= "+memTotal+"\r\n");
        System.out.println(String.format("%7s %11s %11s %9s %9s", "Qty.",
                "myContains", "ktuContains",
                "myRemove", "ktuRemove"));
        for(int n: quantityArrayForTests) 
            simpleTest(n);
    }
    
    public static void simpleTest(int quantity){
        // setup
        long[] t = new long[5];
        MapADT<String, String> myMap = new MapKTUOA<>(quantity);
        MapADT<String, String> ktuMap = new MapKTUOA<>(quantity);
        // add rows
        for(int i = 0; i < quantity; i++) {
            String word = words.get(rng.nextInt(words.size()));
            myMap.put(word, word);
            ktuMap.put(word, word);
        }
        // contains
        t[0]=System.nanoTime();
        for(int i = 0; i < quantity / 2; i++) {
            String word = words.get(rng.nextInt(words.size()));
            myMap.contains(word);
        }
        t[1]=System.nanoTime();
        for(int i = 0; i < quantity / 2; i++) {
            String word = words.get(rng.nextInt(words.size()));
            ktuMap.contains(word);
        }
        // remove
        t[2]=System.nanoTime();
        for(int i = 0; i < quantity / 2; i++) {
            String word = words.get(rng.nextInt(words.size()));
            myMap.remove(word);
        }
        t[3]=System.nanoTime();
        for(int i = 0; i < quantity / 2; i++) {
            String word = words.get(rng.nextInt(words.size()));
            ktuMap.remove(word);
        }
        t[4]=System.nanoTime();
        // output
        System.out.println(String.format("%7d %11.4f %11.4f %9.4f %9.4f", quantity,
                (t[1]-t[0])/1e9, (t[2]-t[1])/1e9, (t[3]-t[2])/1e9, (t[4]-t[3])/1e9));
    }

    private static List<String> readWords() {
        BufferedReader abc = null;
        try {
            abc = new BufferedReader(new FileReader("zodynas.txt"));
            List<String> lines = new ArrayList<String>();
            try {
                String line;
                while((line = abc.readLine()) != null) {
                    lines.add(line);
                }
                abc.close();
            } catch (IOException ex) {}
            return lines;
        } catch (FileNotFoundException ex) {} finally {
            try {
                abc.close();
            } catch (IOException ex) {}
        }
        return new ArrayList<String>();
    }
}
