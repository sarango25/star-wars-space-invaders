package taller_1;

import processing.core.PApplet;
import processing.core.PImage;

public class NavePrincipal extends NaveEspacial {

	private int velX;
	private boolean disparando;
	private PImage xwing;

	public NavePrincipal(int posX, int posY, int tam, PApplet app, int velX, boolean disparando, PImage xwing) {
		super(posX, posY, tam, app);
		this.velX = velX;
		this.disparando = disparando;
		this.xwing = xwing;

	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		getApp().imageMode(PApplet.CENTER);
		getApp().image(xwing, getPosX(), getPosY(), getTam(), getTam());
		getApp().imageMode(PApplet.CORNER);
	}

	public void disparar() {
		disparando = true;
	

	}

	public void movIzq() {
		if (getPosX() > 87) {
			setPosX(getPosX() - velX);
		}
	}

	public void movDer() {
		if (getPosX() < 1366 - getTam()) {
			setPosX(getPosX() + velX);

		}
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

	@Override
	public void movNave() {
		// TODO Auto-generated method stub
		
	}

}
