package com.JANA60.viaggi.controller.main;

import java.util.Scanner;

import com.JANA60.viaggi.model.entities.Holiday;

public class Agency {
	/*
	 * Aggiungere una classe Agenzia con metodo main, dove chiediamo all’operatore se vuole inserire una nuova vacanza o uscire. 
	 * Se vuole proseguire con l’inserimento va chiesta la destinazione, il giorno, mese e anno di partenza e il giorno, mese anno di ritorno.
		Con questi dati va generata una nuova vacanza e in console verrà stampato un messaggio del tipo:
		“Hai prenotato una vacanza di [durata della vacanza] a [destinazione] dal [data inizio formattata] al [data fine formattata]“.
		Se la creazione della vacanza genera un errore, il programma non deve interrompersi ma va gestito con dei messaggi di errore 
		che permettono all’utente di capire cosa è andato storto e di ripetere l’inserimento.
	 */
	public static Scanner keyboard = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
		String cmd;
		
		boolean end=false;
		
		System.out.println("Benvenuto nell'agenzia di viaggio");
		
		do
		{
			
			System.out.println("Vuole inserire un nuovo periodo di vacanza?");
			cmd= keyboard.nextLine();
			
			switch (cmd.toLowerCase())
			{
				case "si":
					_newHoliday();
				break;
				default:
					end=true;
			}
			
		}while(!end);
		
		System.out.println("Grazie e arrivederci");
		
		
		
		
		
	}

	private static void _newHoliday() 
	{
		try
		{
			System.out.println("Inserire destinazione:");
			String destination = keyboard.nextLine();
			
			System.out.println("Inserire data di partenza nel formato gg/mm/aaaa");
			String start = keyboard.nextLine();
			
			System.out.println("Inserire data di ritorno nel formato gg/mm/aaaa");
			String end = keyboard.nextLine();
			
			Holiday vacanza = new Holiday(destination, start, end);
			System.out.println(vacanza.toString());

		}
		catch (NullPointerException npe)
		{
			System.out.println("Parametro nullo: " + npe.getMessage());
		}
		catch (Exception e)
		{
			System.out.println("Errore imprevisto: " + e.getMessage());
		}
		
	}

}
