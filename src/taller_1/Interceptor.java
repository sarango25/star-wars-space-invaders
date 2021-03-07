package taller_1;

import processing.core.PApplet;

public class Interceptor extends NaveEnemiga {

	private int vida;
	private PApplet app;

	public Interceptor(int posX, int posY, int tam, PApplet app, int vida) {
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

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	

}
