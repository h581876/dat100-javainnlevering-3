package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Tekst extends Innlegg {

	protected String tekst; 
	
	public Tekst () {
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id, bruker, dato);
		this.tekst = tekst;
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.tekst = tekst;
	}
	
	public String getTekst() {
		return tekst;

	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return "TEKST\n" + super.toString() + tekst + "\n";

	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
			
		return "		<p>" + getId() + "@" + getBruker() + " " + getDato() + "<br>" +
		"		" + getLikes() + " liker dette</p><br>" + "		<p>" + tekst + "</p><br>";
				
	}
}
