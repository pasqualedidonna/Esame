package is.gestioneappelli.entity;

public class Docente {
	protected String nome;
	public Docente() {
		nome = new String();
	}
	public Docente(String _nome) {
		nome = new String(_nome);
	}
	public void setNome(String _nome) {
		nome = new String(_nome);
	}
	public String getNome() {
		return nome;
	}
	public String toString()
	{
		return (nome);
	}
}
