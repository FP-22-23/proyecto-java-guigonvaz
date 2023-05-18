package fp.serie;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import fp.utiles.Checkers;



public class Serie {
	
	private String titulo;
	private Integer year;
	private String edadRecomendada;
	private LocalDate fEstreno;
	private Double nota;
	private Boolean netflix;
	private Boolean prime;
	private List<String> series;
	
	//Constructores
	public Serie(String titulo, Integer year, String edadRecomendada, LocalDate fEstreno, 
			 Double nota, Boolean netflix, Boolean prime) {
		Checkers.check("Nombre de título no válido",titulo != null );
		this.titulo = titulo;
		this.year = year;
		this.edadRecomendada = edadRecomendada;
		this.fEstreno = fEstreno;
		Checkers.check("Error en la nota", nota>=0.0 && nota <=10.0);
		this.nota = nota;
		this.netflix = netflix;
		this.prime = prime;
		series = new LinkedList<String>();
	}
	
	public Serie(String titulo, Double nota) {
		Checkers.check("Nombre de título no válido",titulo != null );
		this.titulo = titulo;
		Checkers.check("Error en la nota", nota>=0.0 && nota <=10.0);
		this.nota = nota;
		this.netflix = false;
		this.prime = false;
		series = new LinkedList<String>();
	}

	//Getters y setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		Checkers.check("Nombre de título no válido",titulo != null );
		this.titulo = titulo;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	public LocalDate getFEstreno() {
		return fEstreno;
	}

	public void setfEstreno(LocalDate fEstreno) {
		this.fEstreno = fEstreno;
	}

	
	public String getNetflix() {
		return "La serie está en netflix :"+netflix;
	}

	public Boolean setNetflix(Boolean netflix) {
		return netflix;
	}

	public String  getPrime() {
		return "La serie está en prime video :"+ prime;
	}

	public void setPrime(Boolean prime) {
		this.prime = prime;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		Checkers.check("Error en la nota", nota>=0.0 && nota <=10.0);
		this.nota = nota;
	}

	
	public Age getTipoAge() {
		Age res = Age.NO_ESPECIFICA;
		if (getEdadRecomendada()=="all") {
			res = Age.ALL;
		}
		if (getEdadRecomendada()=="7") {
			res = Age.SIETE;
		}
		if (getEdadRecomendada()=="13") {
			res = Age.TRECE;
		}
		if (getEdadRecomendada()=="16") {
			res = Age.DIECISEIS;
		}
		if (getEdadRecomendada()=="18") {
			res = Age.DIECIOCHO;
		}
		return res;
	}
	
	//Otros métodos
	
	public String toString() {
		return "Serie ["+titulo+", " + year + ", " + getTipoAge() + ", "+ 
				fEstreno + ", " + nota + ", netflix=" + netflix + ", prime=" + prime + "]";
	}
	
	public void incorporaSerie(String s) {
		if(!series.contains(s)) {
		series.add(s);
		}
	}
	
	public List<String> getSeries() {
		return series;
	}

	//Hash code
	public int hashCode() {
		return Objects.hash(fEstreno, nota, titulo, year);
	}
	
	//Criterio de igualdad
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(fEstreno, other.fEstreno) && Objects.equals(nota, other.nota)
				&& Objects.equals(titulo, other.titulo) && Objects.equals(year, other.year);
	}
	
	public int compareTo(Serie s) {
		int res = getTitulo().compareTo(s.getTitulo());
		if (res == 0) {
			res = getFEstreno().compareTo(s.getFEstreno());
		}
		return res;
	}
	
	public boolean parseaBoolean(String cad) {
        Boolean res = false;
        if (cad.equals("Y")) {
        	res = true;
        }
        return res;
    }	
}

