package controller;

 abstract class Planeta implements MovimentoPlaneta {
	 protected int[] posicao = new int [2];
	 protected String nome;
	 protected int velotrans;
	 protected double horas;
	 protected int bugQuant;
	 protected int devQuant;
	 protected int anos;
	 protected int xIni, yIni;
	 protected int orbita[][];
	 protected int posiAtual;

	public Planeta() {
		
	}
	 
	public int[][] getOrbita(){
		return orbita;
	}
	
	public void setOrbita(int [][] orbita) {
		this.orbita = orbita;
	}
	
	public int getPosiatual() {
		return posiAtual;
	}
	public void setPosiatual(int posiAtual) {
		this.posiAtual = posiAtual;
	}
	
	public int getxIni() {
		return xIni;
	}
	
	public void setxIni(int xIni) {
		this.xIni = xIni;
	}
	
	public int getyIni() {
		return yIni;
	}
	
	public void setyIni(int yIni) {
		this.yIni = yIni;
	}
	
	public int getAnos() {
		return anos;
	}
	
	public void setAnos(int anos) {
		this.anos = anos;
	}
	
	public int getDevQuant() {
		return devQuant;
	}
	
	public void setDevQuant(int devQuant) {
		this.devQuant = devQuant;
	}
	
	public int getBugQuant() {
		return bugQuant;
	}
	
	public void setBugQuant(int bugQuant) {
		this.bugQuant = bugQuant;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int[] getPosicao() {
		return posicao;
	}
	
	public int getPosicaox() {
		return this.posicao[0];
	}
	
	public int getPosicaoy() {
		return this.posicao[1];
	}
	
	public void setPosicao(int[] posicao) {
		this.posicao = posicao;
	}
	
	public int getVeloTrans() {
		return velotrans;
	}
	
	public void setVeloTrans(int velotrans) {
		this.velotrans = velotrans;
	}
	
	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public void mover(int instantes) {
		 
		for(int i = 0; i < instantes; i++) {
			
			posiAtual = (posiAtual + getVeloTrans()) % orbita.length;
			setPosicao(orbita[posiAtual]);
			
			if(getPosicaox() == getxIni() && getPosicaoy() == getyIni()) {
				
				anos++;
			}
		}
	}
	
	

}
