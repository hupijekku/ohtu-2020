package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KPSPelaa{

    private static final Scanner scanner = new Scanner(System.in);
    private Tekoaly tekoaly;
    
    protected KPSTekoaly(Tekoaly tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    protected String haeSiirto(String edellinen) {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        tekoaly.asetaSiirto(edellinen);
        return siirto;
    }
    
    
}