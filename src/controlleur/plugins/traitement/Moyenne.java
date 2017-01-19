/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur.plugins.traitement;

import controlleur.plugins.Categorie;
import controlleur.plugins.PluginTraitement;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.ISerie;
import model.ParamModel;

/**
 *
 * @author lalleaul
 */
public class Moyenne implements PluginTraitement {

    private final String LIBELLE = "Moyenne";
    private final Categorie CATEGORIE = Categorie.TRAITEMENT;

    private ISerie serie;

    @Override
    public double getValue() throws Exception {
        
        double nbValeurs = this.serie.getRowCount();

        double somme = 0;
        for (double valeur : this.serie.getAllValues()) {
            somme += valeur;
        }
        return somme / nbValeurs;

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
    public void setSerie(ISerie serie) {
        this.serie = serie;
    }

    @Override
    public void askValues(JFrame frame) {
    }

    @Override
    public boolean isPossible() {
        return this.serie.getRowCount() > 0;
    }

}
