package vue;

import controlleur.validateur.BoxCoxValidateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.ParamModel;

/**
 *
 * @author lalleaul
 */
public abstract class PluginView {

    protected JDialog dialog;

    private JPanel panelButtons;
    private JButton cancelButton = new JButton("Annuler");
    protected JButton submitButton = new JButton("Valider");

    public PluginView(JFrame frame) {

        this.panelButtons = new JPanel();
        this.panelButtons.add(this.cancelButton);
        this.panelButtons.add(this.submitButton);

        this.dialog = new JDialog(frame, "Dialog", true);
        this.dialog.add(this.panelButtons, BorderLayout.SOUTH);

        this.dialog.setSize(200, 300);

        this.addCancelListener();
        this.addSubmitListener();

        this.dialog.setLocationRelativeTo(null);
        this.dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.dialog.pack();

    }

    /**
     * Gestion du bouton ANNULER
     */
    protected void addCancelListener() {

        this.cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
    }

    /**
     * Gestion du bouton VALIDER
     */
    protected abstract void addSubmitListener();
}
