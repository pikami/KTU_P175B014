/* @author Pijus Kamandulis */
package Lab2Kamandulis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanList {
    List<Human> Humans = new ArrayList<Human>();
    
    public void add(int k, Human human) {
        Humans.add(k, human);
    }
    
    public void set(int k, Human human) {
        Humans.set(k, human);
    }
    
    public Human remove(int k) {
        return Humans.remove(k);
    }
    
    public static void print(List<Human> humans) {
        humans.forEach((human) -> System.out.println(human.toString()));
    }
    
    public void print() {
        print(Humans);
    }
    
    public List<Human> getByName(String name) {
        return Humans.stream().filter((human) -> human.FirstName.compareTo(name) == 0).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Form the human list
        String[] humans = {
            "Tomas Tomaitis 1949-10-19 34910198577",
            "Jonas Jonaitis 1991-01-08 39101089287",
            "Petras Petraitis 1948-07-28 34807288996",
            "Jonas Antanaitis 2045-01-01 44501018081",
            "Jonas Kazlauskas 1939-07-27 33907278587" };
        HumanList humanList = new HumanList();
        for(String humanStr : humans) {
            Human newHuman = new Human();
            newHuman.parse(humanStr);
            humanList.add(0, newHuman);
        }
        // Print the whole list
        System.out.println("Pradiniai duomenys:");
        humanList.print();
        // Get humans with name Jonas
        System.out.println("Jonai:");
        List<Human> allJonas = humanList.getByName("Jonas");
        humanList.print(allJonas);
    }
}
