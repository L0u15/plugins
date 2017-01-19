/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur.plugins.transformation;

import controlleur.plugins.Categorie;
import controlleur.plugins.PluginTransformation;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.ISerie;
import model.Ligne;
import model.ParamModel;
import model.SerieToUse;
import operations.Operations;
import vue.BoxCoxVue;

/**
 *
 * @author lalleaul
 */
public class BoxCox implements PluginTransformation {

    private final String LIBELLE = "Box-Cox";

    private final Categorie CATEGORIE = Categorie.TRANSFORMATION;

    private ParamModel lambda =new ParamModel("Lambda", ">= 0");
    private ISerie serie;


    @Override
    public ISerie transform() {

        SerieToUse serie = new SerieToUse();
        ArrayList<Ligne> liste = new ArrayList<>();

        for (Ligne l : this.serie.getEnsLignes()) {

            Ligne ligne = new Ligne();

            ligne.setValDate(l.getValDate());

            double newVal = Operations.BoxCox(l.getValeur(), this.lambda.getValeur());
            ligne.setValeur(newVal);

            liste.add(ligne);
        }
        serie.setEnsLignes(liste);
        return serie;
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
        new BoxCoxVue(frame, this.lambda);
    }

    @Override
    public boolean isPossible() {
        return this.lambda.getValeur() >= 0;
    }

}
