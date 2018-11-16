package Sprite;

import java.awt.image.BufferedImage;

import Utiles.CargadorRecursos;

public class Sprite {

	private final BufferedImage imagen;

	private int ancho;
	private int alto;

	public Sprite(final BufferedImage imagen) {
		this.imagen = imagen;
		ancho = imagen.getWidth();
		alto = imagen.getHeight();
	}

	public Sprite(final String ruta) {
		this.imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
		ancho = imagen.getWidth();
		alto = imagen.getHeight();
	}

	public BufferedImage getImagen() {
		return imagen;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
