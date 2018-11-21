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
        SubSet2_Test();
        //HeadSet_Test();
        //TailSet_Test();
        //TailSet2_Test();
        //IteratorRemove_Test();
        //RetainAll_Test();
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
    
    public static void SubSet2_Test() {
        BstSetKTU<Human> humanSet = treeGeneration(10);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
        // 2 array
        Object[] humanArray = humanSet.toArray();
        // try
        BstSetKTU<Human> humanSetModified =(BstSetKTU<Human>)  humanSet.subSet((Human)humanArray[2], false, (Human)humanArray[5], true);
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
    
    public static void TailSet2_Test() {
        BstSetKTU<Human> humanSet = treeGeneration(10);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
        // 2 array
        Object[] humanArray = humanSet.toArray();
        // try
        BstSetKTU<Human> humanSetModified =(BstSetKTU<Human>) humanSet.tailSet((Human)humanArray[2], false);
        // out
        System.out.println(humanSetModified.toVisualizedString("\n"));
    }
    
    public static void RetainAll_Test() {
        BstSetKTU<Human> humanSet = treeGeneration(10);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
        // subset
        Object[] humanArray = humanSet.toArray();
        BstSetKTU<Human> humanSubSet = (BstSetKTU<Human>)  humanSet.subSet((Human)humanArray[0], (Human)humanArray[2]);
        humanSubSet.add(HumanGenerator.generateHuman());
        //out
        System.out.println("retain:\r\n" + humanSubSet.toVisualizedString("\n"));
        // try
        humanSet.retainAll(humanSubSet);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
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
