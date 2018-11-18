package Graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import Control.Raton;
import Control.Teclado;
import Estados.GestorControles;
import Estados.GestorEstados;

public class SuperficieDibujo extends Canvas {

	private static final long serialVersionUID = -6227038142688953660L;

	private int ancho;
	private int alto;

	private Raton raton;

	public SuperficieDibujo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		this.raton = new Raton();

		setIgnoreRepaint(true);
		setCursor(raton.getCursor());
		setPreferredSize(new Dimension(ancho, alto));
		addKeyListener(GestorControles.teclado);
		setFocusable(true);
		requestFocus();
	}

	public void dibujar(final GestorEstados ge) {
		BufferStrategy buffer = getBufferStrategy();

		if (buffer == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = buffer.getDrawGraphics();

		g.fillRect(0, 0, ancho, alto);

		ge.dibujar(g);

		Toolkit.getDefaultToolkit().sync();

		g.dispose();

		buffer.show();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
