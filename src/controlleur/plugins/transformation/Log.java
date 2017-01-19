package controlleur.plugins.transformation;

import controlleur.plugins.Categorie;
import controlleur.plugins.PluginTransformation;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.ISerie;
import model.Ligne;
import model.SerieToUse;
import operations.Operations;

/**
 *
 * @author lalleaul
 */
public class Log implements PluginTransformation {

    private final String LIBELLE = "Log";
    private final Categorie CATEGORIE = Categorie.TRANSFORMATION;

    private ISerie serie;

    @Override
    public ISerie transform() {
        SerieToUse serie = new SerieToUse();
        ArrayList<Ligne> list = new ArrayList<>();

        for (Ligne oldLine : this.serie.getEnsLignes()) {

            Ligne newLine = new Ligne();

            newLine.setValDate(oldLine.getValDate());

            double newVal = Operations.ln(oldLine.getValeur());
            System.out.println(oldLine.getValeur() + "=>" + newVal);
            newLine.setValeur(newVal);
            list.add(newLine);
        }
        serie.setEnsLignes(list);
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
    }

    @Override
    public boolean isPossible() {
        for (double val : this.serie.getAllValues()) {
            if (val <= 0 || val >= 1) {
                return false;
            }
        }
        return true;
    }

}
