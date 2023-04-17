import java.util.ArrayList;
import serie.java;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import fp.biblioteca.Libro;

public class VideoClub {
    private String titulo;
    private Integer year;
    private ArrayList<String> generos;
    private Double nota;

    public VideoClub(String titulo, Integer year) {
        this.titulo = titulo;
        this.year = year;
        this.generos = new ArrayList<>();
        this.nota = 0.0;
    }

    public VideoClub(String titulo, Integer year, ArrayList<String> generos, Double nota) {
        this.titulo = titulo;
        this.year = year;
        this.generos = new ArrayList<>(generos);
        this.nota = nota;
    }
    

    public int numeroElementos() {
        return generos.size();
    }

    public void addElemento(String genero) {
        generos.add(genero);
    }

    public void addElementos(ArrayList<String> generos) {
        this.generos.addAll(generos);
    }

    public void eliminarElemento(String genero) {
        generos.remove(genero);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoClub)) return false;
        VideoClub contenedor = (VideoClub) o;
        return Objects.equals(titulo, contenedor.titulo) &&
                Objects.equals(year, contenedor.year) &&
                Objects.equals(generos, contenedor.generos) &&
                Objects.equals(nota, contenedor.nota);
    }

    public int hashCode() {
        return Objects.hash(titulo, year, generos, nota);
    }

    public String toString() {
        return "VideoClub{ titulo='" + titulo +", year=" + year +", generos=" +generos+", nota=" + nota + "}";
    }
	    
	    public Boolean existe(String generoBuscado) {
	    	Boolean res = false;
	        for (String genero : generos) {
	            if (genero.equals(generoBuscado)) {
	                res = true;
	            }
	        }
	        return res;
	    }

	    public Double media() {
	        Integer sum = 0;
	        for (String genero : generos) {
	            sum += year;
	        }
	        return sum / generos.size();
	    }
	    
	    public List<VideoClub> seleccionarPorYear(int year) {
	        List<VideoClub> series = new ArrayList<>();
	        for (VideoClub video : this) {
	            if (video.year.equals(year)) {
	                series.add(video);
	            }
	        }
	        return series;
	    }
	    
	    public Map<Integer, List<VideoClub>> agruparPorYear() {
	        Map<Integer, List<VideoClub>> res = new HashMap<>();
	        for (VideoClub serie : this) {
	            Integer clave = serie.year;
	            List<VideoClub> lista = map.get(year);
	            if(res.containsKey(clave)) {
					res.get(clave).add(serie);
	            }
	            else {
					List<VideoClub> lista = new ArrayList<>();
					lista.add(serie);
					res.put(clave, lista);
				}
	            return res;
		}
	        
        public Map<Double, Integer> seriesPorNota() {
            Map<Double, Integer> map = new HashMap<>();
            for (VideoClub video : this) {
                Double nota = video.nota;
                if (map.containsKey(nota)) {
                    map.put(nota, map.get(nota) + 1);
                } else {
                    map.put(nota, 1);
                }
            }
            return map;
        }
}
