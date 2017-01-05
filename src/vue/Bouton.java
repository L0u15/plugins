/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author lalleaul
 */
public class Bouton extends JButton {

    private final int HAUTEUR  = 30;
    private final int LARGEUR  = 90;

    public Bouton(String libelle) {
        super(libelle);
        this.setPreferredSize(new Dimension(this.LARGEUR,this.HAUTEUR));
    }
}
