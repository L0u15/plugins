/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controlleur.validateur.BoxCoxValidateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.IParametre;
import model.ParamModel;

/**
 *
 * @author lalleaul
 */
public class BoxCoxVue extends PluginView {

    private String label;
    private String description = "lambda >= 0";
    private ParamModel param;
    private JTextField display = new JTextField();

    public BoxCoxVue(JFrame frame, ParamModel parametre) {
        super(frame);
        this.label = "Box-Cox";
        this.param = parametre;
        this.dialog.add(new ParamView(parametre), BorderLayout.CENTER);

        this.display.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {

                String content = display.getText();

                if (BoxCoxValidateur.isValid(content)) {
                    System.out.println("Key press : Valeur valide");
                    display.setBackground(Color.white);
                } else {
                    System.out.println("Key press : Valeur non valide");
                    display.setBackground(Color.red);
                }
            }
        });
        this.addSubmitListener();
        this.dialog.setVisible(true);
        this.dialog.pack();
    }

    @Override
    protected void addSubmitListener() {
        this.submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String content = display.getText();

                if (BoxCoxValidateur.isValid(content)) {
                    param.setValeur(Double.parseDouble(content));
                    dialog.dispose();
                } else {
                    System.out.println("Nous ne pouvons valider");
                }
            }
        });
    }
}
