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
public class MoyenneMobilePonderee implements PluginTransformation {

    private final String LIBELLE = "Moyenne mobile ponderée";
    private final Categorie CATEGORIE = Categorie.TRANSFORMATION;

    private ArrayList<ParamModel> ponderations;
    private ISerie serie;

    @Override
    public ISerie transform() {
        SerieToUse newSerie = new SerieToUse();
        Ligne[] lines = new Ligne[this.serie.getEnsLignes().size()];
        lines = this.serie.getEnsLignes().toArray(lines);
        ArrayList<Ligne> list = new ArrayList<>();

        for (int i = 0; i < this.serie.getColumnCount(); i++) {
            list.add(new Ligne(this.serie.getEnsLignes().get(i).getValDate(), null));
            Double d = null;
            if (i - this.ponderations.size() + 1 >= 0) {
                d = moyPond(i);
            }
            System.out.println(this.serie.getAllValues().get(i) + "=>" + d);

            list.get(i).setValeur(d);
        }
        System.out.println("fin transfo");
        newSerie.setEnsLignes(list);
        return newSerie;
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
        this.ponderations = new ArrayList<ParamModel>();
        for (int i = 0; i < 5; i++) {
            Double d = (double) 1 / 1 - i;
            ParamModel pond = new ParamModel("pondaration" + i, "descri" + i);
            pond.setValeur(d);
            this.ponderations.add(pond);
        }
    }

    @Override
    public boolean isPossible() {
        return this.serie.getAllValues().size() > 0;
    }

    private Double moyPond(int index) {
        Double d = 0.0;

        int p = index - this.ponderations.size() + 1;
        int i = 0;
        while (p <= index) {
            d += this.serie.getAllValues().get(p) * this.ponderations.get(i).getValeur();
            i++;
            p++;
        }
        return d;
    }

}
