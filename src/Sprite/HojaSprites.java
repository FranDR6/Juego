package Sprite;

import java.awt.image.BufferedImage;

import Utiles.CargadorRecursos;

public class HojaSprites {

	final private int anchoHojaPixeles;
	final private int altoHojaPiexeles;

	final private int anchoHojaSprites;
	final private int altoHojaSprites;

	final private int anchoSprites;
	final private int altoSprites;

	final private Sprite[] arraySprites;

	public HojaSprites(final String ruta, final int tamañoSprite, final boolean hojaOpaca) {
		final BufferedImage imagen;

		if (hojaOpaca) {
			imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
		} else {
			imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
		}

		anchoHojaPixeles = imagen.getWidth();
		altoHojaPiexeles = imagen.getHeight();
//		System.out.println(anchoHojaPixeles + " " + altoHojaPiexeles);

		anchoHojaSprites = anchoHojaPixeles / tamañoSprite;
		altoHojaSprites = altoHojaPiexeles / tamañoSprite;
//		System.out.println(anchoHojaSprites + " " + altoHojaSprites);

		anchoSprites = tamañoSprite;
		altoSprites = tamañoSprite;

		arraySprites = new Sprite[anchoHojaSprites * altoHojaSprites];

		rellenarSpritesDesdeImagen(imagen);

	}

	public HojaSprites(final String ruta, final int anchoSprite, final int altoSprite, final boolean hojaOpaca) {
		final BufferedImage imagen;

		if (hojaOpaca) {
			imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
		} else {
			imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
		}

		anchoHojaPixeles = imagen.getWidth();
		altoHojaPiexeles = imagen.getHeight();

		anchoHojaSprites = anchoHojaPixeles / anchoSprite;
		altoHojaSprites = altoHojaPiexeles / altoSprite;

		this.anchoSprites = anchoSprite;
		this.altoSprites = altoSprite;

		arraySprites = new Sprite[anchoHojaSprites * altoHojaSprites];

		rellenarSpritesDesdeImagen(imagen);
	}

	private void rellenarSpritesDesdeImagen(final BufferedImage imagen) {
		for (int i = 0; i < anchoHojaSprites; i++) {
			for (int j = 0; j < altoHojaSprites; j++) {
				final int posicionX = i * anchoSprites;
				final int posicionY = j * altoSprites;

				arraySprites[i + j * anchoHojaSprites] = new Sprite(
						imagen.getSubimage(posicionX, posicionY, altoSprites, anchoSprites));
			}
		}
	}

	public Sprite obtenerSprite(final int indice) {
		return arraySprites[indice];
	}

	public Sprite obtenerSprite(final int x, final int y) {
		return arraySprites[x + y * anchoHojaSprites];
	}
}
