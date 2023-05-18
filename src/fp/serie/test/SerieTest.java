package fp.serie.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
		System.out.println(s2.getNetflix());
		s2.setNetflix(true);
		System.out.println(s2.getNetflix());
		System.out.println(s1.getPrime());
		s1.setPrime(true);
		System.out.println(s1.getPrime());
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
        System.out.println(videoClub1);

        Serie serie1 = new Serie("Dangal", 2016, "7",LocalDate.of(2014, 1, 30), 9.86, false, true);
        Serie serie2 = new Serie("Okja", 2017, "16",LocalDate.of(2014, 1, 30), 8.5, true, true);

        Collection<Serie> series = Arrays.asList(serie1, serie2);
        VideoClub videoClub2 = new VideoClub("Video Club 2", 2022, 9.0, series);
        System.out.println(videoClub2);
		
	}

	public static Boolean serieBuena(Serie s, SerieDeseada n  ) {
		Boolean res = false;
		if (s.getNota()>= n.nota() && (s.parseaBoolean(s.getNetflix())==n.netflix())) {
			res= true;
		}
		return res;
	}
}