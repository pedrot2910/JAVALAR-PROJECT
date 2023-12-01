package model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivos {

	Path caminho = Paths.get("C:/Users/ELIAC/Desktop/teste");
	
	public Arquivos() {
		
		try {
			
			byte[] text = Files.readAllBytes(caminho);
			String leitura = new String(text);
			System.out.println(leitura + "teste");
			
		}catch(Exception e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		new Arquivos();
	}
}
