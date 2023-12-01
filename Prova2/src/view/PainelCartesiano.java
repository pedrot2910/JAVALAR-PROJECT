package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.SistemaFrontJav;

public class PainelCartesiano extends JPanel {

	public PainelCartesiano(Color cor, int celulasPorLinha, int totalCelulas) {
		setBackground(cor);
		setSize(600, 300);
			
	}
	
	public static final int dimension_size = 16;
	public ArrayList<JLabel> labels = new ArrayList<>();
	public JPanel plano = new JPanel();
	SistemaFrontJav javalar = new SistemaFrontJav();
	public static final int num_planetas = 7;
	public int[] auxX = {8, 8, 8, 8, 8, 8, 8};
	public int[] auxY = {9, 10, 11, 12, 13, 14, 15};
	
	public void CriarPlano() {
		plano = new JPanel();
		plano.setLayout(new GridLayout(dimension_size, dimension_size));
		plano.setBackground(Color.BLACK);
		
	}
	
	public JLabel getPlano(int x, int y) {
		
		for(JLabel label : labels) {
			if((int) label.getClientProperty("x") == x && (int) label.getClientProperty("y") == y) {
				return label;
			}
		}
		return null;
	}
	
	public Component criarCelulas() {
		
		for(int y = dimension_size - 1; y > 0; y--) {
			
			for(int x = 1; x < dimension_size; x++) {
				
				JLabel label = new JLabel();
				label.setBackground(Color.BLACK);
				label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				label.setPreferredSize(new Dimension(44, 44));
				label.setOpaque(true);
				label.putClientProperty("x", x);
				label.putClientProperty("y", y);
				labels.add(label);
				plano.add(label);
				
			}
			
		}
		return plano;
		
	}
	
	public void setImagensP(int x, int y, String caminho) {
		JLabel label = getPlano(x, y);
		
		if(label != null) {
			ImageIcon image = new ImageIcon(getClass().getResource("/imagens/" + caminho));
			label.setIcon(image);
		}
	}
	
	public void moverPlanetas(int atualX, int atualY, int novoX, int novoY) {
		
		JLabel LabelInicial = getPlano(atualX, atualY);
		
		JLabel LabelNovos = getPlano(novoX, novoY);
		
		if(LabelInicial != null && LabelNovos != null && (atualX != novoX || atualY != novoY)) {
			
			if(LabelNovos.getIcon() == null) {
				LabelNovos.setIcon(LabelInicial.getIcon());
				LabelInicial.setIcon(null);
			}
			
		}
		
		
	}
	
	public void MoverPlanets() {
		javalar.moverPlants();
		
		for(int i = 0; i < num_planetas; i++) {
			int coordX = javalar.getPlanetaCoordX(i);
			int coordY = javalar.getPlanetaCoordy(i);
			
			moverPlanetas(auxX[i], auxY[i], coordX, coordY);
			
			auxX[i] = coordX;
			auxY[i] = coordY;
		}
	}
	
//	public void criarBugAndDev() {
//		
//		javalar.criarBugs();
//		javalar.criarDevs();
//	}

	
}
