package fp.serie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VideoClub {
    private String titulo;
    private Integer year;
    private Double nota;
    private List<Serie> series;

    public VideoClub(String titulo, Integer year, Double nota) {
        this.titulo = titulo;
        this.year = year;
        this.nota = nota;
    }

    public VideoClub(String titulo, Integer year, Double nota, Collection<Serie> series) {
        this.titulo = titulo;
        this.year = year;
        this.nota = nota;
        this.series = new ArrayList<Serie>(series);
    }
    
    public VideoClub(Stream<Serie> serieStream) {
        List<Serie> serieList = serieStream.collect(Collectors.toList());
        if (serieList.isEmpty()) {
            throw new IllegalArgumentException("El stream de series no puede estar vacío.");
        }
        
        Serie firstSerie = serieList.get(0);
        this.titulo = firstSerie.getTitulo();
        this.year = firstSerie.getYear();
        this.nota = firstSerie.getNota();
        this.series = new ArrayList<>(serieList);
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoClub)) return false;
        VideoClub contenedor = (VideoClub) o;
        return Objects.equals(titulo, contenedor.titulo) &&
                Objects.equals(year, contenedor.year) &&
                Objects.equals(nota, contenedor.nota);
    }

    
    public int hashCode() {
        return Objects.hash(titulo, year, nota);
    }

    public String toString() {
        return "VideoClub{ titulo='" + titulo +", year=" + year +", nota=" + nota + "}";
    }
    
    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public int numeroElementos() {
        return series.size();
    }
	
    public void addElemento(Collection<Serie> elem) {
        series.addAll(elem);
    }


    public void eliminarElemento(Serie elem) {
        series.remove(elem);
    }

	//Nos dice si existe la serie que buscamos en series
    public Boolean existeSerieBuscada(Serie serieBuscada) {
    	Boolean res = false;
        for (Serie serie : series) {
            if (serie.equals(serieBuscada)) {
                res = true;
            }
        }
        return res;
    }	

    //Calcula la nota media de las series
    public Double notaMedia() {
        Double sum = 0.0;
        for (Serie serie : series) {
            sum += serie.getNota();
        }
        return (sum / series.size());
    }
    
    //Devuelvve una lista con los títulos de las series que superen la nota deseada
    public List<String> seleccionarSeriePorNota(Double nota) {
        List<String> n = new ArrayList<>();
    	for (Serie serie :series ) {
            if (serie.getNota()>nota) {
                n.add(serie.getTitulo());
            }
        }
        return n;
    }
    
    //Agrupa las series por años
    public Map<Integer, List<Serie>> agruparSeriesPorYear() {
        Map<Integer, List<Serie>> res = new HashMap<>();
        for (Serie serie : series) {
            Integer clave = serie.getYear();
            if(res.containsKey(clave)) {
				res.get(clave).add(serie);
            }
            else {
				List<Serie> lista = new ArrayList<>();
				lista.add(serie);
				res.put(clave, lista);
			}
        }
         return res;
	}
        
    //Agrupa las series por nota en un Map
    public Map<Double, Integer> numSeriesPorNota() {
        Map<Double, Integer> map = new HashMap<>();
        for (Serie serie : series) {
            Double nota = serie.getNota();
            if (map.containsKey(nota)) {
                map.put(nota, +1);
            } 
            else {
                map.put(nota, 1);
            }
        }
        return map;
    }
    
    /////Bloque 1////
    
    //Nos dice si existe la serie que buscamos en series
    public Boolean existeSerieBuscada2(Serie serieBuscada) {
        return series.stream().anyMatch(s -> s.equals(serieBuscada));
    }
    
    //Calcula la nota media de las series
    public Double notaMedia2() {
    	return series.stream()
    			.mapToDouble(s->s.getNota())
    			.average()
    			.orElse(0);
    }
    
    //Devuelvve una lista con los títulos de las series que superen la nota deseada
    public List<String> seleccionarSeriePorNota2(Double nota) {
    	return series.stream()
    			.filter(s->s.getNota()>nota)
    			.map(Serie::getTitulo)
                .collect(Collectors.toList());
    }
    
    //Devuelve la serie más vieja
    public Serie getSerieMasVieja() {
    	Comparator<Serie> c = Comparator.comparing(Serie::getYear);
    	return series.stream()
    			.min(c)
    			.get();
    }
    
    //Devuelve una lista con las n series con mejores notas en los últimos años que estén en Netflix
    public List<Serie> getNMejoresSeriesRecientesNetflix(Integer n) {
    	Comparator<Serie> y = Comparator.comparing(Serie::getYear);	
    	Comparator<Serie> m = Comparator.comparing(Serie::getNota);
    	return series.stream()
    		.filter(s->s.getNetflix().equals("Y"))
    		.sorted(y.reversed())
    		.sorted(m.reversed())
    		.limit(n)
    		.collect(Collectors.toList());
    	}
    
    
    //// Bloque 2 ////
    
    // 1. Agrupa las series por años
    public Map<Integer, List<Serie>> agruparSeriesPorYear2() {
    	return series.stream()
                .collect(Collectors.groupingBy(Serie::getYear));
    }
    
    // 2. Devuelve un Map que tiene como claves las notas y sus valores son listas formadas por los títulos de las series con dicha nota
    public Map<Double, List<String>> getTitulosPorNota(){
    	return series.stream()
    			.collect(Collectors.groupingBy(Serie::getNota
    					, Collectors.mapping(Serie::getTitulo, Collectors.toList())));
    }
    
    // 3. Serie con más nota por año
    Comparator<Serie> c = Comparator.comparingDouble(Serie::getNota);
    public Map<Integer, Serie> getMejorSeriePorYear(){
    	return series.stream()
    			.collect(Collectors.groupingBy(
    					Serie::getYear, Collectors.collectingAndThen(
    							Collectors.maxBy(c), Optional::get)));
    }
    
    // 4. Agrupa las notas de forma ordenada y tiene como valores las veces que aparece la nota
    public SortedMap<Double, Integer> numSeriesPorNotaOrdenadas(){
    	return numSeriesPorNota().entrySet()
    			.stream().sorted(Map.Entry.comparingByKey())
    			.collect(TreeMap::new, //Creamos un SortedMap vacío
                        (m, e) -> m.put(e.getKey(), e.getValue()), //Cada nueva pareja m recibe las claves y valores de e (parejas ya ordenadas) 
                        TreeMap::putAll // Lo metemos todo en el Map
                );
    }
    
    // 5. Devuelve un Map con la nota que más veces se repite
    public Map<Double, Integer> notaMasRepetida(){
    	Integer nRep = Collections.max(numSeriesPorNota().values()); //Obtenemos la nota que más se repite
    	return numSeriesPorNota().entrySet().stream()
    			.filter(s-> s.getValue().equals(nRep))
    			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }	
    
}
