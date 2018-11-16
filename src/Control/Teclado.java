package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private final int NUMERO_TECLAS = 256;
	private final boolean[] teclas = new boolean[NUMERO_TECLAS];

	private boolean arriba;
	private boolean abajo;
	private boolean izquierda;
	private boolean derecha;

	private boolean correr;

	private boolean salir;

	public void actualizar() {
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		izquierda = teclas[KeyEvent.VK_A];
		derecha = teclas[KeyEvent.VK_D];
		salir = teclas[KeyEvent.VK_ESCAPE];
		correr = teclas[KeyEvent.VK_SHIFT];
	}

	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;

	}

	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {

	}

	public boolean[] getTeclas() {
		return teclas;
	}

	public boolean isArriba() {
		return arriba;
	}

	public boolean isAbajo() {
		return abajo;
	}

	public boolean isIzquierda() {
		return izquierda;
	}

	public boolean isDerecha() {
		return derecha;
	}

	public boolean isCorrer() {
		return correr;
	}

	public boolean isSalir() {
		return salir;
	}

}
