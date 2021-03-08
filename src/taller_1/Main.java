package taller_1;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	PImage inicio1, inicio2, instruccion1, instruccion2, instruccion3, instruccion4, instruccion5, instruccion6,
			instruccion7, instruccion8, instruccion9, resumen1, resumen2, juego1, fighter, interceptor, xwing, disparo;

	int pantalla;

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
		fighter = loadImage("Imagenes/Fighter.png");
		interceptor = loadImage("Imagenes/Interceptor.png");
		xwing = loadImage("Imagenes/Xwing.png");
		disparo = loadImage("Imagenes/Disparo.png");

		pantalla = 0;

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

			break;

		case 10:
			image(resumen1, 0, 0);
			if (1049 < mouseX && mouseX < 1255 && 655 < mouseY && mouseY < 718) {
				image(resumen2, 0, 0);
			}

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
				pantalla = 9 ;
			}
			break;
			
		}
	}
}
