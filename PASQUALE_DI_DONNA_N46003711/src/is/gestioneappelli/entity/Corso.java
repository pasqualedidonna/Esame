package is.gestioneappelli.entity;

import java.util.*;

public class Corso {
	protected String nome_corso;
	protected int cfu;
	protected Docente d;
	protected ArrayList<Appello> lista_appelli= new ArrayList<>();
	
	public Corso() {
		 nome_corso="";
		 cfu=0;
		 d = new Docente();
	}
	public Corso(String _nome_corso, int _cfu, Docente _d) {
		nome_corso= new String(_nome_corso);
		cfu=_cfu;
		d = _d;
	}
	public void setNome(String _nome_corso) {
		nome_corso= _nome_corso;
	}
	public void setCfu(int _cfu) {
		cfu = _cfu;
	}
	public void setDocente(Docente _d) {
		d= _d;
	}
	public String getNome() {
		return nome_corso;
	}
	public int getCfu() {
		return cfu;
	}
	public Docente getDocente() {
		return d;
	}
	public void setAppello(Appello _a) {
		lista_appelli.add(_a);
	}
	public String toString() {
		return "\nCorso:\nNome corso: "+nome_corso+"\n"+"Numero Cfu: "+cfu+"\nDocente: "+d.getNome();
	}
	}
