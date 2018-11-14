/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2Kamandulis;

import java.util.Iterator;
import laborai.studijosktu.BstSetKTU;

/**
 *
 * @author pk
 */
public class BstSetKTU_Test {
    public static void main(String[] args) {
        //SubSet_Test();
        //HeadSet_Test();
        //TailSet_Test();
        IteratorRemove_Test();
    }
    
    public static void HeadSet_Test() {
        BstSetKTU<Human> humanSet = treeGeneration(10);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
        // 2 array
        Object[] humanArray = humanSet.toArray();
        // try
        BstSetKTU<Human> humanSetModified = (BstSetKTU<Human>) humanSet.headSet((Human)humanArray[5]);
        // out
        System.out.println(humanSetModified.toVisualizedString("\n"));
    }
    
    public static void SubSet_Test() {
        BstSetKTU<Human> humanSet = treeGeneration(10);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
        // 2 array
        Object[] humanArray = humanSet.toArray();
        // try
        BstSetKTU<Human> humanSetModified =(BstSetKTU<Human>)  humanSet.subSet((Human)humanArray[2], (Human)humanArray[5]);
        // out
        System.out.println(humanSetModified.toVisualizedString("\n"));
    }
    
    public static void TailSet_Test() {
        BstSetKTU<Human> humanSet = treeGeneration(10);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
        // 2 array
        Object[] humanArray = humanSet.toArray();
        // try
        BstSetKTU<Human> humanSetModified =(BstSetKTU<Human>) humanSet.tailSet((Human)humanArray[2]);
        // out
        System.out.println(humanSetModified.toVisualizedString("\n"));
    }
    
    public static void IteratorRemove_Test() {
        BstSetKTU<Human> humanSet = treeGeneration(10);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
        // try
        Iterator<Human> iterator = humanSet.iterator();
        iterator.next();
        iterator.remove();
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
    }
    
    public static BstSetKTU<Human> treeGeneration(int sizeOfGenSet) { // button1
        BstSetKTU<Human> humanSet = new BstSetKTU();

        Human[] humanArray;
        humanArray = HumanGenerator.generateHumanArray(sizeOfGenSet);

        // Išmaišyto masyvo elementai surašomi i aibę
        humanSet.clear();
        for (Human a : humanArray) {
            humanSet.add(a);
        }
        
        return humanSet;
    }
}
