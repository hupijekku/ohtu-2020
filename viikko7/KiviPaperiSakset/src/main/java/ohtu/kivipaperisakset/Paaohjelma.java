package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmist� vastaan "
                    + "\n (b) teko�ly� vastaan"
                    + "\n (c) parannettua teko�ly� vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            KPSPelaa peli;
            
            if (vastaus.endsWith("a")) {
                peli = KPSPelaa.luoKaksinpeli();
            } else if (vastaus.endsWith("b")) {
                peli = KPSPelaa.luoYksinpeli();
            } else if (vastaus.endsWith("c")) {
                peli = KPSPelaa.luoVaikeaYksinpeli();
            } else {
                break;
            }
            
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            peli.pelaa();
        }

    }
}
