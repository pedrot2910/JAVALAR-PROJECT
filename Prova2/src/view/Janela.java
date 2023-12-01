package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.SistemaFrontJav;

public class Janela extends JFrame {
	

	Painel teste = new Painel(Color.BLACK);
	
	public Janela() {
		
		getContentPane().setBackground(Color.BLACK);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbcPainelB = new GridBagConstraints();
		gbcPainelB.gridx = 0;
		gbcPainelB.gridy = 0;
		gbcPainelB.weightx = 0.2;
		gbcPainelB.weighty = 1.0;
		gbcPainelB.fill = GridBagConstraints.BOTH;
		gbcPainelB.insets = new Insets(0, 0, 0, 2);
		
		GridBagConstraints gbcPlanoC = new GridBagConstraints();
		gbcPlanoC.gridx = 1;
		gbcPlanoC.weightx = 12.0;
		gbcPlanoC.weighty = 2.0;
		gbcPlanoC.fill = GridBagConstraints.BOTH;
		gbcPlanoC.insets = new Insets(0, 2, 0, 0);
		
		setSize(900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sistema Javalar 2.0");
		setLocationRelativeTo(null);
//		setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
		
		
		
	
	
		add(teste.plano, gbcPlanoC);
		add(teste.painelbotoes, gbcPainelB);
	
		
//		add(painelbotoes, BorderLayout.EAST);
//		painelbotoes.setLayout(new BoxLayout(painelbotoes, BoxLayout.Y_AXIS));
//		painelbotoes.add(Box.createRigidArea(new Dimension(70, 20)));
//		painelbotoes.add(botao1);
//		painelbotoes.add(Box.createRigidArea(new Dimension(70, 70)));
//		painelbotoes.add(botao2);
//		painelbotoes.add(Box.createRigidArea(new Dimension(70, 70)));
//		painelbotoes.add(botao3);
//		painelbotoes.add(Box.createRigidArea(new Dimension(70, 70)));
//		painelbotoes.add(botao4);
//		painelbotoes.add(Box.createRigidArea(new Dimension(70, 70)));
//		painelbotoes.add(botao5);

		
		
	}
	

}
