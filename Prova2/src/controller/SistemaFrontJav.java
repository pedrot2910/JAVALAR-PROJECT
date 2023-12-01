package controller;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Arquivos.Arquivos;
import view.Painel;

public class SistemaFrontJav {
	
	MenuJava planocartesi = new MenuJava();
	Arquivos arq = new Arquivos();
//	Bug BugsPlano = new Bug(0, 1);
//	Desenvolvedor DevsPlano = new Desenvolvedor(0, 1);
	private boolean[][] posiOcupadas;
	 private ArrayList<Bug> bugs = new ArrayList<>();
	 private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();
	 private Random random = new Random();
	 private Bug BugsPlano;
	 private Desenvolvedor DevsPlano;
	 private int linhas;
    
    
	public int maxBugAndDev = 0;

	
	public SistemaFrontJav() {
		
		instanciandoPlanetas(planocartesi);
		
	}
	
	public void instanciandoPlanetas(MenuJava Javalar) {
		
		Javalar.addPlanetas(new Python());
		Javalar.addPlanetas(new JavaScript());
		Javalar.addPlanetas(new Ruby());
		Javalar.addPlanetas(new PhP());
		Javalar.addPlanetas(new Csharp());
		Javalar.addPlanetas(new Cplus());
		Javalar.addPlanetas(new C());
	}
	
	public void moverPlants(ArrayList<Planeta> planetas, Arquivos instantes, int linhas) {
		
		if(arq.getData().length <= 9) {
			for (int i = 0; i < planocartesi.getPlaneta().size(); i++) {
				
				moverPlants(planetas.get(i), instantes.InstantesGeral);
				
			}
		}
		
		else {
			JOptionPane.showMessageDialog(null, "O arquivo já está completo. Escolha um novo",
					"Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private Object get(int linhas2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void criarDevs() {
		
		
		
		int quant = 0;
		
		if(arq.getNumdeDevs().size() > 0) {
			
			quant = arq.getNumdeDevs().get(0);
			maxBugAndDev = maxBugAndDev + quant;
			
		}
		
		if(maxBugAndDev < 224 && arq.getNumdeDevs().size() > 0) {
			planocartesi.criarDevs(quant);
			arq.getNumdeDevs().remove(0);
		}
	
		
	}
	
	
	public void criarBugs() {

		int quant = 0;
		
		if(arq.getNumdeBugs().size() > 0) {
			
			quant = arq.getNumdeBugs().get(0);
			maxBugAndDev = maxBugAndDev + quant;
			
		}
		
		if(maxBugAndDev < 224 && arq.getNumdeBugs().size() > 0) {
			planocartesi.criarBugs(quant);
			arq.getNumdeBugs().remove(0);
		}
		
	}
	
	public ArrayList<Bug> getBugs2() {
		return planocartesi.getBugs();
	}
	
	public int getCoordenadaXBug(int indice) {
		return planocartesi.getBugs().get(indice).getX();
	}
	
	public int getCoordenadaYBug(int indice) {
		return planocartesi.getBugs().get(indice).getY();
	}
	
	public int getCoordenadaXDevs(int indice) {
		return planocartesi.getDev().get(indice).getX();
	}
	public int getCoordenadaYDevs(int indice) {
		return planocartesi.getDev().get(indice).getY();
	}
	
	public int getPlanetaCoordX(int indice) {
		return planocartesi.getPlaneta().get(indice).getPosicaox();
	}
	
	public int getPlanetaCoordy(int indice) {
		return planocartesi.getPlaneta().get(indice).getPosicaoy();
	}
	public void LerArquivo() {
	JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File("C:\\Users\\ELIAC\\Downloads\\Arquivos"));

    // Cria um filtro para exibir apenas arquivos .csv
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
    fileChooser.setFileFilter(filter);

    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String caminhoArquivo = selectedFile.getAbsolutePath();
        
        // Verifica se o arquivo selecionado é .csv antes de ativar o botão1
        if (selectedFile.getName().toLowerCase().endsWith(".csv")) {
            Arquivos arq = new Arquivos();
            arq.lerArquivos(caminhoArquivo);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um arquivo .csv!");
        	}
    	}
    
	}
	
}
