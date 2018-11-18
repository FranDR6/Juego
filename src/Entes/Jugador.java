package Entes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Estados.GestorControles;
import Sprite.HojaSprites;
import Sprite.Sprite;
import Utiles.Constantes;

public class Jugador {
	private double posicionX;
	private double posicionY;

	private String direccion;

	private HojaSprites hojaPersonaje;

	private BufferedImage imagenActual;

	public Jugador(double posicionX, double posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;

		direccion = "S";

		hojaPersonaje = new HojaSprites("/personaje/01.png", 52, true);

		imagenActual = hojaPersonaje.obtenerSprite(0,0).getImagen();
	}

	public void dibujar(Graphics g) {
		int centroX = Constantes.anchoPantalla / 2 - 32 / 2;
		int centroY = Constantes.altoPantalla / 2 - 32 / 2;

		g.drawImage(imagenActual, centroX, centroY, null);
	}

	public void actualizar() {
		if (GestorControles.teclado.isArriba()) {
			direccion = "N";
			animar();
			posicionY -= 1;
		}
		if (GestorControles.teclado.isAbajo()) {
			direccion = "S";
			animar();
			posicionY += 1;
		}
		if (GestorControles.teclado.isIzquierda()) {
			direccion = "O";
			animar();
			posicionX -= 1;
		}
		if (GestorControles.teclado.isDerecha()) {
			direccion = "E";
			animar();
			posicionX += 1;
		}
	}

	public void animar() {
		switch (direccion) {
		case "N":
			imagenActual = hojaPersonaje.obtenerSprite(1, 0).getImagen();
			break;
		case "S":
			imagenActual = hojaPersonaje.obtenerSprite(0, 0).getImagen();
			break;
		case "E":
			imagenActual = hojaPersonaje.obtenerSprite(3, 0).getImagen();
			break;
		case "O":
			imagenActual = hojaPersonaje.obtenerSprite(2, 0).getImagen();
			break;
		case "NO":
		case "NE":
		case "SE":
		case "SO":
		}
	}

	public void setPosicionX(double posicionX) {
		this.posicionX = posicionX;
	}

	public void setPosicionY(double posicionY) {
		this.posicionY = posicionY;
	}

	public double getPosicionX() {
		return posicionX;
	}

	public double getPosicionY() {
		return posicionY;
	}

}
