import java.util.ArrayList;
import java.util.List;

import fp.biblioteca.Libro;
import fp.biblioteca.LibroImpl;
import fp.utiles.Ficheros;

public class FactoriaSerie {

	public static List<Serie> leeSeries(String fichero){
		
		String msg = String.format("Error leyendo %s", fichero);
		List<String> lineas = Ficheros.leeFichero(msg, fichero);
		List<Serie> series = new ArrayList<Serie>();
		lineas.remove(0);
		for (String cad: lineas) {
			series.add(cad);
		}
		
		return series;
	}

	public static Serie leeSerie(String serie) {
        String[] cad = serie.trim().split("\\s*;\\s*");
        if (cad.length != 7) {
            throw new IllegalArgumentException("La cadena no tiene el formato adecuado.");
        }
        String titulo = cad[0];
        Integer year = Integer.parseInt(cad[1]);
        Integer edadRecomendada = Integer.parseInt(cad[2]);
        Double nota = Double.parseDouble(cad[3]);
        Boolean netflix = Boolean.parseBoolean(cad[4]);
        Boolean prime = Boolean.parseBoolean(cad[5]);
        LocalDate fEstreno = LocalDate(cad[6]);
        Serie serie = new Serie(titulo, year, edadRecomendada, nota, netflix, prime, fEstreno);
        return serie;
    }
}
