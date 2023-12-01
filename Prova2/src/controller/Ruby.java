package controller;

public class Ruby extends Planeta {

	public Ruby() {
		preencherorbita();
		setVeloTrans(2);
		setHoras(48);
		setPosicao(new int[] { 8, 11 });
		setBugQuant(0);
		setAnos(0);
		setNome("Ruby on Rails");
		setxIni(8);
		setyIni(11);
		setDevQuant(0);
	}
	
	public void preencherorbita() {

		int x = 8;
		int y = 11;

		orbita = new int[24][2];

		for (int i = 0; i < 24; i++) {

			orbita[i][0] = x;
			orbita[i][1] = y;

			if (i < 3) {
				x--;

			} else if (i < 9) {
				y--;

			} else if (i < 15) {
				x++;
			} else if (i < 21) {

				y++;
			} else {

				x--;
			}

		}

	}

}
