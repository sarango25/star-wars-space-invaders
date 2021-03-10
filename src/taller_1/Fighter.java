package taller_1;

import processing.core.PApplet;
import processing.core.PImage;

public class Fighter extends NaveEnemiga {

	private PImage fighter;

	public Fighter(int posX, int posY, int tam, int velY, PApplet app, int vida, PImage fighter) {
		super(posX, posY, tam, velY, app, vida);
		this.fighter = fighter;

	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		getApp().imageMode(PApplet.CENTER);
		getApp().image(fighter, getPosX(), getPosY(), getTam(), getTam());
		getApp().imageMode(PApplet.CORNER);
	}

}
