package fp.serie.test;

import java.time.LocalDate;

import fp.serie.Serie;
import fp.serie.FactoriaSerie;

public class SerieTest {
	
	public static void main(String[] args) {
		SerieDeseada n = new SerieDeseada(4.0);
		System.out.println(n);
		
		//Constructores
		Serie s1 = new Serie ("The Irishman",2019, "18", LocalDate.of(2019, 10, 26), 
				"Y", "N", 1.77);
		System.out.println(s1);
		Serie s2 = new Serie("Dangal", 9.86);
		System.out.println(s2);
		
		System.out.println(s1.getTitulo());
		s1.setTitulo("David Attenborough: A Life on Our Planet");
		System.out.println(s1.getTitulo());
		System.out.println(s1.getYear());
		s1.setYear(2000);
		System.out.println(s1.getYear());
		System.out.println(s1.getEdadRecomendada());
		s1.setEdadRecomendada("");
		System.out.println(s1.getEdadRecomendada());
		System.out.println(s2.getfEstreno());
		s2.setfEstreno(LocalDate.of(2014, 1, 30));
		System.out.println(s2.getfEstreno());
		System.out.println(s2.getNetflix());
		s2.setNetflix(true);
		System.out.println(s2.getNetflix());
		System.out.println(s1.getPrime());
		s1.setPrime(true);
		System.out.println(s1.getPrime());
		System.out.println(s1.getNota());
		s1.setNota(9.8);
		System.out.println(s1.getNota());;
		
		System.out.println(s1.toString());
		System.out.println(serieBuena(s1, n));
		
		System.out.println(s1.getSeries());
		s1.incorporaSerie("Okja");
		System.out.println(s1.getSeries());
		
		leeSeries("../data/Datos.csv");
	}

	public static Boolean serieBuena(Serie s, SerieDeseada n  ) {
		Boolean res = false;
		if (s.getNota()>= n.nota() && (s.parseaBoolean(s.getNetflix())==n.netflix())) {
			res= true;
		}
		return res;
	}
}
