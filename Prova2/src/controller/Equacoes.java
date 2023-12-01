package controller;

import java.util.ArrayList;


public class Equacoes {
	
	public static void infos(ArrayList<Planeta> planetas, int instantes) {
		hemisferios(planetas);
		
		for (Planeta planeta : planetas) {
			System.out.println("-//-//-//-//- " + planeta.getNome() + " -//-//-//-//-");
			velociTrans(planeta);
			quantosDias(planeta, instantes);
			areaEntreDoisPontos(planetas, planeta);
			distanciaDoisPontos(planetas, planeta);
			System.out.println("\n\n");
		}

	}

	public static void velociTrans(Planeta planeta) {
		System.out.println("A velocidade de translação do planeta " + planeta.getNome() + " é de "
				+ planeta.getVeloTrans() + " unidades por instantes");
	}
	
	public static void quantosDias(Planeta planeta, int instantes) {
		System.out.println("Passaram-se " + planeta.getHoras() * instantes + " horas no planeta " + planeta.getNome());
	}
	
	public static double calculoDias(Planeta planeta, int instantes) {
		
		double dias = planeta.getHoras() * instantes / 24;
		
		if(dias < 1) {
			return 0;
		}
		
		return dias;
	}
	
	public static void areadeCobertura (ArrayList<Planeta> planetas) {
		System.out.println("\n\n--------- ÁREA DE COBERTURA ---------");
		int numdePlanetas = planetas.size();
		double area = 0;
		
		for(int i = 0; i < numdePlanetas; i++) {
			Planeta pontosAtuais = planetas.get(i);
			Planeta pontosFuturos = planetas.get((i+1) % numdePlanetas);
			
			int x1 = pontosAtuais.getPosicaox();
			int y1 = pontosAtuais.getPosicaoy();
			int x2 = pontosFuturos.getPosicaox();
			int y2 = pontosFuturos.getPosicaoy();
			
			area += (x1 * y2) - (x2 * y1);
			
		}
		
		area = 0.5 * Math.abs(area);
		
		System.out.println("--> A área de cobertura é de " + area + "m^2");
		
	}
	public static void hemisferios(ArrayList<Planeta> planeta) {
		int norte = 0;
		int sul = 0;
		
		System.out.println("\n--------- HEMISFÉRIOS ----------");
		
		for (Planeta planeta1 : planeta) {
			if (planeta1.getPosicaoy() > 8) {
				norte++;
			}
			if (planeta1.getPosicaoy() < 8) {
				sul++;
			}
			
		}
		
		if(norte > 0) {
			
			System.out.println("Existem " + norte + " planetas acima da EstrelaJava");
			
		}
		
		if (sul > 0) {
			
			System.out.println("Existem " + sul + " planetas abaixo da EstrelaJava");
		}
		
		if(norte == 0 && sul == 0) {
			
			System.out.println("Todos os planetas estão na mesma coordenada 'y' de EstrelaJava" );
		}
		
		System.out.println("------------------\n\n");
	}
	
	public static void areaEntreDoisPontos(ArrayList<Planeta> planetas, Planeta planeta) {
		System.out.println("\n---- A área é calculada em metros ao Quadrado = m^2 ----");
		
		for (Planeta planeta1 : planetas) {
			for(Planeta planeta2 : planetas) {
				
				if(planeta1 != planeta2 && planeta1 == planeta) {
					double area = calculoArea(planeta1, planeta2);
					
					System.out.println("A área entre " + planeta1.getNome() + " e " + planeta2.getNome() + " é de "
							+ area + " m^2");
				}
			}
		}
	}
	
	public static void distanciaDoisPontos(ArrayList<Planeta> planetas, Planeta planeta) {
		
		System.out.println("\n---- A distância é calculada em Metros = M ----");
		
		for (Planeta planeta1 : planetas) {
			for (Planeta planeta2 : planetas) {

				if (planeta1 != planeta2 && planeta1 == planeta) {

					double distancia = calculoDistancia(planeta1, planeta2);

					String resultado = String.format("%.2f", distancia);

					System.out.println("A distância entre o planeta " + planeta1.getNome() + " e " + planeta2.getNome()
							+ " é de " + resultado + " m");
				}

			}

		}
	}
	
	public static double calculoArea (Planeta planeta1, Planeta planeta2) {
		double altura = Math.abs(planeta2.getPosicaoy() - planeta1.getPosicaoy());
		double base = Math.abs(planeta2.getPosicaox() - planeta1.getPosicaox());
		
		if(altura == 0) {
			altura = 1;
		} else if (base == 0) {
			base = 1;
		}
		
		double area = base * altura;
		
		return area;
	}
	
	public static double calculoDistancia(Planeta planeta1, Planeta planeta2) {
		
		double x = Math.abs(planeta1.getPosicaox() - planeta2.getPosicaox());
		double y = Math.abs(planeta1.getPosicaoy() - planeta2.getPosicaoy());
		
		double xaoQuadr = Math.pow(x, 2);
		double yaoQuadr = Math.pow(y, 2);
		double distancia = Math.sqrt((xaoQuadr + yaoQuadr));
		
		return distancia;
	}
	
}
