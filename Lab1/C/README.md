# C. Bendriniai sarašai
## Užduotis
1.	Pagal duotą Automobilio klasės pavyzdį sukurti individualiai pasirinktas elemento klases (4-5 komponentai), tenkinančias KTUable interfeisą; programinį kodą rašyti į individualų paketą Lab2Pavarde.
2.	Patikrinti individualios klasės veikimą testo klasės pagalba;
3.	Sudaryti individualių elementų apskaitos klasę, kurioje būtų elementų peržiūra ir jų atranka pagal įvairius kriterijus;
4.	Sudaryti elementų apskaitos klasės demonstracinius metodus;
5.	Realizuoti ListKTU metodus add(int k, Data data), set(int k, Data data), remove(int k); 
6.	Realizuoti individualiai nurodytus metodus;
7.	Atliekamas individualiai nurodytų metodų greitaveikos tyrimas.
8.	Sunaudojamos atminties kiekio įvertinimas.

## Individualiai pasirinkta užduotis
Sukūrti klasę asmens duomenų saugojimui.

Metodai kuriuos reikia realizuoti: 
* add(int index, E element)
* remove(int index)
* set(int index, E element)
* addLast(E e)
* removeLastOccurrence(Object o)
* subList(int fromIndex, int toIndex)
Greitaveikos tyrimas:
* Math.sqrt(x) <-> Math.cbrt(x)
* ArrayList<Integer> <-> LinkedList<Integer> metodas get(i)

## Sprendimas
Pilnas kodas pateiktas kartu su projektu.

Klasės:
* Human – Klasė žmogaus duomenims saugoti
Savybės:

Tipas | Pavadinimas | Komentaras
--- | --- | ---
Date | DateOfBirth | Gimimo data
String | FirstName | Vardas
String | LastName | Pavardė
long | PersonalCode | Asmens kodas

Metodai:
boolean ValidatePersonalCode(long PersonalCode) – Asmens kodo validatorius
int[] longToIntArray(long number) – Long paverčia į int masyvą
int generateControlNumberForPersonalCode(long personalCode) – Sukuria kontrolinį kodą pagal kitus asmens kodo skaičius
int generateControlNumberForPersonalCode(int[] arrayOfDigits) – Sukuria kontrolinį kodą pagal kitus asmens kodo skaičius
KTUable create(String dataString) – Sukuria objektą pagal duotą žodį
String validate() – Patikrina duomenų validumą
void parse(String dataString) – Nustato objekto reikšmes pagal duotą žodį
int compareTo(Human e) – Palyginimo funkcija lyginanti pagal metus
String toString() – Gražina žodį nusakantį žmogaus informaciją

* HumanList – Elementų apskaitos klasė
Savybės:

Tipas | Pavadinimas | Komentaras
--- | --- | ---
List<Human> | Humans | Žmonių sąrašas

Metodai:
void add(int k, Human human) – Prideda žmogų į sąrašą
void set(int k, Human human) – Pakeičia žmogų kitu žmogumi
Human remove(int k) – Pašalina žmogų iš sąrašo
void print(List<Human> humans) – Atspausdina duotąjį žmonių sąrašą
void print() – Atspausdina žmonių sąrašą
List<Human> getByName(String name) – Atrenka žmones pagal vardą

* HumanTests – Testo klasė patikrinti Human klasės veikimą
Savybės:

Tipas | Pavadinimas | Komentaras
--- | --- | ---
String | COLOR_GREEN | Žalia spalva
String | COLOR_RED | Raudona spalva
String | COLOR_DEFAULT | Numatyta spalva

Metodai:
boolean TestCreateMethod(boolean printInfo) – Tikrina žmogaus sukūrimo metodą
boolean TestValidation(boolean printInfo) – Tikrina validaciją

* HumanPerformanceTests – Greitaveikos tyrimo klasė
Savybės:

Tipas | Pavadinimas | Komentaras
--- | --- | ---
Random | rng | Atsitiktinių skaičių generatorius
int[] | quantityArrayForTests | Generuojamų atvėjų kiekis

