package Entes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Estados.GestorControles;
import Sprite.HojaSprites;
import Utiles.Constantes;

public class Jugador {
	private double posicionX;
	private double posicionY;

	private int estadoAnimacion;

	private boolean enMovimiento = false;

	private int direccion;

	private HojaSprites hojaPersonaje;

	private BufferedImage imagenActual;

	public Jugador(double posicionX, double posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;

		estadoAnimacion = 1;

		direccion = 0;

		hojaPersonaje = new HojaSprites(Constantes.personaje1, 64, false);

		imagenActual = hojaPersonaje.obtenerSprite(0, 0).getImagen();
	}

	public void dibujar(Graphics g) {
		int centroX = Constantes.anchoPantalla / 2 - 32 / 2;
		int centroY = Constantes.altoPantalla / 2 - 32 / 2;

		g.setColor(Color.RED);
//		g.drawRect(centroX + 10, centroY + 4, 64 - 20, 64 - 8);
		g.drawImage(imagenActual, centroX, centroY, null);
	}

	public void actualizar() {

		// Norte
		if (GestorControles.teclado.isArriba() && !GestorControles.teclado.isIzquierda()
				&& !GestorControles.teclado.isDerecha() && !GestorControles.teclado.isAbajo()) {
			direccion = 0;
			posicionY -= Constantes.velocidadPersonajeAndando;
		}
		// Sur
		if (!GestorControles.teclado.isArriba() && !GestorControles.teclado.isIzquierda()
				&& !GestorControles.teclado.isDerecha() && GestorControles.teclado.isAbajo()) {
			direccion = 1;
			posicionY += Constantes.velocidadPersonajeAndando;
		}
		// Oeste
		if (!GestorControles.teclado.isArriba() && GestorControles.teclado.isIzquierda()
				&& !GestorControles.teclado.isDerecha() && !GestorControles.teclado.isAbajo()) {
			direccion = 2;
			posicionX -= Constantes.velocidadPersonajeAndando;
		}
		// Este
		if (!GestorControles.teclado.isArriba() && !GestorControles.teclado.isIzquierda()
				&& GestorControles.teclado.isDerecha() && !GestorControles.teclado.isAbajo()) {
			direccion = 3;
			posicionX += Constantes.velocidadPersonajeAndando;
		}
		// Suroeste
		if (!GestorControles.teclado.isArriba() && GestorControles.teclado.isIzquierda()
				&& !GestorControles.teclado.isDerecha() && GestorControles.teclado.isAbajo()) {
			direccion = 4;
			posicionY += Constantes.velocidadPersonajeAndando;
			posicionX -= Constantes.velocidadPersonajeAndando;
		}
		// Sureste
		if (!GestorControles.teclado.isArriba() && !GestorControles.teclado.isIzquierda()
				&& GestorControles.teclado.isDerecha() && GestorControles.teclado.isAbajo()) {
			direccion = 5;
			posicionY += Constantes.velocidadPersonajeAndando;
			posicionX += Constantes.velocidadPersonajeAndando;
		}
		// Noroeste
		if (GestorControles.teclado.isArriba() && GestorControles.teclado.isIzquierda()
				&& !GestorControles.teclado.isDerecha() && !GestorControles.teclado.isAbajo()) {
			direccion = 6;
			posicionY -= Constantes.velocidadPersonajeAndando;
			posicionX -= Constantes.velocidadPersonajeAndando;
		}
		// Noreste
		if (GestorControles.teclado.isArriba() && !GestorControles.teclado.isIzquierda()
				&& GestorControles.teclado.isDerecha() && !GestorControles.teclado.isAbajo()) {
			direccion = 7;
			posicionY -= Constantes.velocidadPersonajeAndando;
			posicionX += Constantes.velocidadPersonajeAndando;
		}

		animar(direccion);

		if (GestorControles.teclado.isArriba() || GestorControles.teclado.isAbajo()
				|| GestorControles.teclado.isIzquierda() || GestorControles.teclado.isDerecha()) {
			enMovimiento = true;

		} else {
			enMovimiento = false;
		}

		if (!enMovimiento) {
			switch (direccion) {
			case 0:
				imagenActual = hojaPersonaje.obtenerSprite(0, 1).getImagen();
				break;
			case 1:
				imagenActual = hojaPersonaje.obtenerSprite(0, 0).getImagen();
				break;
			case 2:
				imagenActual = hojaPersonaje.obtenerSprite(0, 2).getImagen();
				break;
			case 3:
				imagenActual = hojaPersonaje.obtenerSprite(0, 3).getImagen();
				break;
			case 4:
				imagenActual = hojaPersonaje.obtenerSprite(0, 4).getImagen();
				break;
			case 5:
				imagenActual = hojaPersonaje.obtenerSprite(0, 5).getImagen();
				break;
			case 6:
				imagenActual = hojaPersonaje.obtenerSprite(0, 6).getImagen();
				break;
			case 7:
				imagenActual = hojaPersonaje.obtenerSprite(0, 7).getImagen();
				break;
			}
		}
	}

	private void animar(int direccion) {
		int frecuenciaAnimacion = 8;
		int limiteEstados = 7;

		if (Constantes.APS % frecuenciaAnimacion == 0) {
			estadoAnimacion++;
			if (estadoAnimacion >= limiteEstados) {
				estadoAnimacion = 1;
			}

			switch (direccion) {
			case 0:
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 1).getImagen();
				break;
			case 1:
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 0).getImagen();
				break;
			case 2:
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 2).getImagen();
				break;
			case 3:
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 3).getImagen();
				break;
			case 4:
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 4).getImagen();
				break;
			case 5:
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 5).getImagen();
				break;
			case 6:
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 6).getImagen();
				break;
			case 7:
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 7).getImagen();
				break;
			}
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
