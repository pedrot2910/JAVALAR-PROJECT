package Arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Arquivos {

	boolean verificador = false;
	
	String line;
	String[] data;
	 
	public ArrayList<Integer> phyton = new ArrayList<Integer>();
	public ArrayList<Integer> JavaScript = new ArrayList<Integer>();
	public ArrayList<Integer> ruby = new ArrayList<Integer>();
	public ArrayList<Integer> php = new ArrayList<Integer>();
	public ArrayList<Integer> CSharp = new ArrayList<Integer>();
	public ArrayList<Integer> CPlusPlus = new ArrayList<Integer>();
	public ArrayList<Integer> C = new ArrayList<Integer>();
	public ArrayList<Integer> numdeBugs = new ArrayList<Integer>();
	public ArrayList<Integer> numdeDevs = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> InstantesGeral = new ArrayList<ArrayList<Integer>>();
	
	
	public Arquivos(){
		
		InstantesGeral = new ArrayList<ArrayList<Integer>>();
		
		InstantesGeral.add(phyton);
		InstantesGeral.add(JavaScript);
		InstantesGeral.add(ruby);
		InstantesGeral.add(php);
		InstantesGeral.add(CSharp);
		InstantesGeral.add(CPlusPlus);
		InstantesGeral.add(C);
		
		
		
	}
	

	public void lerArquivos(String pathEnter) {

		try (BufferedReader b = new BufferedReader(new FileReader(pathEnter))) {
			
			
			line = b.readLine();

			while (line != null) {
				if(verificador) {
				data = line.split(",");

				phyton.add(Integer.parseInt(data[1]));
				JavaScript.add(Integer.parseInt(data[2]));
				php.add(Integer.parseInt(data[3]));
				ruby.add(Integer.parseInt(data[4]));
				CSharp.add(Integer.parseInt(data[5]));
				CPlusPlus.add(Integer.parseInt(data[6]));
				C.add(Integer.parseInt(data[7]));
				numdeBugs.add(Integer.parseInt(data[8]));
				numdeDevs.add(Integer.parseInt(data[9]));
				}
				line = b.readLine();
				verificador = true;
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
	

	
	public ArrayList<Integer> getNumdeBugs() {
		return numdeBugs;
	}

	public String[] getData() {
		return data;
	}



	public ArrayList<Integer> getNumdeDevs() {
		return numdeDevs;
	}



	public ArrayList<Integer> getPhyton() {
		return phyton;
	}



	public ArrayList<Integer> getJavaScript() {
		return JavaScript;
	}



	public ArrayList<Integer> getRuby() {
		return ruby;
	}



	public ArrayList<Integer> getPhp() {
		return php;
	}



	public ArrayList<Integer> getCSharp() {
		return CSharp;
	}



	public ArrayList<Integer> getCPlusPlus() {
		return CPlusPlus;
	}



	public ArrayList<Integer> getC() {
		return C;
	}


}
