package is.gestioneappelli.entity;

import java.util.ArrayList;

public class Appello {
		protected ArrayList<Data> date = new ArrayList<>();
		protected boolean chiuso;
		protected ArrayList<Studente> studenti_prenotati = new ArrayList<>();
		public Appello() {
			chiuso= false;
			
		}
		public Appello(Data _d) {
			chiuso= false;
			date.add(_d);
		}
		public boolean getStato() {
			return chiuso;
		}
		public void addStudente(Studente s) {
			studenti_prenotati.add(s);
		}
		public void addData(Data _d) {
			date.add(_d);
		}
		public void setChiuso(boolean _stato) {
			chiuso = _stato;	
		}
		public boolean isAperto() {
			return (chiuso==false);
		}
		public ArrayList<Studente> getStudentiPrenotati(){
			return studenti_prenotati;
		}
		public ArrayList<Data> getDate(){
			return date;
		}
		public int getNumPartecipanti() {
			return studenti_prenotati.size();
		}
		public boolean ricercaStudente(Studente _s) {
			boolean find=false;
					if (studenti_prenotati.contains(_s)) {
						find=true;}
			return find;
		}
		public String toString()
		{
			StringBuffer buf = new StringBuffer();
			
			if(chiuso == false)
			{
				buf.append("\nSTATO APPELLO = APERTO\n");
			}
			else {
				buf.append("\nSTATO APPELLO = CHIUSO\n");
			}
			
			for(Data d : date)
			{
				buf.append("\nDATA = "+d.data+"\nSEDE = "+d.sede+"\nPROVA = "+d.tipo_prova+"\n");
			}
				return buf.toString();
			
		}
}
