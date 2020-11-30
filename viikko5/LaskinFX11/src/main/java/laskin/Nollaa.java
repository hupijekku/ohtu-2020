/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author eemes
 */
public class Nollaa extends Komento {

    private int arvo;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    public void suorita() {
        arvo = 0;
 
        try {
            arvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        sovellus.nollaa();
        tulosta();
    }

    @Override
    public void peru() {
        sovellus.plus(arvo);
        tulosta();
    }
    
}
