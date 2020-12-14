package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPelaa {

    private static final Scanner scanner = new Scanner(System.in);
    
    protected KPSPelaajaVsPelaaja() {}

    @Override
    protected String haeSiirto(String edellinen) {
        System.out.println("Toisen pelaajan siirto:");
        String siirto = scanner.nextLine();
        return siirto;
    }
    
}