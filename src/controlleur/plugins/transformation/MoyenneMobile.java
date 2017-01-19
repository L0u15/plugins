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

/**
 *
 * @author lalleaul
 */
public class MoyenneMobile implements PluginTransformation {
    
    private final String LIBELLE = "Moyenne mobile simple";
    
    private final Categorie CATEGORIE = Categorie.TRANSFORMATION;
    
    private ParamModel ordre = new ParamModel("Ordre");
    private ISerie serie;
    
    @Override
    public ISerie transform() {
        SerieToUse newSerie = new SerieToUse();
        Ligne[] lines = new Ligne[this.serie.getEnsLignes().size()];
        lines = this.serie.getEnsLignes().toArray(lines);
        
        ArrayList<Ligne> list = new ArrayList<>();
        
        int h = this.ordre.getValeur().intValue();

        //Si ordre = pair
        if (h % 2 == 1) {
            for (int i = 0; i < lines.length; i++) {
                list.add(new Ligne(lines[i].getValDate(), null));
                if (i - (h - 1) / 2 >= 0 && i + (h - 1) / 2 < lines.length) {
                    list.get(i).setValeur(this.moyOrdreImpair(i));
                    
                }
            }
        } else {
            for (int i = 0; i < lines.length; i++) {
                list.add(new Ligne(lines[i].getValDate(), null));
                if (i - h / 2 >= 0 && i + h / 2 < lines.length) {
                    list.get(i).setValeur(this.moyOrdrepair(i));
                }
            }
        }
        newSerie.setEnsLignes(list);
        return newSerie;
    }
    
    private Double moyOrdreImpair(int i) {
        
        int h = this.ordre.getValeur().intValue();
        
        Double d = 0.0;
        
        for (int j = i - (h - 1) / 2; j <= i + (h - 1) / 2; j++) {
            d += this.serie.getEnsLignes().get(i).getValeur();
        }
        
        return d / h;
    }
    
    private Double moyOrdrepair(int i) {
        
        int h = this.ordre.getValeur().intValue();
        
        Double d = 0.0;
        
        for (int j = i - h / 2; j <= i + h / 2; j++) {
            if (j == i - h / 2 || j == i + h / 2) {
                d += this.serie.getEnsLignes().get(i).getValeur() / 2;
            } else {
                d += this.serie.getEnsLignes().get(i).getValeur();
                
            }
        }
        
        return d / h;
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
        this.ordre.setValeur(5.00);
    }
    
    @Override
    public boolean isPossible() {
        return true;
    }
    
}
