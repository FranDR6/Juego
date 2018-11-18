package Estados;

import java.awt.Graphics;

import Entes.Jugador;
import Mapa.Mapa;
import Utiles.Constantes;

public class GestorJuego implements EstadoJuego {

	Jugador jugador = new Jugador(200, 200);

	Mapa mapaUno = new Mapa(Constantes.mapa1);

	public void actualizar() {
		if (GestorControles.teclado.isArriba()) {
			jugador.setPosicionY(jugador.getPosicionY() - 1);
		}
		if (GestorControles.teclado.isAbajo()) {
			jugador.setPosicionY(jugador.getPosicionY() + 1);
		}
		if (GestorControles.teclado.isIzquierda()) {
			jugador.setPosicionX(jugador.getPosicionX() - 1);
		}
		if (GestorControles.teclado.isDerecha()) {
			jugador.setPosicionX(jugador.getPosicionX() + 1);
		}
	}

	public void dibujar(Graphics g) {
		mapaUno.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
		jugador.dibujar(g);

	}

}
