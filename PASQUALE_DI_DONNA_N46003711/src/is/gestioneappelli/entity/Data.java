package is.gestioneappelli.entity;
import java.time.*;
public class Data {
	protected LocalDate data;
	protected Sede sede;
	protected TipoProva tipo_prova;
	
	public Data(LocalDate _data,Sede _sede, TipoProva _tipo_prova) {
		data = _data;
		sede=_sede;
		tipo_prova=_tipo_prova;
	}
	public Sede getSede() {
		return sede;
	}
	public TipoProva getTipo() {
		return tipo_prova;
	}
	public void setData(LocalDate data) {
		this.data=data;
	}
	
	public LocalDate getData() {
		return this.data;
	}
	
}
