package Estados;

import java.awt.Graphics;

import Mapa.Mapa;
import Utiles.Constantes;

public class GestorJuego implements EstadoJuego {

	Mapa mapaUno = new Mapa(Constantes.mapa1);

	public void actualizar() {

	}

	public void dibujar(Graphics g) {
		mapaUno.dibujar(g);
	}

}
