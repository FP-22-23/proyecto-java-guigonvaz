package fp.common;

public record SerieDeseada(Double nota, Boolean netflix) {
	
	public SerieDeseada(Double nota) {
		this(nota,true);
	}
	
	
}