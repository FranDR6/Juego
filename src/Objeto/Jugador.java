package Objeto;

import java.awt.Color;
import java.awt.Graphics;

import Sprite.Sprite;

public class Jugador {

	private double posicionX;
	private double posicionY;

	private Sprite sprite;

	public Jugador(double posicionX, double posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	public void dibujar(Graphics g) {
		
		g.setColor(Color.WHITE);
		
	}
}
