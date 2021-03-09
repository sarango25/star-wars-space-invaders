package taller_1;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	PImage inicio1, inicio2, instruccion1, instruccion2, instruccion3, instruccion4, instruccion5, instruccion6,
			instruccion7, instruccion8, instruccion9, resumen1, resumen2, juego1, fighterImage, interceptorImage,
			xwingImage, disparoImage;

	int pantalla;
	NavePrincipal xwing;
	Disparo disparo;
	Fighter fighter;
	Interceptor interceptor;
	ArrayList<NaveEnemiga>[] enemigos = new ArrayList[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(1366, 768);

	}

	public void setup() {

		inicio1 = loadImage("Imagenes/Inicio_1.png");
		inicio2 = loadImage("Imagenes/Inicio_2.png");
		instruccion1 = loadImage("Imagenes/Instruccion_1.png");
		instruccion2 = loadImage("Imagenes/Instruccion_2.png");
		instruccion3 = loadImage("Imagenes/Instruccion_3.png");
		instruccion4 = loadImage("Imagenes/Instruccion_4.png");
		instruccion5 = loadImage("Imagenes/Instruccion_5.png");
		instruccion6 = loadImage("Imagenes/Instruccion_6.png");
		instruccion7 = loadImage("Imagenes/Instruccion_7.png");
		instruccion8 = loadImage("Imagenes/Instruccion_8.png");
		instruccion9 = loadImage("Imagenes/Instruccion_9.png");
		resumen1 = loadImage("Imagenes/Resumen_1.png");
		resumen2 = loadImage("Imagenes/Resumen_2.png");
		juego1 = loadImage("Imagenes/Juego_1.png");
		fighterImage = loadImage("Imagenes/Fighter.png");
		interceptorImage = loadImage("Imagenes/Interceptor.png");
		xwingImage = loadImage("Imagenes/Xwing.png");
		disparoImage = loadImage("Imagenes/Disparo.png");

		pantalla = 9;

		xwing = new NavePrincipal(638, 690, 87, this, 30, false, xwingImage);
		disparo = new Disparo(638, 690, 7, 29, 4, this, disparoImage);
		fighter = new Fighter(200, 200, 69, 3, this, 1, fighterImage);
		interceptor = new Interceptor(300, 300, 69, 3, this, 2, interceptorImage);

		for (int i = 0; i < 10; i++) {
			enemigos[i] = new ArrayList<NaveEnemiga>();
		}

		for (int i = 0; i < 10; i++) {
			enemigos[i].add(new Fighter(150 + (120 * i), 150, 69, 3, this, 1, fighterImage));
			enemigos[i].add(new Fighter(150 + (120 * i), 150 + (69 + 50), 69, 3, this, 1, fighterImage));
		}

	}

	public void draw() {

		background(255);

		switch (pantalla) {

		case 0:
			image(inicio1, 0, 0);
			if (620 < mouseX && mouseX < 746 && 547 < mouseY && mouseY < 610) {
				image(inicio2, 0, 0);
			}
			break;

		case 1:
			image(instruccion1, 0, 0);

			break;

		case 2:
			image(instruccion2, 0, 0);

			break;

		case 3:
			image(instruccion3, 0, 0);

			break;

		case 4:
			image(instruccion4, 0, 0);

			break;

		case 5:
			image(instruccion5, 0, 0);

			break;

		case 6:
			image(instruccion6, 0, 0);

			break;

		case 7:
			image(instruccion7, 0, 0);

			break;

		case 8:
			image(instruccion8, 0, 0);
			if (533 < mouseX && mouseX < 831 && 674 < mouseY && mouseY < 738) {
				image(instruccion9, 0, 0);
			}
			break;

		case 9:
			image(juego1, 0, 0);
			xwing.pintar();
			disparo.pintarDisparo();

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < enemigos[i].size(); j++) {
					enemigos[i].get(j).pintar();
				}
			}

			movEnemigos();

			if (xwing.isDisparando() == true) {
				disparo.movDisparo();
			}
			if (disparo.getPosY() <= 80) {
				reiniciarDisparo();
			}

			break;

		case 10:
			image(resumen1, 0, 0);
			if (1049 < mouseX && mouseX < 1255 && 655 < mouseY && mouseY < 718) {
				image(resumen2, 0, 0);
			}
			break;

		}
		text("x:" + mouseX + "y:" + mouseY, mouseX, mouseY);

	}

	public void mousePressed() {

		switch (pantalla) {

		case 0:
			image(inicio1, 0, 0);
			if (620 < mouseX && mouseX < 746 && 547 < mouseY && mouseY < 610) {
				pantalla = 1;
			}
			break;

		case 1:
			image(instruccion1, 0, 0);
			pantalla = 2;

			break;

		case 2:
			image(instruccion2, 0, 0);
			pantalla = 3;

			break;

		case 3:
			image(instruccion3, 0, 0);
			pantalla = 4;

			break;

		case 4:
			image(instruccion4, 0, 0);
			pantalla = 5;

			break;

		case 5:
			image(instruccion5, 0, 0);
			pantalla = 6;

			break;

		case 6:
			image(instruccion6, 0, 0);
			pantalla = 7;

			break;

		case 7:
			image(instruccion7, 0, 0);
			pantalla = 8;

			break;

		case 8:
			image(instruccion8, 0, 0);
			if (533 < mouseX && mouseX < 831 && 674 < mouseY && mouseY < 738) {
				pantalla = 9;
			}
			break;

		}

	}

	public void keyPressed() {

		switch (pantalla) {

		case 9:
			if (key == CODED) {
				if (keyCode == LEFT) {
					xwing.movIzq();
					if (xwing.isDisparando() == false) {
						disparo.setPosX(xwing.getPosX());
					}
					// System.out.println("si");
				}
				if (keyCode == RIGHT) {
					xwing.movDer();
					if (xwing.isDisparando() == false) {
						disparo.setPosX(xwing.getPosX());
					}
				}

			}

			if (key == 32 && xwing.isDisparando() == false) {
				xwing.disparar();
			}

			break;
		}

	}

	public void reiniciarDisparo() {
		if (xwing.isDisparando() == true) {
			xwing.setDisparando(false);
			disparo.setPosX(xwing.getPosX());
			disparo.setPosY(xwing.getPosY());
		}
	}

	public void movEnemigos() {
		if (millis() % 3000 == 0) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < enemigos[i].size(); j++) {
					enemigos[i].get(j).movNave();
				}
			}
		}
	}

}
