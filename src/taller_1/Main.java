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
	boolean agregarNaves;

	int currentTime;
	int interval;
	int saveTime;
	int totalTime;

	int score;

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

		pantalla = 0;

		xwing = new NavePrincipal(638, 690, 87, this, 30, false, xwingImage);
		disparo = new Disparo(638, 690, 7, 29, 4, this, disparoImage);
		// fighter = new Fighter(200, 200, 69, 3, this, 1, fighterImage);
		// interceptor = new Interceptor(300, 300, 69, 3, this, 2, interceptorImage);

		for (int i = 0; i < 10; i++) {
			enemigos[i] = new ArrayList<NaveEnemiga>();
		}

		for (int i = 0; i < 10; i++) {
			enemigos[i].add(new Fighter(150 + (120 * i), 140 + (70 + 28), 70, 14, this, 1, fighterImage));
			enemigos[i].add(new Fighter(150 + (120 * i), 140, 70, 14, this, 1, fighterImage));

		}

		agregarNaves = true;

		currentTime = 0;
		interval = 1000;
		saveTime = millis();
		totalTime = 3000;

		score = 0;

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

			int menor = 0;
			int passedTime = millis() - saveTime;

			image(juego1, 0, 0);
			xwing.pintar();
			disparo.pintarDisparo();

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < enemigos[i].size(); j++) {
					enemigos[i].get(j).pintar();

				}
			}

			if (passedTime > totalTime) {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < enemigos[i].size(); j++) {
						enemigos[i].get(j).movNave();

					}
				}
				saveTime = millis();
				agregarNaves = false;
			}

			// System.out.println(mayor);
			for (int i = 0; i < 10; i++) {
				if (!enemigos[i].isEmpty() && enemigos[i].get(enemigos[i].size() - 1).getPosY() == 210) {
					menor = 210;
				}
			}

			if (menor == 210 && agregarNaves == false) {
				insertarFila();
			}
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < enemigos[i].size(); j++) {
					if (xwing.isDisparando() == true && choque(enemigos[i].get(j))) {
						if (enemigos[i].get(j).getVida() == 0) {
							enemigos[i].remove(j);
						}
						reiniciarDisparo();

					}

				}
			}

			if (xwing.isDisparando() == true) {
				disparo.movDisparo();
			}
			if (disparo.getPosY() <= 80) {
				reiniciarDisparo();
			}
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < enemigos[i].size(); j++) {
					if (checkLose(enemigos[i].get(j))) {
						pantalla = 10;
					}
				}
			}

			textSize(30);
			text("score: " + score, 50, 50);
			break;

		case 10:
			image(resumen1, 0, 0);
			if (1049 < mouseX && mouseX < 1255 && 655 < mouseY && mouseY < 718) {
				image(resumen2, 0, 0);

			}
			fill(0);
			textSize(60);
			text("score: " + score, 500, 364);

			break;

		}

		// text("x:" + mouseX + "y:" + mouseY, mouseX, mouseY);

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
			
		case 10:
			
			if (1049 < mouseX && mouseX < 1255 && 655 < mouseY && mouseY < 718) {
				exit();
				

			}
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

	public void insertarFila() {

		int R = (int) random(0, 10);

		for (int i = 0; i < 10; i++) {
			if (i == R && (enemigos[R].get(enemigos[R].size() - 1) instanceof Fighter || enemigos[R].isEmpty())) {
				enemigos[i].add(new Interceptor(150 + (120 * i), 112, 70, 14, this, 2, interceptorImage));
			}
			if (enemigos[i].isEmpty()) {
				enemigos[i].add(new Interceptor(150 + (120 * i), 112, 70, 14, this, 2, interceptorImage));

			} else if (enemigos[i].get(enemigos[i].size() - 1) instanceof Fighter) {
				enemigos[i].add(new Fighter(150 + (120 * i), 112, 70, 14, this, 1, fighterImage));
			} else if (enemigos[i].get(enemigos[i].size() - 1) instanceof Interceptor) {
				enemigos[i].add(new Interceptor(150 + (120 * i), 112, 70, 14, this, 2, interceptorImage));
			}

		}
		agregarNaves = true;
	}

	public boolean choque(NaveEnemiga nave) {
		boolean choque = false;

		if (disparo.getPosX() > nave.getPosX() && disparo.getPosX() < (nave.getPosX() + nave.getTam())) {
			if (disparo.getPosY() < (nave.getPosY() + nave.getTam())) {
				nave.setVida(nave.getVida() - 1);
				score++;
				choque = true;
			}
		}
		return choque;
	}

	public boolean checkLose(NaveEnemiga nave) {
		if (nave.getPosY() + nave.getTam() > xwing.getPosY()) {
			return true;

		} else {
			return false;
		}

	}
}
