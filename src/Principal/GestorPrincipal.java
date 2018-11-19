package Principal;

import Estados.GestorControles;
import Estados.GestorEstados;
import Graficos.SuperficieDibujo;
import Graficos.Ventana;
import Utiles.Constantes;

public class GestorPrincipal {

	private boolean enFuncionamiento = false;
	private String titulo;
	private int ancho;
	private int alto;

	private SuperficieDibujo sd;
	private Ventana ventana;
	private GestorEstados ge;

	private GestorPrincipal(String titulo, final int ancho, final int alto) {
		this.titulo = titulo;
		this.ancho = ancho;
		this.alto = alto;
	}

	public static void main(String[] args) {
		GestorPrincipal gp = new GestorPrincipal("JUEGO", Constantes.anchoPantalla, Constantes.altoPantalla);

		gp.iniciarJuego();
		gp.iniciarBuclePrincipal();
	}

	private void iniciarJuego() {
		enFuncionamiento = true;
		inicializarJuego();
	}

	private void inicializarJuego() {
		sd = new SuperficieDibujo(ancho, alto);
		ventana = new Ventana("Juego", sd);
		ge = new GestorEstados();
	}

	private void iniciarBuclePrincipal() {
		int aps = 0;
		int fps = 0;

		final int NS_POR_SEGUNDO = 1000000000;
		final int APS_OBJECTIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJECTIVO;

		long referenciaActualizacon = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0;

		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime();
			tiempoTranscurrido = inicioBucle - referenciaActualizacon;
			referenciaActualizacon = inicioBucle;
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				aps++;
				Constantes.APS = aps;
				delta--;
			}

			dibujar();
			fps++;

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				System.out.println("FPS: " + fps + " APS: " + aps);
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}

	private void actualizar() {
		GestorControles.teclado.actualizar();
		ge.actualizar();
	}

	private void dibujar() {
		sd.dibujar(ge);
	}

}
