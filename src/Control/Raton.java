package Control;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import Utiles.CargadorRecursos;
import Utiles.Constantes;

public class Raton {

	private final Cursor cursor;

	public Raton() {
		Toolkit configuracion = Toolkit.getDefaultToolkit();

		BufferedImage icono = CargadorRecursos.cargarImagenCompatibleTranslucida(Constantes.cursor);

		Point punta = new Point(0, 0);

		this.cursor = configuracion.createCustomCursor(icono, punta, "Cursor");
	}

	public Cursor getCursor() {
		return cursor;
	}

}
