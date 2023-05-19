package fp.serie.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import fp.serie.FactoriaSerie;
import fp.serie.Serie;
import fp.serie.VideoClub;
import fp.common.SerieDeseada;

public class SerieTest {
	
	public static void main(String[] args) {
		SerieDeseada n = new SerieDeseada(4.0);
		System.out.println(n);
		
		//Constructores
		Serie s1 = new Serie ("The Irishman",2019, "18", LocalDate.of(2019, 10, 26), 
				1.77, false, true);
		System.out.println(s1);
		Serie s2 = new Serie("Dangal", 9.86);
		System.out.println(s2);
		
		//Getters y Setters
		System.out.println(s1.getTitulo());
		s1.setTitulo("David Attenborough: A Life on Our Planet");
		System.out.println(s1.getTitulo());
		System.out.println(s1.getYear());
		s1.setYear(2000);
		System.out.println(s1.getYear());
		System.out.println(s1.getEdadRecomendada());
		s1.setEdadRecomendada("");
		System.out.println(s1.getEdadRecomendada());
		System.out.println(s2.getFEstreno());
		s2.setfEstreno(LocalDate.of(2014, 1, 30));
		System.out.println(s2.getFEstreno());
		System.out.println("La serie está en Netflix: "+s2.getNetflix());
		s2.setNetflix(true);
		System.out.println("La serie está en Netflix: "+s2.getNetflix());
		System.out.println("La serie está en Prime: "+s1.getPrime());
		s1.setPrime(true);
		System.out.println("La serie está en Prime: "+s1.getPrime());
		System.out.println("La nota es" + s1.getNota());
		s1.setNota(9.8);
		System.out.println("La nota es" +s1.getNota());;
		
		//To String
		System.out.println(s1.toString());
		System.out.println("¿La serie es buena?:" +serieBuena(s1, n));
		
		System.out.println(s1.getSeries());
		s1.incorporaSerie("Okja");
		System.out.println(s1.getSeries());
		
		//Lee las Series del CSV
		
		
		try {
			List<Serie> series = FactoriaSerie.leeSeries("./data/Datos.csv");
			if (series.isEmpty()) {
	               throw new IllegalArgumentException("El fichero de series está vacío");
	            }
			 System.out.println(series);
			 
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al leer el fichero", e);
        }
		
		//Constructores de VideoClub
		VideoClub videoClub1 = new VideoClub("The Irishman", 2019, 1.77);
        System.out.println("VideoClub1: "+videoClub1);

        Serie serie1 = new Serie("Dangal", 2016, "7",LocalDate.of(2014, 1, 30), 9.86, false, true);
        Serie serie2 = new Serie("Okja", 2017, "16",LocalDate.of(2014, 1, 30), 8.5, true, true);

        Collection<Serie> series = Arrays.asList(serie1, serie2);
        VideoClub videoClub2 = new VideoClub("Video Club 2", 2022, 9.0, series);
        System.out.println("VideoClub2: "+videoClub2);
		
        VideoClub videoClub3 = new VideoClub(series.stream()) ;
        System.out.println("VideoClub3: "+videoClub3);
        // numeroSeries
        System.out.println("Número de series en VideoClub2: " + videoClub3.numeroSeries());

        // addSeries
        Serie serie3 = new Serie("X-Men", 2021, "16", LocalDate.of(2021, 1, 1), 7.5, true, false);
        videoClub3.addSeries(Arrays.asList(serie3));
        System.out.println("Número de series en VideoClub2 añadiendo 1: " + videoClub3.numeroSeries());

        // eliminarSerie
        videoClub3.eliminarSerie(serie1);
        System.out.println("Número de series en VideoClub2 eliminando 1: " + videoClub3.numeroSeries());

        // existeSerieBuscada
        videoClub3.addSeries(Arrays.asList(serie1));
        System.out.println("¿Existe la serie buscada?: " + videoClub3.existeSerieBuscada(serie2));
        System.out.println("¿Existe la serie buscada?: " + videoClub3.existeSerieBuscada(serie3));
       
        // notaMedia
        System.out.println("Nota media: " + videoClub3.notaMedia());

        // seleccionarSeriePorNota
        Double notaDeseada = 8.0;
        List<String> seriesSeleccionadas = videoClub3.seleccionarSeriePorNota(notaDeseada);
        System.out.println("Series que superan la nota "+ notaDeseada + ": " + seriesSeleccionadas);

        // agruparSeriesPorYear
        Map<Integer, List<Serie>> seriesAgrupadasPorYear = videoClub3.agruparSeriesPorYear();
        System.out.println("Series agrupadas por año: " + seriesAgrupadasPorYear);

        // numSeriesPorNota
        Map<Double, Integer> numSeriesPorNota = videoClub3.numSeriesPorNota();
        System.out.println("Número de series por nota: " + numSeriesPorNota);

        // existeSerieBuscada2
        System.out.println("¿Existe la serie buscada? " + videoClub3.existeSerieBuscada2(serie2));

        // notaMedia2
        System.out.println("Nota media: " + videoClub3.notaMedia2());

        // seleccionarSeriePorNota2
        List<String> seriesSeleccionadas2 = videoClub3.seleccionarSeriePorNota2(notaDeseada);
        System.out.println("Series que superan la nota deseada (" +seriesSeleccionadas2);
        
        // Selecciona serie mas vieja
        Serie serieMasVieja = videoClub3.getSerieMasVieja();
        System.out.println("Serie más vieja: " + serieMasVieja);

        // Test getNMejoresSeriesRecientesNetflix
        Integer n2 = 2; // Número de mejores series recientes en Netflix
        List<Serie> mejoresSeriesRecientesNetflix = videoClub3.getNMejoresSeriesRecientesNetflix(n2);
        System.out.println("Las " + n2 + " mejores series recientes en Netflix:"+ mejoresSeriesRecientesNetflix);

        // Test agruparSeriesPorYear2
        Map<Integer, List<Serie>> seriesAgrupadasPorYear2 = videoClub3.agruparSeriesPorYear2();
        System.out.println("Series agrupadas por año:"+ seriesAgrupadasPorYear2);
        
        // Test getTitulosPorNota
        Map<Double, List<String>> titulosPorNota = videoClub3.getTitulosPorNota();
        System.out.println("Títulos por nota:" +titulosPorNota);
        
        // Test getMejorSeriePorYear
        Map<Integer, Serie> mejorSeriePorYear = videoClub3.getMejorSeriePorYear();
        System.out.println("Mejor serie por año:"+ mejorSeriePorYear);
        
        // Test numSeriesPorNotaOrdenadas
        SortedMap<Double, Integer> numSeriesPorNotaOrdenadas = videoClub3.numSeriesPorNotaOrdenadas();
        System.out.println("Número de series por nota ordenadas:"+ numSeriesPorNotaOrdenadas);
        
        // Test notaMasRepetida
        Map<Double, Integer> notaMasRepetida = videoClub3.notaMasRepetida();
        System.out.println("Nota que más se repite:"+ notaMasRepetida);
	}

	public static Boolean serieBuena(Serie s, SerieDeseada n  ) {
		Boolean res = false;
		if (s.getNota()>= n.nota() && (s.getNetflix())==n.netflix()) {
			res= true;
		}
		return res;
	}
}