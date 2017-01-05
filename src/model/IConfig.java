/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.ISerie;

/**
 *
 * @author lalleaul
 */
public interface IConfig {

    public ArrayList<IParametre> getParametres();

    public void setParametres(ArrayList<IParametre> listParametres);

    public ISerie getSerie();

    public void setSerie(ISerie serie);
}
