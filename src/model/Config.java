/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lalleaul
 */
public class Config implements IConfig {

    private ArrayList<IParametre> parametres;
    private ISerie serie;

    @Override
    public ArrayList<IParametre> getParametres() {
        return this.parametres;
    }

    @Override
    public void setParametres(ArrayList<IParametre> listParametres) {
        this.parametres = parametres;
    }

    @Override
    public ISerie getSerie() {
        return this.serie;
    }

    @Override
    public void setSerie(ISerie serie) {
        this.serie = serie;
    }

}
