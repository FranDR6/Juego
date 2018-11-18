package Entes;

import java.awt.Color;
import java.awt.Graphics;

import Sprite.Sprite;
import Utiles.Constantes;

public class Jugador {
	private double posicionX;
	private double posicionY;

	private Sprite sprite;

	public Jugador(double posicionX, double posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public void dibujar(Graphics g) {
		int centroX = Constantes.anchoPantalla / 2 - 32 / 2;
		int centroY = Constantes.altoPantalla / 2 - 32 / 2;

		g.setColor(Color.WHITE);
		g.fillRect(centroX, centroY, 32, 32);
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
