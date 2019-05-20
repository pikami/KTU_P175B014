package Project.Demo;

import Project.DataStructures.pkHashTable;
import Project.Interfaces.IpkHashTable;
import java.util.Hashtable;

/**
 *
 * @author pk
 */
public class PerformanceTests {
    private static int[] quantityArrayForTests = {2_000, 4_000, 8_000, 16_000};
    
    public static void main(String[] args) {
        long memTotal = Runtime.getRuntime().totalMemory();
        System.out.println("memTotal= "+memTotal+"\r\n");
        System.out.println(String.format("%7s %7s %7s %7s %7s %7s %7s", "Qty.",
                "pCreate", "jCreate",
                "pAdd", "jAdd",
                "pGet", "jGet"));
        for(int n: quantityArrayForTests) 
            simpleTest(n);
    }
    
    public static void simpleTest(int quantity) {
        // Create tables
        long[] t = new long[7];
        t[0]=System.nanoTime();
        IpkHashTable<String, Integer> pkHashTable = new pkHashTable<String, Integer>(100);
        t[1]=System.nanoTime();
        Hashtable<String, Integer> javaHashTable = new Hashtable<String, Integer>();
        t[2]=System.nanoTime();
        // Add data
        for(int i = 0; i < quantity; i++) {
            pkHashTable.add(Integer.toString(i), i);
        }
        t[3]=System.nanoTime();
        for(int i = 0; i < quantity; i++) {
            pkHashTable.add(Integer.toString(i), i);
        }
        t[4]=System.nanoTime();
        // Get data
        for(int i = 0; i < quantity; i++) {
            pkHashTable.get(Integer.toString(i));
        }
        t[5]=System.nanoTime();
        for(int i = 0; i < quantity; i++) {
            pkHashTable.get(Integer.toString(i));
        }
        t[6]=System.nanoTime();
        // Output
        System.out.println(String.format("%7d %7.4f %7.4f %7.4f %7.4f %7.4f %7.4f", quantity,
                (t[1]-t[0])/1e9, (t[2]-t[1])/1e9, (t[3]-t[2])/1e9,
                (t[4]-t[3])/1e9, (t[5]-t[4])/1e9, (t[6]-t[5])/1e9 ));
    }
}
