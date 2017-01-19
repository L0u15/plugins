package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ParamModel;

/**
 *
 * @author lalleaul
 */
public class MoyPondVue extends JDialog implements ActionListener {

    private ParamView param;
    private String message = "coucou";

    public MoyPondVue(JFrame frame, ParamModel param) {
        super(frame, "Ordre", true);

        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel(param.getLibelle()));
        this.param = new ParamView(param);
        getContentPane().add(this.param);
        JPanel buttonPane = new JPanel();
        JButton button = new JButton("OK");
        buttonPane.add(button);
        button.addActionListener(this);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
    }
}
