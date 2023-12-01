package controller;



public class Mensagens {
private int opcao = 0;
	
	public static void bemVindo() {

		System.out.println("Bem-vindo ao Sistema JavaLar!!");
		System.out.println("Digite um número correspondente à uma ação!");
		System.out.println("1 - Iniciar Simulação");
		System.out.println("2 - Informações");
		System.out.println("3 - Sair");

	}
	
	public static void mostrarOQueSaoLinguagensDeProgramacao() {
		
		System.out.println("\n-//-//-//- O QUE SÃO LINGUAGENS DE PROGRAMAÇÃO -//-//-//-");
		System.out.println("Linguagens de programação são sistemas formais usados por programadores para criar programas de computador.\nElas definem regras de escrita e significado para instruções que controlam o comportamento de máquinas, permitindo a comunicação entre humanos e computadores.\nExistem muitas linguagens diferentes, cada uma com seus propósitos e características, e elas são essenciais para desenvolver software e sistemas de computador.");
		
	}

	public Mensagens(Utilidade utilidades) {
		
		mostrarInformacoes();
		opcao = utilidades.retornoOpcao();
		
		do {
			if (opcao == 1) {
				mostrarOQueSaoLinguagensDeProgramacao();
			} else if (opcao == 2) {
				continue;
			}
		
			System.out.println("\n\nDeseja saber algo mais?");
			mostrarInformacoes();
			
			opcao = 0;
			opcao = utilidades.retornoOpcao();
			
		}while(opcao < 2);
		
		System.out.println("\n");
	}
	
	public static void mostrarInformacoes() {

		System.out.println("\n1 - O que são linguagens de programação?");
		System.out.println("2 - Voltar ao Menu Principal");

	}
}
