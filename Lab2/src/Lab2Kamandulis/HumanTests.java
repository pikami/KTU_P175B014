/* @author Pijus Kamandulis */
package Lab2Kamandulis;

public class HumanTests {
    public static String COLOR_GREEN = "\033[32;1m";
    public static String COLOR_RED = "\u001B[31m";
    public static String COLOR_DEFAULT = "\033[0m";
    
    public static boolean TestCreateMethod(boolean printInfo) {
        boolean success = true;
        String[] humans = {
            "Tomas Tomaitis 1949-10-19 34910198577",
            "Petras Petraitis 1948-07-28 34807288996"
        };
        
        for(String humanStr : humans){
            Human generatedHuman = new Human();
            generatedHuman.parse(humanStr);
            
            String validationErrors = generatedHuman.validate();
            String generatedHumanString = generatedHuman.toString();
            if(!validationErrors.isEmpty() || generatedHumanString.compareTo(humanStr) != 0){
                success = false;
            }
            
            if(printInfo) {
                System.out.println("\n-- Input: " + humanStr);
                System.out.println("Generated human: " + generatedHumanString);
                System.out.println(validationErrors.isEmpty() ? "This human's data is valid" : validationErrors);
            }
        }
        return success;
    }
    
    public static boolean TestValidation(boolean printInfo) {
        boolean success = true;
        String validHuman = "Tomas Tomaitis 1949-10-19 34910198577";
        String[] invalidHumans = {
            "Petras Petraitis 1998-20-20 30000000000",
            "Petras Petraitis 1998-20-20 30000000000"
        };
        
        // Tests for invalid human strings
        for(String humanStr : invalidHumans){
            Human generatedHuman = new Human();
            generatedHuman.parse(humanStr);
            
            String validationErrors = generatedHuman.validate();
            String generatedHumanString = generatedHuman.toString();
            if(validationErrors.isEmpty()){
                success = false;
            }
            
            if(printInfo) {
                System.out.println("\n-- Input: " + humanStr);
                System.out.println("Generated human: " + generatedHumanString);
                System.out.println(validationErrors.isEmpty() ? "This human's data is valid" : validationErrors);
            }
        }
        return success;
    }
    
    public static void main(String[] args) {
        // Entry point
        if(TestCreateMethod(true))
            System.out.println(COLOR_GREEN + "TestCreateMethod() -> TestPassed" + COLOR_DEFAULT);
        else  System.out.println(COLOR_RED + "TestCreateMethod() -> TestFailed" + COLOR_DEFAULT);
        
        if(TestValidation(true))
            System.out.println(COLOR_GREEN + "TestValidation() -> TestPassed" + COLOR_DEFAULT);
        else  System.out.println(COLOR_RED + "TestValidation() -> TestFailed" + COLOR_DEFAULT); 
    }
}
