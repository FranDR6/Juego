package Mapa;

import java.awt.Graphics;

import Sprite.Sprite;

public class Mapa {

	private Sprite imgMapa;

	public Mapa(final String ruta) {
		this.imgMapa = new Sprite(ruta);
	}

	public void dibujar(Graphics g) {
		g.drawImage(imgMapa.getImagen(), 0, 0, null);
	}
}