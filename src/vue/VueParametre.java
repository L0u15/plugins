/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
public class VueParametre extends JPanel implements Observer{
    
    private JLabel titre;
    private JLabel description;
    private JTextField champ;
    
    private int LARGEUR_CHAMP = 5;
    private int HAUTEUR_MAX = 20;
    private int LARGEUR_MAX = 200;
    
    public VueParametre(IParametre parametre){
        
        this.titre = new JLabel(parametre.getLibelle());
        this.description = new JLabel(parametre.getDescription());
        this.champ = new JFormattedTextField();
        this.champ.setColumns(this.LARGEUR_CHAMP);
        
        this.champ.setBackground(Color.white);
        this.setPreferredSize(new Dimension(this.LARGEUR_MAX,this.HAUTEUR_MAX));
        
        this.positionner();
        
    }
    
    private void positionner(){
        this.setLayout(new BorderLayout());
        this.add(this.titre,BorderLayout.WEST);
        this.add(this.champ,BorderLayout.EAST);
        this.add(this.description,BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable parametre, Object arg1) {
        
    }
    
    public void setJTextField(Double valeur){
        this.champ.setText(""+valeur.toString());
    }
    
    public void activerWarning(){
        this.champ.setBackground(Color.red);
    }
    
        public void deactiverWarning(){
        this.champ.setBackground(Color.white);
    }
}
