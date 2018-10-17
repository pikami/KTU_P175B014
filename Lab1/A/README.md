# A. Bazinės duomenų struktūros
## Užduotis
Sudaryti vieno iš pirmo kurso laboratorinių darbų programą Java kalba naujame NetBeans projekte. 
Duomenų įvedimas nėra būtinas – galima reikšmes priskirti arba generuoti atsitiktines. 
Projekte būtina: ne mažiau kaip du javos failai, masyvai, vienas paleidimo main metodas programos testavimui.
## Individualiai pasirinkta užduotis
LD_3. Domino. 
Imami 7 vieno domino rinkinio kauliukai. Vieną domino kauliuką sudaro dvi dalys, kurių kiekvienoje arba nieko nėra (baltas), arba juodi taškai, kurių yra nuo 1 iki 6. Kauliuką galima nusakyti kaip dviženklį skaičių, kurio pirmas skaitmuo nurodo pirmos dalies taškų skaičių, o antrasis – antros. Jeigu dalis tuščia, tai rašomas skaitmuo 0 (nulis). Parašykite programą, kuri sudarytų iš šių 7 kauliukų visas galimas randines, kai jungiami kauliukai galais su vienodu taškų skaičiumi. Gali būti, kad tokios grandinės visai nėra. Sudarant grandines, kauliukas gali būti apsukamas, t.y. kauliukas 35 gali būti padėtas, kaip 53.
Kauliukų duomenys įvedami iš tekstinio failo‘Kur3.txt’. Čia vienoje eilutėje yra parašyti 7 (septyni) dviženkliai skaičiai. Rezultatus surašyti į tekstinį failą eilutėmis po vieną grandinę. Grandinę sudaro 7 kauliukai, tarp kiekvieno kauliuko (dviženklio skaičiaus) paliekamas vieno tarpo ženklas.
## Sprendimas
L1 – Pagrindinė klasė su užduoties sprendimu
* Savybės

Tipas | Pavadinimas | Komentaras
--- | --- | ---
int | PIECE_COUNT | Nusako domino dalelių kiekį
String | INPUT_FILE | Nusako duomenų failo lokaciją
boolean | FOUND_CHAIN | Reikšmė nusakanti ar grandinė buvo rasta
* Metodai
void PrintDataset(Piece[] Pieces) – Išveda duotajį dalelių masyvą
void StartSearch(Piece[] Pieces) – Pradeda rekursinę grandinių paiešką
void MakeChain(Piece[] Pieces, int[] Used, int[] Chain, int place) – Rekursinė funkcija ieškanti galimų grandinių
void PrintChain(int[] Chain) – Išveda duotajį dalelių masyvą ir nustato FOUND_CHAIN

Piece – Domino dalelės klasė
* Savybės

Tipas | Pavadinimas | Komentaras
--- | --- | ---
int[] | parts | Dalelės reikšmės
* Metodai
Piece(int num) – Konstruktorius
int HasPart(int part) – Gražina reikšmės indeksą dalelėje, -1 jei šios reikšmės dalelė neturi
int GetPiece(boolean rotate) – Gražina dalęlę
Piece[] StringToPieces(String input, int count) – String reikšmę paverčia į domino dalis

## Pradiniai duomenys ir rezultatai
### Pirmas duomenų variantas
* Pradiniai duomenys: 
```
13 01 02 24 14 12 25
```
* Rezultatai:
```
Dataset: 13 01 02 24 14 12 25 
Found chains: 
31 10 02 24 41 12 25 
31 10 02 21 14 42 25 
31 14 42 20 01 12 25 
31 14 42 21 10 02 25 
31 12 20 01 14 42 25 
31 12 24 41 10 02 25 
52 20 01 14 42 21 13 
52 20 01 12 24 41 13 
52 24 41 10 02 21 13 
52 24 41 12 20 01 13 
52 21 10 02 24 41 13 
52 21 14 42 20 01 13
```
### Antrasis duomenų variantas
* Pradiniai duomenys: 
```
00 11 22 33 44 55 66
```
* Rezultatai:
```
Dataset: 00 11 22 33 44 55 66 
No chains were found!
```