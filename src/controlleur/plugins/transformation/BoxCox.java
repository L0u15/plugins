/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur.plugins.transformation;

import controlleur.plugins.Categorie;
import controlleur.plugins.PluginTransformation;
import java.util.ArrayList;
import model.ISerie;

/**
 *
 * @author lalleaul
 */
public class BoxCox implements PluginTransformation {

    private final String LIBELLE = "Box-Cox";
    private final Categorie CATEGORIE = Categorie.TRANSFORMATION;
    
    private double lambda;

    @Override
    public ISerie transform(ISerie serie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLibelle() {
        return this.LIBELLE;
    }

    @Override
    public Categorie getCategorie() {
        return this.CATEGORIE;
    }

    @Override
    public ArrayList<String> getParam() {
        ArrayList<String>param = new ArrayList<>();
        param.add("");
        return param;
    }

    @Override
    public void setParam(ArrayList<Double> listParam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
