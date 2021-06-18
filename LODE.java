/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LODE {

    public static int sloupec = 8;
    public static int radek = 8;
    public static int lodehrace1;
    public static int lodehrace2;
    public static String[][] pole = new String[sloupec][radek];
    public static String[][] pole1 = new String[sloupec][radek];
    public static String[][] pole2 = new String[sloupec][radek];
    public static String[][] field = new String[sloupec][radek];
    public static String[][] field1 = new String[sloupec][radek];
    public static String[][] field2 = new String[sloupec][radek];
    public static int[] pr = new int[9];

    /**
     * Tato metoda vytváří bitevní oceán pro hráče 1
     */
    public static void battleMap() {

        System.out.println("Toto je bitevní oceán hráče 1");
        System.out.println();
        System.out.println();
        int c = 1;
        //První řádek
        for (int i = 1; i < pr.length; i++) {
            if (i > 0) {
                pr[i] = i;
            }
            System.out.print("       " + pr[i] + " ");
        }
        System.out.println();
        System.out.println();
//Bitevní oceán
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {

                pole[j][i] = "| X |";

                if (j == 0) {
                    System.out.print(c + " |  ");
                    c++;
                }

                System.out.print(pole[j][i] + "    ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Tato metoda vytváří bitevní oceán pro hráče 2
     */
    public static void battleMap2() {
        System.out.println("Toto je bitevní oceán hráče 2");
        System.out.println();
        System.out.println();
        int c = 1;
        //První řádek
        for (int i = 1; i < pr.length; i++) {
            if (i > 0) {
                pr[i] = i;
            }
            System.out.print("       " + pr[i] + " ");
        }
        System.out.println();
        System.out.println();
//Bitevní oceán
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                field[j][i] = "| O |";

                if (j == 0) {
                    System.out.print(c + " |  ");
                    c++;
                }

                System.out.print(field[j][i] + "    ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Slouží k vyplnění bitevního oceánu přímo do bitvy pro hráče 1
     */
    public static void battleMap3() {
        System.out.println("Toto je bitevní oceán hráče 1");
        System.out.println();
        System.out.println();
        int c = 1;
        //První řádek
        for (int i = 1; i < pr.length; i++) {
            if (i > 0) {
                pr[i] = i;
            }
            System.out.print("       " + pr[i] + " ");
        }
        System.out.println();
        System.out.println();
//Bitevní oceán
        for (int i = 0; i < pole1.length; i++) {
            for (int j = 0; j < pole1[i].length; j++) {

                pole1[j][i] = "| X |";

                if (j == 0) {
                    System.out.print(c + " |  ");
                    c++;
                }

                System.out.print(pole1[j][i] + "    ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Metoda pro vyplnění bitevního oceánu přímo do bitvy pro hráče 2
     */
    public static void battleMap4() {
        System.out.println("Toto je bitevní oceán hráče 1");
        System.out.println();
        System.out.println();
        int c = 1;
        //První řádek
        for (int i = 1; i < pr.length; i++) {
            if (i > 0) {
                pr[i] = i;
            }
            System.out.print("       " + pr[i] + " ");
        }
        System.out.println();
        System.out.println();
//Bitevní oceán
        for (int i = 0; i < field1.length; i++) {
            for (int j = 0; j < field1[i].length; j++) {

                field1[j][i] = "| O |";

                if (j == 0) {
                    System.out.print(c + " |  ");
                    c++;
                }

                System.out.print(field1[j][i] + "    ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Tato metoda ukazuje rozmístění lodí hráče 1
     */
    public static void battleShips1() {
        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Rozmístění lodí na moře hráče 1");
        lodehrace1 = 4;
        for (int i = 1; i <= lodehrace1;) {
            System.out.println();
            System.out.print("Zadejte souřadnice X (řádek 1-8) pro vaši " + i + ". loď: ");
            x = sc.nextInt();
            System.out.println();
            System.out.print("Zadejte souřadnice Y (sloupec 1-8) pro vaši " + i + ". loď: ");
            y = sc.nextInt();
            System.out.println();
            x = x - 1;
            y = y - 1;
            //Podmínky k ošetření rozmisťování, abysme nemohli polohovat lodě mimo pole nebo více lodí na jedno místo
            if ((x >= 0 && x < sloupec) && (y >= 0 && y < radek) && (pole[y][x] == "| X |")) {
                pole[y][x] = "  @  ";
                pole1[y][x] = "| X |";
                i++;
            } else if ((x >= 0 && x < sloupec) && (y >= 0 && y < radek) && pole[y][x] == "  @  ") {
                System.out.println("Nemůžete mít více lodí na jedné pozici");

            } else if ((x < 0 || x >= sloupec) || (y < 0 || y >= radek)) {
                System.out.println("Nemůžete umisťovat lodě mimo bitevní pole");
            }
            System.out.println();
            System.out.println();
            System.out.println("Toto je bitevní oceán hráče 1");
            System.out.println();
            System.out.println();
            battlefield1();

        }

    }

    /**
     * Tato metoda ukazuje rozmístění lodí hráče 2
     */
    public static void battleShips2() {
        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Rozmístění lodí na moře hráče 2");
        lodehrace2 = 4;
        for (int i = 1; i <= lodehrace2;) {
            System.out.println();
            System.out.print("Zadejte souřadnice X (řádek 1-8) pro vaši " + i + ". loď: ");
            x = sc.nextInt();
            System.out.println();
            System.out.print("Zadejte souřadnice Y (sloupec 1-8) pro vaši " + i + ". loď: ");
            y = sc.nextInt();
            System.out.println();
            x = x - 1;
            y = y - 1;
            //Podmínky k ošetření rozmisťování, abysme nemohli polohovat lodě mimo pole nebo více lodí na jedno místo
            if ((x >= 0 && x < sloupec) && (y >= 0 && y < radek) && (field[y][x] == "| O |")) {
                field[y][x] = "  S  ";
                field1[y][x] = "| O |";
                i++;
            } else if ((x >= 0 && x < sloupec) && (y >= 0 && y < radek) && field[y][x] == "  S  ") {
                System.out.println("Nemůžete mít více lodí na jedné pozici");

            } else if ((x < 0 || x >= sloupec) || (y < 0 || y >= radek)) {
                System.out.println("Nemůžete umisťovat lodě mimo bitevní pole");

            }
            System.out.println();
            System.out.println();
            System.out.println("Toto je bitevní oceán hráče 2");
            System.out.println();
            System.out.println();
            battlefield2();
        }

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     * Tato metoda ukazuje rozmístění lodí hráče 2
     */
    public static void tahhrac1() {

        int x, y;

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Toto je bitevní oceán hráče 2");
        System.out.println();
        //Legenda
        System.out.println("/  potopená loď");
        System.out.println("-  neúspěšná trefa");
        System.out.println();
        System.out.println();
        battlefield4();
        System.out.println("Hráč 1 na tahu");
        System.out.println();
        //Cyklus pro hraní - každý hráče má jen jednu v každém kole
        for (int i = 0; i < 1; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Zadejte souřadnice X (řádek 1-8) : ");
            x = sc.nextInt();
            System.out.println();
            System.out.print("Zadejte souřadnice Y (sloupec 1-8) : ");
            y = sc.nextInt();
            System.out.println();
            x = x - 1;
            y = y - 1;
//Podmínky, abysme nemohli pálit mimo bitevní oceán
            if ((x >= 0 && x < radek) && (y >= 0 && y < sloupec)) {
                if (field[y][x].equals("  S  ")) {
                    System.out.println();
                    System.out.println("Trefa! Potopil jste nepřátelskou loď");
                    System.out.println();
                    field1[y][x] = "  /  ";
                    --lodehrace2;

                } else if (field1[y][x].equals("  /  ")) {
                    System.out.println();
                    System.out.println("Nemůžete pálit na již potopenou loď");
                    System.out.println();
                    i--;
                } else if (field1[y][x].equals("| O |")) {
                    System.out.println();
                    System.out.println("Špatná muška");
                    System.out.println();
                    field1[y][x] = "  -  ";

                }
            } else {
                System.out.println();
                System.out.println("Nemůžete pálit mimo bitevní pole");
                System.out.println();
                i--;
            }
        }
    }

    /**
     * Metoda přímo pro tah 2. hráče
     */
    public static void tahhrac2() {

        int x, y;

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Toto je bitevní oceán hráče 1");
        System.out.println();
        //legenda
        System.out.println("/  potopená loď");
        System.out.println("-  neúspěšná trefa");
        System.out.println();
        System.out.println();
        battlefield3();
        System.out.println("Hráč 2 na tahu");
        System.out.println();
        //Cyklus pro hraní - každý hráče má jen jednu v každém kole
        for (int i = 0; i < 1; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Zadejte souřadnice X (řádek 1-8) : ");
            x = sc.nextInt();
            System.out.println();
            System.out.print("Zadejte souřadnice Y (sloupec 1-8) : ");
            y = sc.nextInt();
            System.out.println();

            x = x - 1;
            y = y - 1;
            //Podmínky, abysme nemohli pálit mimo bitevní oceán
            if ((x >= 0 && x < radek) && (y >= 0 && y < sloupec)) {
                System.out.println();
                if (pole[y][x].equals("  @  ")) {
                    System.out.println();
                    System.out.println("Trefa! Potopil jste nepřátelskou loď");
                    System.out.println();
                    pole1[y][x] = "  /  ";

                    --lodehrace1;

                } else if (pole1[y][x].equals("  /  ")) {
                    System.out.println();
                    System.out.println("Nemůžete pálit na již potopenou loď");
                    System.out.println();
                    i--;
                } else if (pole1[y][x].equals("| X |")) {
                    System.out.println("Špatná muška");
                    pole1[y][x] = "  -  ";

                }
            } else {
                System.out.println();
                System.out.println("Nemůžete pálit mimo bitevní pole");
                System.out.println();
                i--;
            }

        }
    }

    /**
     * Do této metody rozmisťujeme lodě hráče 1
     */
    public static void battlefield1() {
        int c = 1;
        System.out.println();

        //První řádek
        for (int i = 1; i < pr.length; i++) {
            if (i > 0) {
                pr[i] = i;
            }
            System.out.print("       " + pr[i] + " ");
        }
        System.out.println();
        System.out.println();
        //Ocean
        for (int x = 0; x < pole.length; x++) {

            for (int y = 0; y < pole[x].length; y++) {

                if (y == 0) {
                    System.out.print(c + " |  ");
                    c++;
                }
                System.out.print(pole[y][x] + "    ");
            }
            System.out.println();
            System.out.println();
        }

    }

    /**
     * Do této metody rozmisťujeme lodě hráče 2
     */
    public static void battlefield2() {
        int c = 1;
        System.out.println();

        //První řádek
        for (int i = 1; i < pr.length; i++) {
            if (i > 0) {
                pr[i] = i;
            }
            System.out.print("       " + pr[i] + " ");
        }
        System.out.println();
        System.out.println();
        //Ocean

        for (int x = 0; x < field.length; x++) {

            for (int y = 0; y < field[x].length; y++) {

                if (y == 0) {
                    System.out.print(c + " |  ");
                    c++;
                }
                System.out.print(field[y][x] + "    ");
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Metoda pro bitevní pole hráče 1 přímo pro bitvu, aby hráč nemohl vidět
     * polohu nepřátelských lodí
     */
    public static void battlefield3() {
        int c = 1;
        System.out.println();

        //První řádek
        for (int i = 1; i < pr.length; i++) {
            if (i > 0) {
                pr[i] = i;
            }
            System.out.print("       " + pr[i] + " ");
        }
        System.out.println();
        System.out.println();
        //Ocean
        for (int x = 0; x < pole1.length; x++) {

            for (int y = 0; y < pole1[x].length; y++) {

                if (y == 0) {
                    System.out.print(c + " |  ");
                    c++;
                }

                System.out.print(pole1[y][x] + "    ");
            }
            System.out.println();
            System.out.println();
        }

    }

    /**
     * Metoda pro bitevní pole hráče 2 přímo pro bitvu, aby hráč nemohl vidět
     * polohu nepřátelských lodí
     */
    public static void battlefield4() {
        int c = 1;
        System.out.println();

        //První řádek
        for (int i = 1; i < pr.length; i++) {
            if (i > 0) {
                pr[i] = i;
            }
            System.out.print("       " + pr[i] + " ");
        }
        System.out.println();
        System.out.println();
        //Ocean
        for (int x = 0; x < field1.length; x++) {

            for (int y = 0; y < field1[x].length; y++) {

                if (y == 0) {
                    System.out.print(c + " |  ");
                    c++;
                }
                System.out.print(field1[y][x] + "    ");
            }
            System.out.println();
            System.out.println();
        }

    }

    /**
     * Touto metodou probíhá celá bitva. Poté v mainu jsem jí zabalil do cyklu
     * do while
     */
    public static void Battle() {
        tahhrac1();
        System.out.println();
        System.out.println("Počet lodí hráče 1: " + lodehrace1 + " | Počet lodí hráče 2: " + lodehrace2);
        System.out.println();
        //Podmínka v případě, že hráč 1 potopí všechny nepřátelské lodě hráče 2, aby byl vyhlášen ihned vítězem hráč 1
        if (lodehrace2 > 0) {

            tahhrac2();

            System.out.println();
            System.out.println("Počet lodí hráče 1: " + lodehrace1 + " | Počet lodí hráče 2: " + lodehrace2);
            System.out.println();
        }
    }

    /**
     * Metoda pro vyhlášení vítěze
     */
    public static void gameOver() {
//Podle této podmínky program pozná, že vítězem je hráč 1
        if (lodehrace1 > 0) {
            System.out.println();
            System.out.println("Bitvu vyhrál hráč 1");
            System.out.println();
            //Podle této podmínky program pozná, že vítězem je hráč 2
        } else {
            System.out.println();
            System.out.println("Bitvu vyhrál hráč 2");
            System.out.println();
        }
        System.out.println();
    }
/**
 * Zde se ukládá hra
 * pole [][] - pro prvního hráče, kde se rozmisťují lodě.
 * pole1 [][] - pro prvního hráče. Překrývá lodě původními znaky, aby nepřítel neviděl jejich pozice.
 * field [][] - pro druhého hráče se rozmisťují lodě.
 * field1 [][]- pro druhého hráče. Překrývá lodě původními znaky, aby nepřítel neviděl jejich pozice.
 * @throws IOException 
 */
    public static void save() throws IOException {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("bitva.txt"))) {
            bw.write("VelikostOceanuHrace1:" + sloupec + ";" + radek + ";" + lodehrace1 + ";" + lodehrace2);
            bw.newLine();
            bw.flush();
            bw.newLine();
            for (int k = 0; k < pole.length; k++) {
                bw.write("poleLodi1:");
                for (int j = 0; j < pole[k].length; j++) {
                    bw.write(pole[j][k] + ";");
                }
                bw.newLine();
                bw.flush();
            }
            bw.newLine();
            bw.flush();
            for (int i = 0; i < pole1.length; i++) {
                bw.write("1.hrac:");
                for (int j = 0; j < pole1[i].length; j++) {
                    bw.write(pole1[j][i] + ";");
                }
                bw.newLine();
                bw.flush();
            }
            bw.newLine();
            bw.flush();
            for (int p = 0; p < field.length; p++) {
                bw.write("PoleLodi2:");
                for (int j = 0; j < field[p].length; j++) {
                    bw.write(field[j][p] + ";");
                }
                bw.newLine();
                bw.flush();
            }
            bw.newLine();
            bw.flush();
            for (int i = 0; i < field1.length; i++) {
                bw.write("2.hrac:");
                for (int j = 0; j < field1[i].length; j++) {
                    bw.write(field1[j][i] + ";");
                }
                bw.newLine();
                bw.flush();
            }
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            System.err.println("Do souboru se nepovedlo zapsat.");
        }

    }

    public static void nacti() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("bitva.txt"));

            while ((line = in.readLine()) != null) {
                if (line.startsWith("VelikostOceanuHrace1:")) {
                    line = line.replaceAll("VelikostOceanuHrace1:", "");
                    String[] zaznam = line.split(";");

                    sloupec = Integer.parseInt(zaznam[0]);
                    radek = Integer.parseInt(zaznam[1]);
                    lodehrace1 = Integer.parseInt(zaznam[2]);
                    lodehrace2 = Integer.parseInt(zaznam[3]);
                }
                pole = new String[sloupec][radek];
                int lineCount = 0;
                while ((line = in.readLine()) != null) {

                    if (line.startsWith("poleLodi1:")) {

                        line = line.replaceAll("poleLodi1:", "");
                        String[] zaznam = line.split(";");
                        for (int i = 0; i < zaznam.length; i++) {
                            pole[i][lineCount] = zaznam[i];
                        }
                        lineCount++;
                    }
                }
            }
        } catch (IOException ioException) {
        }
    }
public static void nacti2() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("bitva.txt"));

            
            pole1 = new String[sloupec][radek];
            int lineCount = 0;
            while ((line = in.readLine()) != null) {

                if (line.startsWith("1.hrac:")) {

                    line = line.replaceAll("1.hrac:", "");
                    String[] zaznam = line.split(";");
                    for (int i = 0; i < zaznam.length; i++) {
                        pole1[i][lineCount] = zaznam[i];
                    }
                    lineCount++;
                }
            }
            // }
        } catch (IOException ioException) {
        }
    }
       
    public static void nacti3() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("bitva.txt"));

           
            field = new String[sloupec][radek];
            int lineCount = 0;
            while ((line = in.readLine()) != null) {

                if (line.startsWith("poleLodi2:")) {

                    line = line.replaceAll("poleLodi2:", "");
                    String[] zaznam = line.split(";");
                    for (int i = 0; i < zaznam.length; i++) {
                        field[i][lineCount] = zaznam[i];
                    }
                    lineCount++;
                }
            }
            // }
        } catch (IOException ioException) {
        }
    }
    public static void nacti4() throws IOException {
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("bitva.txt"));

           
            field1 = new String[sloupec][radek];
            int lineCount = 0;
            while ((line = in.readLine()) != null) {

                if (line.startsWith("2.hrac:")) {

                    line = line.replaceAll("2.hrac:", "");
                    String[] zaznam = line.split(";");
                    for (int i = 0; i < zaznam.length; i++) {
                        field1[i][lineCount] = zaznam[i];
                    }
                    lineCount++;
                }
            }
            // }
        } catch (IOException ioException) {
        }
    }

    public static void nactiKomplet() throws IOException {
        nacti();
        nacti2();
        nacti3();
        nacti4();
    }

    public static void program() throws IOException {
        Scanner sc = new Scanner(System.in);
        int volba = 0;
        do {
            System.out.println("Vítejte ve hře Námořní bitva:\n1- Nová bitva. \n2- Načíst vlastní hru.");
            System.out.println("Zadejte akci: ");
            volba = sc.nextInt();
            if (volba == 1) {
                System.out.println("Vítejte ve hře Námořní bitva.");
                System.out.println();
                System.out.println();
                battleMap();
                battleMap2();
                battleShips1();
                battleShips2();
                battleMap3();
                battleMap4();
                do {
                    Battle();
                    save();
                } while (lodehrace1 != 0 && lodehrace2 != 0);
                gameOver();
            } else if (volba == 2) {
                battleMap();
                battleMap2();                              
             battleMap3();
                battleMap4();
                battlefield1();
                battlefield2();
                battlefield3();
                battlefield4();
                
                nactiKomplet();             
                
                do {

                    Battle();
                    // save();
                } while (lodehrace1 != 0 && lodehrace2 != 0);
                gameOver();
            }
        } while (volba != 1 && volba != 2);

    }

    public static void main(String[] args) throws IOException {

        program();
    }
}
