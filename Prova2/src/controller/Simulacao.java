package controller;

import java.util.ArrayList;
import java.util.Scanner;



public class Simulacao {

	private Scanner scanner;
	private int instantes = 0;
	private int quantBug = 0;
	private int quantDevs = 0;
	private int espacoDisponivel = 0;
	private int somaInstantes = 0;
	private int opcao = 0;
	
	public Simulacao(ArrayList<Planeta> planetas, Utilidade utilidades, ArrayList<Bug> bugs, ArrayList<Desenvolvedor> desenvs, ArrayList<PlanetasExplodidos> caixao) {
		
		scanner = new Scanner(System.in);
		
		do {
			System.out.println("\nDigite os instantes: ");
			
			instantes = utilidades.retornarInstantes();
			somaInstantes += instantes;
			
			espacoDisponivel = 224 - bugs.size() - desenvs.size();
			
			System.out.println("Digite a quantidade de Bugs desejado: ");
			quantBug = utilidades.retornoQuantdeBugs(espacoDisponivel);
			Bug bug = new Bug(0, 0, null);
			
			espacoDisponivel = 224 - bugs.size() - desenvs.size();
			
			System.out.println("Digite a quantidade de Desenvolvedores desejado: ");
			quantDevs = utilidades.retornoQuantdeDesenvolvedores(espacoDisponivel);
			Desenvolvedor desenvolvedor = new Desenvolvedor(0, 0, null);
			desenvolvedor.criarDesenvolvedores(quantDevs, desenvs, bugs);
			
			Utilidade.mover(planetas, instantes);
			Utilidade.mostrar(planetas);
			
			Bug.EncontrocomBugs(planetas, bugs, caixao);
			Desenvolvedor.EncontrocomDesenvolvedores(planetas, desenvs);
			
			if(planetas.size() == 0) {
				System.out.println("Todos os planetas explodiram.");
				Relatorio.relatorio(planetas, caixao, somaInstantes);
				System.out.println("\n\nFim de simulação!");
				break;
			}
			
			Equacoes.infos(planetas, instantes);
			
			System.out.println("\n\nDeseja continuar?");
			System.out.println("1 - Sim!");
			System.out.println("2 - Não!");

			opcao = scanner.nextInt();

			if (opcao == 2) {
				Relatorio.relatorio(planetas, caixao, somaInstantes);
				System.out.println("\n\nFim de programa!");
				
			}
			
		}while (opcao == 1);
	}
}
