package controller;

public class Csharp extends Planeta{

	
	public Csharp() {
		preencherorbita();
		setVeloTrans(1);
		setHoras(4);
		setPosicao(new int[] { 8, 13 });
		setBugQuant(0);
		setAnos(0);
		setNome("C#");
		setxIni(8);
		setyIni(13);
		setDevQuant(0);
	}
	
	public void preencherorbita() {

		orbita = new int[40][2];

		int x = 8;
		int y = 13;

		for (int i = 0; i < 40; i++) {

			orbita[i][0] = x;
			orbita[i][1] = y;

			if (i < 5) {

				x--;

			} else if (i < 15) {

				y--;

			} else if (i < 25) {

				x++;
			} else if (i < 35) {

				y++;

			} else {
				x--;

			}

		}

	}

}
