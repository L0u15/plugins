package vue;

import javax.swing.JOptionPane;

import controlleur.validateur.Validateur;

public class Lancer {

	public Lancer() {
		String nbrePara = (String) JOptionPane.showInputDialog(null, "Saisir le nombre de paramètres :", "Nombre de paramètres",
				JOptionPane.QUESTION_MESSAGE, null, null, "3");
		if ((nbrePara != null) && Validateur.isInt(nbrePara)) {
			MoyennePondView m = new MoyennePondView(null, "Saisir les paramètres", true, Integer.parseInt(nbrePara));
			Double[] paras = m.getPara();
			for(Double d : paras){
				System.out.println(d);
			}
			m.dispose();
		}
	}

	public static void main(String[] main) {
		Lancer l = new Lancer();
	}
}
