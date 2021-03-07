package taller_1;

import processing.core.PApplet;

public class NavePrincipal extends NaveEnemiga {

	private int velX;
	private boolean disparando;

	public NavePrincipal(int posX, int posY, int tam, PApplet app, int velX, boolean disparando) {
		super(posX, posY, tam, app);
		this.velX = velX;
		this.disparando = disparando;

	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub

	}

	public void disparar() {

	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public boolean isDisparando() {
		return disparando;
	}

	public void setDisparando(boolean disparando) {
		this.disparando = disparando;
	}

}
