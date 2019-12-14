package is.gestioneappelli.entity;

public class Studente {
	protected String nome;
	protected String cognome;
	protected String matricola;
	protected int pin;
	
	public Studente() {
		nome ="";
		cognome = "";
		matricola ="N/A";
		pin=0;
	}
	public Studente(String _nome, String _cognome, String _matricola, int _pin) {
		nome = _nome;
		cognome = _cognome;
		matricola = _matricola;
		pin = _pin;
	}
	public void setNome(String _nome) {
		nome = _nome;
	}
	public void setCognome(String _cognome) {
		cognome = _cognome;
	}
	public void setMatricola(String _matricola) {
		matricola = _matricola;
	}
	public void setPin(int _pin) {
		pin = _pin;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getMatricola() {
		return matricola;
	}
	public int getPin() {
		return pin;
	}
	public String toString() {
		return "Studente:\nNome: "+nome+" \nCognome: "+cognome+"\nMatricola: "+matricola+"\n";
	}
	
}
