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

		estadoAnimacion = 0;

		direccion = 0;

		hojaPersonaje = new HojaSprites(Constantes.personaje1, 64, false);

		imagenActual = hojaPersonaje.obtenerSprite(0, 0).getImagen();
	}

	public void dibujar(Graphics g) {
		int centroX = Constantes.anchoPantalla / 2 - 32 / 2;
		int centroY = Constantes.altoPantalla / 2 - 32 / 2;

		g.setColor(Color.RED);
		g.drawRect(centroX + 10, centroY + 4, 64 - 20, 64 - 8);
		g.drawImage(imagenActual, centroX, centroY, null);
	}

	public void actualizar() {

		if (GestorControles.teclado.isArriba() && !GestorControles.teclado.isIzquierda()
				&& !GestorControles.teclado.isDerecha()) {
			direccion = 0;
			animar(direccion);
			posicionY -= Constantes.velocidadPersonajeAndando;
		}

		if (GestorControles.teclado.isAbajo() && !GestorControles.teclado.isIzquierda()
				&& !GestorControles.teclado.isDerecha()) {
			direccion = 1;
			animar(direccion);
			posicionY += Constantes.velocidadPersonajeAndando;
		}

		if (GestorControles.teclado.isIzquierda() && !GestorControles.teclado.isAbajo()
				&& !GestorControles.teclado.isArriba()) {
			direccion = 2;
			animar(direccion);
			posicionX -= Constantes.velocidadPersonajeAndando;
		}

		if (GestorControles.teclado.isDerecha() && !GestorControles.teclado.isAbajo()
				&& !GestorControles.teclado.isArriba()) {
			direccion = 3;
			animar(direccion);
			posicionX += Constantes.velocidadPersonajeAndando;
		}

		if (GestorControles.teclado.isAbajo() && GestorControles.teclado.isIzquierda()) {
			direccion = 4;
			animar(direccion);
			posicionY += Constantes.velocidadPersonajeAndando;
			posicionX -= Constantes.velocidadPersonajeAndando;
		}

		if (GestorControles.teclado.isAbajo() && GestorControles.teclado.isDerecha()) {
			direccion = 5;
			animar(direccion);
			posicionY += Constantes.velocidadPersonajeAndando;
			posicionX += Constantes.velocidadPersonajeAndando;
		}

		if (GestorControles.teclado.isArriba() && GestorControles.teclado.isIzquierda()) {
			direccion = 6;
			animar(direccion);
			posicionY -= Constantes.velocidadPersonajeAndando;
			posicionX -= Constantes.velocidadPersonajeAndando;
		}

		if (GestorControles.teclado.isArriba() && GestorControles.teclado.isDerecha()) {
			direccion = 7;
			animar(direccion);
			posicionY -= Constantes.velocidadPersonajeAndando;
			posicionX += Constantes.velocidadPersonajeAndando;
		}

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
				estadoAnimacion = 0;
			}
			switch (direccion) {
			case 0:
				if (estadoAnimacion == 0) {
					estadoAnimacion++;
				}
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 1).getImagen();
				break;
			case 1:
				if (estadoAnimacion == 0) {
					estadoAnimacion++;
				}
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 0).getImagen();
				break;
			case 2:
				if (estadoAnimacion == 0) {
					estadoAnimacion++;
				}
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 2).getImagen();
				break;
			case 3:
				if (estadoAnimacion == 0) {
					estadoAnimacion++;
				}
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 3).getImagen();
				break;
			case 4:
				if (estadoAnimacion == 0) {
					estadoAnimacion++;
				}
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 4).getImagen();
				break;
			case 5:
				if (estadoAnimacion == 0) {
					estadoAnimacion++;
				}
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 5).getImagen();
				break;
			case 6:
				if (estadoAnimacion == 0) {
					estadoAnimacion++;
				}
				imagenActual = hojaPersonaje.obtenerSprite(estadoAnimacion, 6).getImagen();
				break;
			case 7:
				if (estadoAnimacion == 0) {
					estadoAnimacion++;
				}
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
