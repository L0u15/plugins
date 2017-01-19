package main;

import controlleur.SerieControleur;
import controlleur.plugins.transformation.BoxCox;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.IParametre;
import model.ParamModel;
import model.SerieToUse;
import vue.BoxCoxVue;
import vue.Fenetre;
import vue.ParamPanel;
import vue.ParamView;

/**
 *
 * @author lalleaul
 */
public class Test {

    public static Double calImpair(Double[] tab, int index, int ordre) {
        Double d = 0.0;

        for (int j = index - (ordre - 1) / 2; j <= index + (ordre - 1) / 2; j++) {
            d += tab[j];
        }

        return d / ordre;
    }

    public static void affiche(Double[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null) {
                System.out.print("null ");
            } else {
                System.out.print(tab[i].toString() + " ");

            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Double[] tab = {2.0, 3.0, 5.0, 8.0, 8.0, 7.0, 8.0, 5.0, 2.0};
        Double[] moyMob = new Double[tab.length];
        affiche(tab);

        int h = 3;

        for (int i = 0; i < tab.length; i++) {
            Double d = null;
            if (i - (h - 1) / 2 >= 0 && i + (h - 1) / 2 < tab.length) {
                d = calImpair(tab, i, h);
            }
            moyMob[i] = d;
        }
        affiche(moyMob);

    }

}
