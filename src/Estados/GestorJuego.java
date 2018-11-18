package Estados;

import java.awt.Graphics;

import Entes.Jugador;
import Mapa.Mapa;
import Utiles.Constantes;

public class GestorJuego implements EstadoJuego {

	Jugador jugador = new Jugador(200, 200);

	Mapa mapaUno = new Mapa(Constantes.mapa1);

	public void actualizar() {
		jugador.actualizar();
	}

	public void dibujar(Graphics g) {
		mapaUno.dibujar(g, (int) jugador.getPosicionX(), (int) jugador.getPosicionY());
		jugador.dibujar(g);

	}

}
