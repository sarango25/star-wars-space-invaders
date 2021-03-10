package taller_1;

import processing.core.PApplet;

public abstract class NaveEnemiga extends NaveEspacial {
	
	private int vida;
	private int velY;

	public NaveEnemiga(int posX, int posY,int tam,int velY, PApplet app, int vida) {
		super(posX, posY, tam, app);
		this.velY = velY;
		this.vida = vida;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void movNave() {
		// TODO Auto-generated method stub
		setPosY(getPosY() + velY);
	}

	public abstract void pintar();

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

}