Metodai:
long generatePersonalCode() – Generuoja asmens kodą
ListKTU<Human> generateHumanList(int quantity) – Generuoja žmonių sąrašą
ListKTU<String> readNames() – Nuskaito žmonių vardus iš failo
void simpleTest(int quantity) – Keli testai naudojantįs žmonių objektus
void startTests() – Pradeda testus: simpleTest ir systemTest
void systemTest() – Kiti testai naudojantys žmonių objektus
void Nr4() - Math.sqrt(x) <-> Math.cbrt(x) testas
void Nr8() - ArrayList<Integer> <-> LinkedList<Integer> metodo get(i) testas

## Rezultatai
### HumanList
Išvestis:

```
Pradiniai duomenys:
Jonas Kazlauskas 1939-07-27 33907278587
Jonas Antanaitis 2045-01-01 44501018081
Petras Petraitis 1948-07-28 34807288996
Jonas Jonaitis 1991-01-08 39101089287
Tomas Tomaitis 1949-10-19 34910198577
Jonai:
Jonas Kazlauskas 1939-07-27 33907278587
Jonas Antanaitis 2045-01-01 44501018081
Jonas Jonaitis 1991-01-08 39101089287
```

### HumanTests
Išvestis:

```
-- Input: Tomas Tomaitis 1949-10-19 34910198577
Generated human: Tomas Tomaitis 1949-10-19 34910198577
This human's data is valid

-- Input: Petras Petraitis 1948-07-28 34807288996
Generated human: Petras Petraitis 1948-07-28 34807288996
This human's data is valid
TestCreateMethod() -> TestPassed

-- Input: Petras Petraitis 1998-20-20 30000000000
Generated human: Petras Petraitis 1999-08-20 30000000000
Netinkamas asmens kodas

-- Input: Petras Petraitis 1998-20-20 30000000000
Generated human: Petras Petraitis 1999-08-20 30000000000
Netinkamas asmens kodas
TestValidation() -> TestPassed
```

### HumanPerformanceTests
Išvestis:

```
Math.sqrt(x) <-> Math.cbrt(x)
quantity    sqrt    cbrt
    2000  0.0001  0.0029
    4000  0.0001  0.0004
    8000  0.0001  0.0007
   16000  0.0003  0.0016
ArrayList<Integer> <-> LinkedList<Integer> metodas get(i)
  Test ArrayList LinkedList
  2000    0.0002    0.0062
  4000    0.0001    0.0175
  8000    0.0002    0.0674
 16000    0.0005    0.1465
memTotal= 257425408
1 - Pasiruošimas tyrimui - duomenų generavimas
2 - Pasiruošimas tyrimui - šiukšlių surinkimas
3 - Rūšiavimas sisteminiu greitu būdu be Comparator
4 - Rūšiavimas sisteminiu greitu būdu su Comparator
5 - Rūšiavimas List burbuliuku be Comparator
6 - Rūšiavimas List burbuliuku su Comparator
     0       1       2       3       4       5       6 
   2000  0.0476  0.0294  0.0030  0.0028  0.0414  0.0476 
   4000  0.0282  0.0537  0.0053  0.0030  0.1673  0.1604 
   8000  0.0452  0.0658  0.0088  0.0065  0.7491  0.7622 
  16000  0.0364  0.0933  0.0100  0.0131  4.9059  5.3105 
 1|   kiekis(*k)SysNoCom SysWithCom BurNoCom BurWithCom 
 2|     2000( 1)   0.0017   0.0013   0.0421   0.0357 
 3|     4000( 2)   0.0026   0.0016   0.1649   0.1506 
 4|     8000( 4)   0.0034   0.0026   0.8158   0.7848 
 5|    16000( 8)   0.0065   0.0060   5.5645   6.3417 
       Bendras tyrimo laikas   14.822 sekundžių 
    Išmatuotas tyrimo laikas   13.926 sekundžių 
    t.y.   6.0% sudaro pagalbiniai darbai 
 6| 
 7| Normalizuota (santykinė) laikų lentelė
 8|   kiekis(*k)SysNoCom SysWithCom BurNoCom BurWithCom 
 9|     2000( 1)     1.00     0.78    24.57    20.86 
10|     4000( 2)     1.50     0.93    96.27    87.91 
11|     8000( 4)     1.98     1.53   476.30   458.20 
12|    16000( 8)     3.77     3.52  3248.62  3702.39
```
