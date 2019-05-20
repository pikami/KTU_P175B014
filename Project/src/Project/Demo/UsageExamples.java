package Project.Demo;


import Project.DataStructures.pkHashTable;
import Project.Interfaces.IpkHashTable;
import java.util.Random;

/**
 *
 * @author pk
 */
public class UsageExamples {
    private static Random rng = new Random();
    
    public static void main(String[] args) {
        IpkHashTable<String, Integer> ht = new pkHashTable<String, Integer>(5);
        System.err.println(ht.toString());
        AddData(ht, 10);
        System.err.println(ht.toString());
    }
    
    public static void AddData(IpkHashTable<String, Integer> ht, int quantity) {
        String prefix = String.format("%s%s_", (char) (rng.nextInt(25)+97), (char) (rng.nextInt(25)+97));
        
        for(int i = 0; i<quantity; i++) {
            String key = String.format("%s%s", prefix, Integer.toString(i));
            ht.add(key, i);
        }
    }
}
