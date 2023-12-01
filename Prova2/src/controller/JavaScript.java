package controller;

public class JavaScript extends Planeta {

	public JavaScript() {
		
		preencherorbita();
		setVeloTrans(3);
		setHoras(10);
		setPosicao(new int[] { 8, 10 });
		setBugQuant(0);
		setAnos(0);
		setNome("JavaScript");
		setxIni(8);
		setyIni(10);
		setDevQuant(0);
	}
	
	public void preencherorbita() {

		orbita = new int[16][2];

		int x = 8;
		int y = 10;

		for (int i = 0; i < 16; i++) {

			orbita[i][0] = x;
			orbita[i][1] = y;

			if (i < 2) {

				x--;

			} else if (i < 6) {

				y--;

			} else if (i < 10) {

				x++;

			} else if (i < 14) {

				y++;

			} else {
				x--;
			}

		}

	}
}
