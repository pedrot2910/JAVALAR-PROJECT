package controller;

public class Cplus extends Planeta {

	public Cplus() {
		preencherorbita();
		setVeloTrans(2);
		setHoras(0.5);
		setPosicao(new int[] { 8, 14 });
		setBugQuant(0);
		setAnos(0);
		setNome("C++");
		setxIni(8);
		setyIni(14);
		setDevQuant(0);
	}
	public void preencherorbita() {

		orbita = new int[48][2];

		int x = 8;
		int y = 14;

		for (int i = 0; i < 48; i++) {

			orbita[i][0] = x;
			orbita[i][1] = y;

			if (i < 6) {

				x--;

			} else if (i < 18) {

				y--;

			} else if (i < 30) {

				x++;
			} else if (i < 42) {

				y++;

			} else {
				x--;

			}

		}

	}

}
