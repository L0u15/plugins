/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur.validateur;

/**
 *
 * @author lalleaul
 */
public class Validateur {

    public static boolean isDouble(String str) {
        Double d;
        try {
            d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            System.out.println("Validateur : la valeur [" + str + "] n'est pas un Double");
            return false;
        }
        return true;
    }

    public static boolean isInt(String str) {
        Integer i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            System.out.println("Validateur : la valeur [" + str + "] n'est pas un Integer");
            return false;
        }
        return true;
    }
}
