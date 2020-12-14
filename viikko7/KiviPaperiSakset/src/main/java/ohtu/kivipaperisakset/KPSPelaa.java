/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author eemes
 */
public abstract class KPSPelaa {
    
    private static final Scanner scanner = new Scanner(System.in);

    private static Tuomari tuomari;
    
    protected KPSPelaa() {}
    
    public static KPSPelaa luoKaksinpeli() {
        KPSPelaa.tuomari = new Tuomari();
        return new KPSPelaajaVsPelaaja();
    }
    
    public static KPSPelaa luoYksinpeli() {
        KPSPelaa.tuomari = new Tuomari();
        Tekoaly tekoaly = new TekoalyNormaali();
        return new KPSTekoaly(tekoaly);
    }
    
    public static KPSPelaa luoVaikeaYksinpeli() {
        KPSPelaa.tuomari = new Tuomari();
        Tekoaly tekoaly = new TekoalyParannettu(20);
        return new KPSTekoaly(tekoaly);
    }
    
    public void pelaa() {
        
        String ekanSiirto = ekanSiirto();
        String tokanSiirto = haeSiirto(ekanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ekanSiirto();
            tokanSiirto = haeSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    private String ekanSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }
    
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    protected abstract String haeSiirto(String edellinen);
}
