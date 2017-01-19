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
import vue.MoyPondVue;
import vue.ParamPanel;
import vue.ParamView;

/**
 *
 * @author lalleaul
 */
public class Test {

    public Test() {
        ParamModel param = new ParamModel("Ordre", "entier positif");

        MoyPondVue moy = new MoyPondVue(new JFrame(), param);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });
    }

}
