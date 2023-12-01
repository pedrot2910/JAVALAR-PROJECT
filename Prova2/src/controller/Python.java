package controller;

public class Python extends Planeta {

	public Python() {
		preencherorbita();
		setVeloTrans(4);
		setHoras(24);
		setPosicao(new int[] { 8, 9 });
		setBugQuant(0);
		setAnos(0);
		setNome("Python");
		setxIni(8);
		setyIni(9);
		setDevQuant(0);
	}
	
	private void preencherorbita() {
		orbita = new int[8][2];
		int x = 8;
		int y = 9;

		for (int i = 0; i < 8; i++) {

			orbita[i][0] = x;
			orbita[i][1] = y;

			if (i < 1) {

				x--;
			} else if (i < 3) {
				
				y--;
			} else if (i < 5) {
				
				x++;
			} else if (i < 7) {
				
				y++;
			} else {
				
				x--;
			}

		}
	}

}
