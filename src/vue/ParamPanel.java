/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controlleur.validateur.BoxCoxValidateur;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.IParametre;

/**
 *
 * @author lalleaul
 */
public class ParamPanel extends JPanel {

    private ArrayList<ParamView> parametres;

    public ParamPanel(ArrayList<IParametre> parametres) {
        super();
        this.parametres = new ArrayList<>();
        
        for(IParametre param : parametres){
            this.parametres.add(new ParamView(param));
        }
        for(ParamView param : this.parametres){
            this.add(param);
        }
    }

    public void setParametres(ArrayList<ParamView> parametres) {
        this.parametres = parametres;
    }

    public ArrayList<ParamView> getParametres() {
        return this.parametres;
    }
    
    public boolean isValid(){
        return true;
    }
    
}
