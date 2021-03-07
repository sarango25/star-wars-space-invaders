package taller_1;

import processing.core.PApplet;

public abstract class NaveEnemiga extends NaveEspacial {

	private int velX, velY;

	public NaveEnemiga(int posX, int posY, int tam, PApplet app) {
		super(posX, posY, tam, app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void movNave() {
		// TODO Auto-generated method stub

	}

	public abstract void pintar();

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

}
