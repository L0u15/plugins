/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controlleur.validateur.BoxCoxValidateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.IParametre;

/**
 *
 * @author lalleaul
 */
public class ParamView extends JPanel {

    private JLabel titre;
    private JLabel description;
    private JTextField champ;

    private IParametre parametre;

    private int LARGEUR_CHAMP = 5;
    private int HAUTEUR_MAX = 20;
    private int LARGEUR_MAX = 300;

    public ParamView(final IParametre parametre) {

        this.parametre = parametre;

        this.titre = new JLabel(parametre.getLibelle());
        this.description = new JLabel(parametre.getDescription());
        this.champ = new JFormattedTextField();
        this.champ.setColumns(this.LARGEUR_CHAMP);

        this.champ.setBackground(Color.white);
        this.setPreferredSize(new Dimension(this.LARGEUR_MAX, this.HAUTEUR_MAX));

        //this.addKeyListener();
        
        this.positionner();

    }

    private void positionner() {
        this.setLayout(new BorderLayout());
        this.add(this.titre, BorderLayout.WEST);
        this.add(this.champ, BorderLayout.EAST);
        this.add(this.description, BorderLayout.SOUTH);
    }

    public void setChamp(String str) {
        this.champ.setText(str);
    }

    public String getChamp() {
        return this.champ.getText();
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void activerWarning() {
        this.champ.setBackground(Color.red);
    }

    public void desactiverWarning() {
        this.champ.setBackground(Color.white);
    }
/**
    private void addKeyListener() {
        this.champ.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {

                String content = champ.getText();

                if (parametre.isValid()) {
                    desactiverWarning();
                } else {
                    activerWarning();
                }
            }
        });
    }*/
}
