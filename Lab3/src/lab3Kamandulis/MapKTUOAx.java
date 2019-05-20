/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3Kamandulis;

import static com.sun.javafx.util.Utils.split;
import java.util.ArrayList;
import java.util.List;
import laborai.studijosktu.MapADTx;
import laborai.studijosktu.MapKTU;

/**
 *
 * @author pk
 */
public class MapKTUOAx<K, V> extends MapKTUOA<K, V> implements MapADTx<K, V> {

    public MapKTUOAx(int capacity) {
        super(capacity);
    }

    @Override
    public V put(String dataString) {
        return put((K) dataString, (V) dataString);
    }
    
    @Override
    public void load(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[][] getModelList(String delimiter) {
        String[][] array = toArray();
        
        String[][] result = new String[this.getTableCapacity()][];
        int count = 0;
        for (String[] n : array) {
            List<String> list = new ArrayList();
            list.add( "[ " + count + " ]");
            if (n != null && !n[0].equals("")) {
                list.add("-->");
                list.add(n[0]);
            }
            result[count] = list.toArray(new String[0]);
            count++;
        }
        return result;
    }

    @Override
    public int getMaxChainSize() {
        return 1;
    }

    @Override
    public int getRehashesCounter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLastUpdatedChain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChainsCounter() {
        return size();
    }
    
}
