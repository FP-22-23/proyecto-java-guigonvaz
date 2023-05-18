package fp.serie;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import fp.utiles.Ficheros;

public class FactoriaSerie {

    // Método que recibe una cadena con el formato de las líneas del fichero CSV y devuelve un objeto Serie
    public static Serie leeSerie(String linea) 
    	throws Exception {
        String[] campos = linea.split(";");
        if (campos.length != 7) {
            throw new Exception("Error de formato en la línea: " + linea);
        }
        String titulo = campos[0];
        Integer year = Integer.parseInt(campos[1]);
        String edadRecomendada = campos[2];
        Double nota = Double.parseDouble(campos[3]);
        Boolean netflix = parseaBoolean(campos[4]);
        Boolean prime = parseaBoolean(campos[5]);
        LocalDate fEstreno = LocalDate.parse(campos[6], DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return new Serie(titulo, year, edadRecomendada, fEstreno, nota, netflix, prime);
    }

    // Método que recibe una cadena con el nombre y ruta del fichero CSV, y devuelve una lista de objetos Serie
    public static List<Serie> leeSeries(String fichero) 
    	throws Exception {
        String msg = String.format("Error leyendo %s", fichero);
        List<String> lineas = Ficheros.leeFichero(msg, fichero);
        List<Serie> series = new ArrayList<>();
        lineas.remove(0);
        for (String linea : lineas) {
            Serie serie = leeSerie(linea);
            series.add(serie);
        }

        return series;
    }
    
    public static VideoClub crearVideoClubDesdeArchivo(String fichero) 
    	throws Exception {
        List<Serie> series = leeSeries(fichero);
        return new VideoClub(series.stream());
    }
    
    private static boolean parseaBoolean(String cad) {
        Boolean res = false;
        if (cad.equals("Y")) {
        	res = true;
        }
        return res;
    }
 
}