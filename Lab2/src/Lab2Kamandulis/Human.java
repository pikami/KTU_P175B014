/* @author Pijus Kamandulis */
package Lab2Kamandulis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import laborai.studijosktu.KTUable;
import laborai.studijosktu.Ks;

public class Human implements KTUable<Human> {
    public Date   DateOfBirth;
    public String FirstName;
    public String LastName;
    public long   PersonalCode;
    
    SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Human(Date DateOfBirth, String FirstName, String LastName, long PersonalCode) {
        if(!ValidatePersonalCode(PersonalCode))
            System.err.println("PersonalCode invalid!");
        this.DateOfBirth = DateOfBirth;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PersonalCode = PersonalCode;
    }
    
    public Human() { }
    
    private boolean ValidatePersonalCode(long PersonalCode) {
        String str = String.valueOf(PersonalCode);
        int[] arrayOfDigits = longToIntArray(PersonalCode);
        
        if(arrayOfDigits.length != 11 ||
           arrayOfDigits[0] < 1 || arrayOfDigits[0] > 6 ||
           generateControlNumberForPersonalCode(arrayOfDigits) != arrayOfDigits[10])
            return false;
        return true;
    }
    
    public static int[] longToIntArray(long number) {
        String temp = Long.toString(number);
        int[] resultArray = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            resultArray[i] = temp.charAt(i) - '0';
        }
        return resultArray;
    }
    
    public static int generateControlNumberForPersonalCode(long personalCode) {
        int[] arrayOfDigits = longToIntArray(personalCode);
        return generateControlNumberForPersonalCode(arrayOfDigits);
    }
    
    public static int generateControlNumberForPersonalCode(int[] arrayOfDigits) {
        int[] koef1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
        int[] koef2 = { 3, 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int result = 0;
        
        if(arrayOfDigits.length < 10) return 0;
        
        for(int i = 0; i < 10; i++) {
            result += arrayOfDigits[i] * koef1[i];
        }
        
        if(result % 11 != 10) {
            return result % 11;
        }
        
        result = 0;
        
        for(int i = 0; i < 10; i++) {
            result += arrayOfDigits[i] * koef2[i];
        }
        
        if(result % 11 != 10) {
            return result % 11;
        }
        return 0;
    }
   
    @Override
    public KTUable create(String dataString) {
        Human a = new Human();
        a.parse(dataString);
        return a;
    }

    @Override
    public String validate() {
        String klaidosTipas = "";
        if (!ValidatePersonalCode(PersonalCode)) {
            klaidosTipas = "Netinkamas asmens kodas";
        }
        return klaidosTipas;
    }

    @Override
    public void parse(String dataString) {
        try {   // ed - tai elementarūs duomenys, atskirti tarpais
            Scanner ed = new Scanner(dataString);
            FirstName    = ed.next();
            LastName     = ed.next();
            DateOfBirth  = DateFormat.parse(ed.next());
            PersonalCode = ed.nextLong();
        } catch (ParseException e) {
            Ks.ern("Neteisingas gimimo datos formatas -> " + dataString);
        } catch (InputMismatchException  e) {
            Ks.ern("Blogas duomenų formatas apie auto -> " + dataString);
        } catch (NoSuchElementException e) {
            Ks.ern("Trūksta duomenų apie auto -> " + dataString);
        }
    }

    @Override
    public int compareTo(Human e) {
        // Palyginti pagal gimimo metus
        return e.DateOfBirth.compareTo(DateOfBirth);
    }
    
    @Override
    public String toString() {
        String dateOfBirthString = DateFormat.format(DateOfBirth);
        return String.format("%s %s %s %d", FirstName, LastName, dateOfBirthString, PersonalCode);
    }
    
    public final static Comparator byDate = new Comparator() {
       // sarankiškai priderinkite prie generic interfeiso ir Lambda funkcijų
       @Override
       public int compare(Object o1, Object o2) {
          Date dob1 = ((Human) o1).DateOfBirth;
          Date dob2 = ((Human) o2).DateOfBirth;
          // didėjanti tvarka, pradedant nuo mažiausios
          return dob1.compareTo(dob2);
       }
    };
}
