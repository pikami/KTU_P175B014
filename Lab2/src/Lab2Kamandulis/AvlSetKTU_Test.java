/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2Kamandulis;

import laborai.studijosktu.AvlSetKTU;

/**
 *
 * @author pk
 */
public class AvlSetKTU_Test {
    public static void main(String[] args) {
        Remove_Test();
    }
    
    public static void Remove_Test() {
        AvlSetKTU<Human> humanSet = treeGeneration(10);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
        // 2 array
        Object[] humanArray = humanSet.toArray();
        // try
        humanSet.remove((Human)humanArray[1]);
        // out
        System.out.println(humanSet.toVisualizedString("\n"));
    }
    
    public static AvlSetKTU<Human> treeGeneration(int sizeOfGenSet) { // button1
        AvlSetKTU<Human> humanSet = new AvlSetKTU();

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
