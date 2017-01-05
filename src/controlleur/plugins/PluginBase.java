/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur.plugins;

import java.util.ArrayList;
import model.ISerie;

/**
 *
 * @author lalleaul
 */
public interface PluginBase {

    /**
     * Obtient le libellé à afficher
     *
     * @return String
     */
    public String getLibelle();

    /**
     * Obtient la catégorie du plugin : transformation, traitement, prévision...
     *
     * @return Categorie
     */
    public Categorie getCategorie();

    /**
     * s'occupe de demander les paramètres necessaires
     */
    public void setParam();
    
    public void setSerie(ISerie serie);

}
