package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Botao extends JButton {

	public Botao(String nome) {
		setText(nome);
		setSize(70, 70);
		setLayout(new GridBagLayout());
		setVisible(true);
		setMaximumSize(new Dimension(200, 200));
		setBackground(Color.white);
//		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
	}
}
