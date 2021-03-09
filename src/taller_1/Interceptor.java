package taller_1;

import processing.core.PApplet;
import processing.core.PImage;

public class Interceptor extends NaveEnemiga {

	private int vida;
	private PImage interceptor;

	public Interceptor(int posX, int posY, int tam,int velY, PApplet app, int vida, PImage interceptor) {
		super(posX, posY, tam, velY, app);
		this.vida = vida;
		this.interceptor = interceptor;

	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		getApp().imageMode(PApplet.CENTER);
		getApp().image(interceptor, getPosX(), getPosY(), getTam(), getTam());
		getApp().imageMode(PApplet.CORNER);
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
