package controller;

import java.util.ArrayList;
import java.util.Random;

public class MenuJava {

	ArrayList<Bug> bugs;
	ArrayList<Desenvolvedor> dev;
	ArrayList<Planeta> planetas;
	ArrayList<PlanetasExplodidos> caixao;

	public MenuJava() {

		this.planetas = new ArrayList<Planeta>();
		this.bugs = new ArrayList<Bug>();
		this.dev = new ArrayList<Desenvolvedor>();

		Planeta python = new Python();
		Planeta javaScript = new JavaScript();
		Planeta Ruby = new Ruby();
		Planeta php = new PhP();
		Planeta csharp = new Csharp();
		Planeta cplus = new Cplus();
		Planeta c = new C();

		planetas.add(python);
		planetas.add(javaScript);
		planetas.add(Ruby);
		planetas.add(php);
		planetas.add(csharp);
		planetas.add(cplus);
		planetas.add(c);

	}

	public boolean Verificasposioes(int[] posicoes) {

		for (int i = 0; i < bugs.size(); i++) {
			if (posicoes[0] == bugs.get(i).getX() || posicoes[1] == bugs.get(i).getY()) {
				return false;
			}
		}
		for (int i = 0; i < dev.size(); i++) {
			if (posicoes[0] == dev.get(i).getX() || posicoes[1] == dev.get(i).getY()) {
				return false;
			}
		}
		if( posicoes[0] == 8 || posicoes[1] == 8) {
				return false;
		}
		return true;
	}

	public void criarBugs(int quantidade) {

		Random random = new Random();
	
		int[][] posiOcupadas = new int [16][16];
		int x = 0;
		int y = 0;

		
		for(int i = 0; i < quantidade;) {
			
			int[] posicoes = new int[30000];
			
		     	x = random.nextInt(16);
				y = random.nextInt(16);
				
				if(Verificasposioes(posicoes)) {
				posicoes[0] = x;
				posicoes[1] = y;
				
				Bug bug = new Bug(posicoes[0],posicoes[1],null);
				bugs.add(bug);
				
				i++;
				}
				
			if(bugs.size() + dev.size() == 224) {
				i++;
				
			}	
			
		}
	}
	
	public void criarDevs(int quantidade) {
		Random random = new Random();
		
		int[][] posiOcupadas = new int [16][16];
		int x = 0;
		int y = 0;

		
		for(int i = 0; i < quantidade;) {
			
			int[] posicoes = new int[30000];
			
		     	x = random.nextInt(16);
				y = random.nextInt(16);
				
				if(Verificasposioes(posicoes)) {
				posicoes[0] = x;
				posicoes[1] = y;
				
				Desenvolvedor devs = new Desenvolvedor(posicoes[0],posicoes[1],null);
				dev.add(devs);
				
				i++;
				}
				
			if(bugs.size() + dev.size() == 224) {
				i++;
				
			}	
			
		}
	}

	public void addPlanetas(Planeta planetas) {
		this.planetas.add(planetas);
	}

	public void addBug(Bug bug) {
		this.bugs.add(bug);
	}

	public void addDev(Desenvolvedor dev) {
		this.dev.add(dev);
	}

	public ArrayList<Planeta> getPlaneta() {
		return planetas;
	}

	public ArrayList<Desenvolvedor> getDev() {
		return dev;
	}

	public ArrayList<Bug> getBugs() {
		return bugs;
	}
}
