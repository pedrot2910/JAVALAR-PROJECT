package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import Arquivos.Arquivos;
import controller.Bug;
import controller.SistemaFrontJav;

public class Painel extends JPanel {
	
	public Painel(Color cor) {
		setBackground(cor);
		setSize(600, 300);
		setVisible(true);
		
		CriarPainelBotoes();
		CriarPlano();
		addPlaneta();
		
	}
	
	private boolean[][] posiOcupadas;
	public static final int dimension_size = 16;
	public ArrayList<JLabel> labels = new ArrayList<>();
	public JPanel plano = new JPanel();
	public JPanel painelbotoes = new JPanel();
	SistemaFrontJav javalar = new SistemaFrontJav();
	public static final int num_planetas = 7;
	public int[] auxX = {8, 8, 8, 8, 8, 8, 8};
	public int[] auxY = {9, 10, 11, 12, 13, 14, 15};
	Botao botao1 = new Botao("Processar próximo instante");
	Botao botao2 = new Botao("Ler novo arquivo de entrada");
	Botao botao3 = new Botao("Gravar Relatório");
	Botao botao4 = new Botao("Ler dados de outros participantes");
	Botao botao5 = new Botao("Gravar arquivos de saída");
	
	public void CriarPlano() {
		plano = new JPanel();
		plano.setLayout(new GridLayout(dimension_size, dimension_size));
		plano.setBackground(Color.BLACK);
		
	}
	
	public void CriarPainelBotoes() {
		painelbotoes = new JPanel();
		setSize(100, 400);
		setBackground(Color.blue);
		setVisible(true);
		Border Bordas = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border BordasR = BorderFactory.createLineBorder(Color.BLACK, 10, true);
		painelbotoes.setBorder(Bordas);
		painelbotoes.setBorder(BordasR);
		painelbotoes.setLayout(new BoxLayout(painelbotoes, BoxLayout.Y_AXIS));
		painelbotoes.add(Box.createRigidArea(new Dimension(70, 40)));
		painelbotoes.add(botao1);
		painelbotoes.add(Box.createRigidArea(new Dimension(70, 70)));
		painelbotoes.add(botao2);
		painelbotoes.add(Box.createRigidArea(new Dimension(70, 70)));
		painelbotoes.add(botao3);
		painelbotoes.add(Box.createRigidArea(new Dimension(70, 70)));
		painelbotoes.add(botao4);
		painelbotoes.add(Box.createRigidArea(new Dimension(70, 70)));
		painelbotoes.add(botao5);
		painelbotoes.add(Box.createRigidArea(new Dimension(70, 40)));
		
		botao1.setEnabled(false);
		
		botao2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				LerArquivo();
				botao1.setEnabled(true);
			}
				
		});
		
		botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				criarBugAndDev();
				MoverPlanets();
			
			}
		});
		
		setVisible(true);
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
				label.setPreferredSize(new Dimension(22, 22));
				label.setOpaque(true);
				label.putClientProperty("x", x);
				label.putClientProperty("y", y);
				labels.add(label);
				plano.add(label);
				
			}
			
		}
		return plano;
		
	}
	
	public void setImagensP(int x, int y, String ImageName, int largura, int altura) {
		JLabel label = getPlano(x, y);
		
		if(label != null) {
			ImageIcon image = criarImageIcon(ImageName, largura, altura);
			label.setIcon(image);
		}
	}
	
	private ImageIcon criarImageIcon(String caminho, int largura, int altura) {
	    java.net.URL imageUrl = getClass().getResource(caminho);
	    if (imageUrl != null) {
	        try {
	            BufferedImage img = ImageIO.read(imageUrl);
	            int imgLargura = img.getWidth();
	            int imgAltura = img.getHeight();

	            double proporcaoLargura = (double) largura / imgLargura;
	            double proporcaoAltura = (double) altura / imgAltura;
	            double escala = Math.min(proporcaoLargura, proporcaoAltura);

	            int novaLargura = (int) (imgLargura * escala);
	            int novaAltura = (int) (imgAltura * escala);

	            Image image = img.getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
	            return new ImageIcon(image);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.err.println("Imagem não encontrada: " + caminho);
	    }
	    return null;
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
	
	public void criarBugAndDev() {
		
		
		javalar.criarBugs();
		javalar.criarDevs();
		
	}
	
	
	
	public void addPlaneta() {
		criarCelulas();
		
		setImagensP(8, 8, "java.png", 40, 42);
		setImagensP(8, 9, "python.jpg", 40, 42);
		setImagensP(8, 10, "JavaScript2.png", 40, 42);
		setImagensP(8, 11, "Ruby2.png", 40, 42);
		setImagensP(8, 12, "php2.png", 40, 42);
		setImagensP(8, 13, "Csharp.png", 40, 42);
		setImagensP(8, 14, "Cplus.png", 40, 42);
		setImagensP(8, 15, "C.png", 40, 42);

	}
	
	public void addBugs() {
		javalar.criarBugs();

		for (Bug bugs : javalar.getBugs2()) {
			JLabel label = getPlano(javalar.getCoordenadaXBug(bugs.getX()), javalar.getCoordenadaYBug(bugs.getY()));
			
			if(label != null & label.getIcon() == null) {
				setImagensP(bugs.getX(), bugs.getY(), "download (1).png", 40, 42);
			}
		}
	}
	
	public void LerArquivo() {
		javalar.LerArquivo();
	}
}
