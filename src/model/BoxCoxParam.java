package model;

import controlleur.validateur.BoxCoxValidateur;

/**
 *
 * @author lalleaul
 */
public class BoxCoxParam implements IParametre {

    private final String LIBELLE = "Lambda";
    private final String DESCRIPTION = "λ >= 0";
    private Double valeur;

    @Override
    public String getLibelle() {
        return this.LIBELLE;
    }

    @Override
    public Double getValeur() {
        return this.valeur;
    }

    @Override
    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    @Override
    public String getDescription() {
        return this.DESCRIPTION;
    }

}
