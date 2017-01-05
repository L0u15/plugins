package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import vue.Bouton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.ParametreModel;

/**
 *
 * @author lalleaul
 */
public class ParamFenetre extends JFrame implements Observer {

    private final String TITRE = "Paramètre";
    private final int LARGEUR_FRAME = 200;
    private final int LONGUEUR_FRAME = 300;

    private JPanel panelParam;

    private Bouton validerBouton;
    private Bouton annulerBouton;
    private JPanel panelBas;

    public ParamFenetre() {
        super();
        setTitle(this.TITRE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setPreferredSize(new Dimension(this.LARGEUR_FRAME, this.LONGUEUR_FRAME));

        this.getContentPane().add(new VueParametre(new ParametreModel("1er param", "Valeur comprise entre 0 et 10")));

        this.setPanelBas();
        this.getContentPane().add(panelBas);

        pack();
        this.setVisible(true);

    }

    /**
     * Initialise les boutons annuler et valider
     */
    private void setPanelBas() {

        this.validerBouton = new Bouton("Valider");
        this.annulerBouton = new Bouton("Annuler");

        this.panelBas = new JPanel(new BorderLayout());

        this.panelBas.add(this.annulerBouton, BorderLayout.WEST);
        this.panelBas.add(this.validerBouton, BorderLayout.EAST);

    }

    @Override
    public void update(Observable arg0, Object arg1) {
        //TODO
    }

}
