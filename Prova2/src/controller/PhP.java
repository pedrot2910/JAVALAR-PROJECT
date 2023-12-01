package controller;

public class PhP extends Planeta {

	public PhP() {
		preencherorbita();
		setVeloTrans(2);
		setHoras(60);
		setPosicao(new int[] { 8, 12 });
		setBugQuant(0);
		setAnos(0);
		setNome("PhP");
		setxIni(8);
		setyIni(12);
		setDevQuant(0);
	}
	
	public void preencherorbita() {

		int x = 8;
		int y = 12;

		orbita = new int[32][2];

		for (int i = 0; i < 32; i++) {

			orbita[i][0] = x;
			orbita[i][1] = y;

			if (i < 4) {

				x--;

			} else if (i < 12) {

				y--;

			} else if (i < 20) {

				x++;
			} else if (i < 28) {

				y++;

			} else {
				x--;

			}

		}

	}

}
