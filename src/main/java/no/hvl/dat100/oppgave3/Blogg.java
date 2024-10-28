package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	 private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (finnes(innlegg) || !ledigPlass()) {
			return false;
		}
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}
	
	public String toString() {
		String s = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			s += innleggtabell[i].toString();
		}
		return s;
	}
	

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nytabell = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nesteledig; i++) {
			nytabell[i] = innleggtabell[i];
		}
		innleggtabell = nytabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] == null) {
				innleggtabell[i] = innlegg;
				return true;
			}
		}return false;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				innleggtabell[i] = innleggtabell[nesteledig - 1];
				innleggtabell[nesteledig - 1] = null;
				nesteledig--;
				return true;
			}
		}return false;
	}
	
	public int[] search(String keyword) {
		
		int[] id = new int[nesteledig];
		int j = 0;

		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {
				id[j] = innleggtabell[i].getId();
				j++;
			}
		}
		return id;

	}
}