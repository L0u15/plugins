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
public class BoxCoxValidateur {

    public static boolean isValid(String str) {
        Double d;

        // Vérifie si c'est un Double
        try {
            d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            System.out.println("La valeur n'est pas un Double");
            return false;
        }
        // Vérifie la valeur du Double
        if (d >= 0) {
            System.out.println("Valeur OK");
            return true;
        } else {
            System.out.println("Valeur inférieur à zéro");

            return false;
        }
    }
}
