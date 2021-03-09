package taller_1;

import processing.core.PApplet;
import processing.core.PImage;

public class Disparo {

	private int posX, posY, tamX, tamY, velY;
	private PApplet app;
	private PImage disparo;

	public Disparo(int posX, int posY, int tamX, int tamY, int velY, PApplet app, PImage disparo) {

		this.posX = posX;
		this.posY = posY;
		this.tamX = tamX;
		this.tamY = tamY;
		this.velY = velY;
		this.app = app;
		this.disparo = disparo;

	}

	public void pintarDisparo() {
		getApp().imageMode(PApplet.CENTER);
		getApp().image(disparo, getPosX(), getPosY(), getTamX(), getTamY());
		getApp().imageMode(PApplet.CORNER);
		
	}

	public void movDisparo() {
		posY -= velY;

	}

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

	public int getTamX() {
		return tamX;
	}

	public void setTamX(int tamX) {
		this.tamX = tamX;
	}

	public int getTamY() {
		return tamY;
	}

	public void setTamY(int tamY) {
		this.tamY = tamY;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
