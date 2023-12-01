package controller;

public class C extends Planeta{

	public C() {
		preencherorbita();
		setVeloTrans(10);
		setHoras(0.1);
		setPosicao(new int[] { 8, 15 });
		setBugQuant(0);
		setAnos(0);
		setNome("C");
		setxIni(8);
		setyIni(15);
		setDevQuant(0);
	}
	
	public void preencherorbita() {

		orbita = new int[56][2];

		int x = 8;
		int y = 15;

		for (int i = 0; i < 56; i++) {

			orbita[i][0] = x;
			orbita[i][1] = y;
			if (i < 7) {

				x--;

			} else if (i < 21) {

				y--;

			} else if (i < 35) {

				x++;
			} else if (i < 49) {

				y++;

			} else {
				x--;

			}
			
		}
		
	}

}
