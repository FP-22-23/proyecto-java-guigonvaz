package fp.common;

public record SerieDeseada(Double nota, Boolean netflix) {
	
	private SerieDeseada(Double nota) {
		this(nota,true);
	}
	
	
}
