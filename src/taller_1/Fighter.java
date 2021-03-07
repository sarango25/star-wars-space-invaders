package taller_1;

import processing.core.PApplet;

public class Fighter extends NaveEnemiga {

	private int vida;
	

	public Fighter(int posX, int posY, int tam, PApplet app, int vida) {
		super(posX, posY, tam, app);
		this.vida = vida;
		
	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub

	}
	public void movNave() {
		
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	

}
