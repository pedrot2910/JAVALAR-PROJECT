package controller;

import java.util.Random;
import java.awt.Image;
import java.util.ArrayList;

public class Bug implements InterfaceB{

	private Image imagem;
	public int x;
	public int y;
	public Bug(int x, int y, Image imagem) {
		this.x = x;
		this.y = y;
		this.imagem = imagem;
		
	}
	
	public static void EncontrocomBugs(ArrayList<Planeta> planetas, ArrayList<Bug> bugs,
			ArrayList<PlanetasExplodidos> caixao) {
		
		ArrayList<Bug> remoBug = new ArrayList<>();
		ArrayList<Planeta> remoPlaneta = new ArrayList<>();
		
		for (Planeta planeta : planetas) {
			int velotrans = planeta.getVeloTrans();		
			int bugQuant = planeta.getBugQuant();
			
			for(Bug bug : bugs) {
				if(planeta.getPosicaox() == bug.getX() && planeta.getPosicaoy() == bug.getY()) {
					System.out.println("Houve uma colisão do planeta " + planeta.getNome() + " com um bug na posicao ("
							+ planeta.getPosicaox() + "," + planeta.getPosicaoy() + ")");
					planeta.setBugQuant(bugQuant + 1);
					planeta.setVeloTrans(velotrans - 1);
					remoBug.add(bug);
				}
			}
			
			if(planeta.getVeloTrans() == 0) {
				remoPlaneta.add(planeta);
				
				PlanetasExplodidos planetaExplodido = new PlanetasExplodidos();
				
				planetaExplodido.setNome(planeta.getNome());
				caixao.add(planetaExplodido);
				
			}
		}
		System.out.println("\n");
		for(Planeta planeta : remoPlaneta) {
			System.out.println("--> O planeta " + planeta.getNome() + " explodiu.");
		}
		
		planetas.removeAll(remoPlaneta);
		bugs.removeAll(remoBug);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return imagem;
	}
	
	
}
