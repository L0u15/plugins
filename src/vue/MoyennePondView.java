package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleur.validateur.Validateur;

public class MoyennePondView extends JDialog {
	private JLabel nomLabel;
	private ArrayList<JTextField> param = new ArrayList<>();
	private int nbrePara;

	public MoyennePondView(JFrame parent, String title, boolean modal, int nbrePara) {
		super(parent, title, modal);
		this.nbrePara = nbrePara;
		this.setSize(400, 135 + nbrePara * 30);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
		this.setVisible(true);
	}

	private void initComponent() {
		JPanel panParam = new JPanel();
		panParam.setBackground(Color.white);
		panParam.setPreferredSize(new Dimension(220, 50 + nbrePara * 30));
		panParam.setBorder(BorderFactory.createTitledBorder("Saisir les paramètres"));

		nomLabel = new JLabel("Saisir les paramètres :");
		panParam.add(nomLabel);

		JTextField text;
		for (int i = 1; i < nbrePara + 1; i++) {
			text = new JTextField();
			text.setPreferredSize(new Dimension(100, 25));
			param.add(text);
			panParam.add(new JLabel("Paramètre N°" + i));
			panParam.add(text);
		}

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panParam);

		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");

		okBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
			}
		});

		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		control.add(okBouton);
		control.add(cancelBouton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}

	public Double[] getPara() {
		Double[] paras = new Double[this.nbrePara];
		for (int i = 0; i < this.nbrePara; i++) {
			paras[i] = Validateur.isDouble(param.get(i).getText()) ? Double.parseDouble(param.get(i).getText()) : null;
		}
		return paras;
	}
}