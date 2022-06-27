package com.JANA60.viaggi.model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Holiday 
{
	/*
	 * 	Nel progetto java-travel-agency, creare la classe Vacanza caratterizzata da:
		- destinazione
		- data inizio
		- data fine
		Quando viene creata una nuova Vacanza vanno effettuati dei controlli:
		- destinazione, data inizio e data fine non possono essere null
		- la data inizio non può essere già passata
		- la data fine non può essere prima della data inizio
		Se fallisce la validazione vanno sollevate opportune eccezioni
		La classe Vacanza espone un metodo per calcolare la durata della vacanza (in giorni, mesi, anni).
	 */
		
		private String destination, start, end;
		private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateFromStartString, dateFromEndString;
	
	public Holiday(String destination, String start, String end) throws NullPointerException, Exception {
		super();
		
		boolean validParameters=true;
		String eMessage= "I dati inseriti non sono validi.";
		
		dateFromStartString = LocalDate.parse(start, dateFormatter); //trasformo la stringa in un LocalDate
		dateFromEndString = LocalDate.parse(end, dateFormatter);
		
		try
		{
			hasValidDestination(destination);
		}
		catch (NullPointerException npe)
		{
			validParameters=false;
			eMessage+= "\n" + npe.getMessage();
		}
		
		
		try
		{
			hasValidStart(start);
		}
		catch(NullPointerException npe)
		{
			validParameters=false;
			eMessage+= "\n" + npe.getMessage();

		}
		catch (Exception e)
		{
			validParameters=false;
			eMessage+= "\n" + e.getMessage();
		}
		
		try
		{
			hasValidEnd(end);
		}
		catch (NullPointerException npe)
		{
			validParameters=false;
			eMessage+= "\n" + npe.getMessage();

		}
		catch (Exception e)
		{
			validParameters=false;
			eMessage+= "\n" + e.getMessage();

		}
		
		if (validParameters)
		{
			this.destination = destination;
			this.start = start;
			this.end = end;
		}
		else
		{
			throw new Exception(eMessage);
		}
		
		
	}
	
	private void hasValidStart(String start) throws NullPointerException, Exception{
		
		if(start.isBlank() || start==null)
			throw new NullPointerException("La data di inizio vacanza non può essere un campo vuoto");
		
	    if(dateFromStartString.isAfter(dateFromEndString))
	    	throw new Exception ("La data di inizio non può essere successiva alla data di fine vacanza");
		
		
		
	}

	private void hasValidEnd(String end) throws NullPointerException, Exception{
		
		if(end.isBlank() || end==null)
			throw new NullPointerException("La data di fine vacanza non può essere un campo vuoto");
	    
		if(dateFromEndString.isBefore(dateFromStartString))
	    	throw new Exception ("La data di fine non può essere successiva alla data di inizio vacanza");

		
	}

	private void hasValidDestination(String destination) throws NullPointerException{
		
		if(destination.isBlank() || destination==null)
			throw new NullPointerException("La destinazione deve avere un nome");
		
	}

	
	public Period getHolidayLength()
	{
		Period p = Period.between(dateFromStartString, dateFromEndString);
		
		return p;
		
	}
	
	public String toString()
	{
		return "La vacanza a " 				+
				destination					+
				" che inizierà il giorno "	+
				dateFromStartString 		+
				" e finirà il giorno " 		+
				dateFromEndString 			+
				" avrà una durata di " 		+
				getHolidayLength().getDays()+
				"giorni."					;
	}
	
	
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) throws NullPointerException {
		hasValidDestination( destination);
		this.destination = destination;
	}
	
	public String getStart() {
		return start;
	}
	
	public void setStart(String start) throws NullPointerException, Exception {
		hasValidStart(start);
		this.start = start;
	}
	
	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) throws NullPointerException, Exception {
		hasValidEnd(end);
		this.end = end;
	}
	
	
	
}
