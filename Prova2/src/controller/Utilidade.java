package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilidade {

	public Scanner scanner;
	
	public Utilidade() {
		
	}
	
	public int retornarInstantes() {
		scanner = new Scanner(System.in);
		
		int opcao;
		
		do {
			opcao = scanner.nextInt();
			if(opcao == 0) {
				System.out.println("Número inválido. Por favor, digite novamente:");
			} else if(opcao < 0) {
				System.out.println("Número inválido. Por favor, digite novamente:");
			}
			
		} while (opcao <= 0);
		
		return opcao;
	}
	
	public int retornoOpcao() {
		scanner = new Scanner(System.in);
		
		int opcao = 0;
		
		do {
			
			opcao = scanner.nextInt();
			
			if(opcao <= 0 || opcao > 3) {
				System.out.println("Utilize somente opções válidas.");
			}
		} while (opcao <= 0 || opcao > 3);
			
			return opcao;
	}
	
	public static void mostrar(ArrayList<Planeta> planetas) {
		System.out.println("\n\n--------- Posições dos Planetas ---------");
		for(Planeta planeta : planetas) {
			System.out.println("A posição atual do planeta " + planeta.getNome() + " é (" 
					+ planeta.getPosicaox() + ", " + planeta.getPosicaoy() + ")");
		}
		System.out.println("-------------\n");
	}
	
	public static void mover(ArrayList<Planeta> planetas, int instantes) {
		for(Planeta planeta : planetas) {
			planeta.mover(instantes);
		}
	}
	
	public int retornoQuantdeBugs(int espaco) {
		scanner = new Scanner(System.in);
		int quant = 0;
		
		do {
			
			quant = scanner.nextInt();
			
			if(quant > espaco) {
				
				System.out.println("O limite máximo de bugs que pode criar é " + espaco + " Por favor, digite novamente: ");
			}
		} while (quant > espaco);
		
		return quant;
	}
	public int retornoQuantdeDesenvolvedores(int espaco) {
		scanner = new Scanner(System.in);
		int quant = 0;
		
		do {
			
			quant = scanner.nextInt();
			
			if(quant > espaco) {
				
				System.out.println("O limite máximo de desenvolvedores que pode criar é " + espaco + " Por favor, digite novamente: ");
			}
		} while (quant > espaco);
		
		return quant;
	}
	
	public static void mostrarBugs(ArrayList<Bug> bug) {
		
		for(Bug bug2 : bug) {
			System.out.println("(" + bug2.getX() + ", " + bug2.getY() + ")");
		}
	}
}
