package taller_1;

import processing.core.PApplet;

public abstract class NaveEspacial {

	private int posX, posY, tam;
	private PApplet app;

	public NaveEspacial(int posX, int posY, int tam, PApplet app) {

		this.posX = posX;
		this.posY = posY;
		this.tam = tam;
		this.app = app;
	}

	public abstract void movNave();
	

	public abstract void pintar();
		

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
