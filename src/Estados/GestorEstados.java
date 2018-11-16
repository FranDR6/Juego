package Estados;

import java.awt.Graphics;

public class GestorEstados {

	private EstadoJuego[] arrayEstados;

	private EstadoJuego estadoActual;

	public GestorEstados() {
		iniciarEstados();
		iniciaeEstadoActual();
	}

	private void iniciarEstados() {
		arrayEstados = new EstadoJuego[1];
		arrayEstados[0] = new GestorJuego();
	}

	private void iniciaeEstadoActual() {
		estadoActual = arrayEstados[0];
	}

	public void actualizar() {
		estadoActual.actualizar();
	}

	public void dibujar(final Graphics g) {
		estadoActual.dibujar(g);
	}

	public void cambiarEstadoActual(final int nuevoEstado) {
		estadoActual = arrayEstados[nuevoEstado];
	}

	public EstadoJuego obtenerEstadoActual() {
		return estadoActual;
	}
}
