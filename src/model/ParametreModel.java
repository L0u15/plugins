/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;

/**
 *
 * @author lalleaul
 */
public class ParametreModel extends Observable implements IParametre {

    private final String LIBELLE;
    private Double valeur;
    private String description;

    public ParametreModel(String libelle) {
        this.LIBELLE = libelle;
    }
        public ParametreModel(String libelle, String description) {
        this.LIBELLE = libelle;
        this.description = description;
    }

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
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

}
