package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";


public static Blogg les(String mappe, String filnavn) {
    Blogg samling = null;
    try {
        BufferedReader leser = new BufferedReader(new FileReader(mappe + filnavn));
        int antallInnlegg = Integer.parseInt(leser.readLine());
        samling = new Blogg(antallInnlegg);

        for (int i = 0; i < antallInnlegg; i++) {
            String type = leser.readLine();
            int id = Integer.parseInt(leser.readLine());
            String bruker = leser.readLine();
            String dato = leser.readLine();
            int likes = Integer.parseInt(leser.readLine());

            if (type.equals(TEKST)) {
                String tekst = leser.readLine();
                Tekst innlegg = new Tekst(id, bruker, dato, likes, tekst);
                samling.leggTil(innlegg);
            } else if (type.equals(BILDE)) {
                String tekst = leser.readLine();
                String url = leser.readLine();
                Bilde innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
                samling.leggTil(innlegg);
            }
        }
        leser.close();
    } catch (IOException e) {
        System.out.println("Feil ved lesing av fil: " + e.getMessage());
    }
    return samling;
}


		

	}
