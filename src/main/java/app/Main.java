package app;

import entities.EventoDAO;
import entities.TipoEvento;

public class Main {
	

	public static void main(String[] args) {
		
		EventoDAO x = new EventoDAO();
		
		
		//x.insertEvento("Conferenza", "2023-06-16", "Lorem ipsuum", TipoEvento.PUBBLICO, 85 );
		//x.insertEvento("Matrimonio", "2023-09-24", "Lucia e Andrea", TipoEvento.PRIVATO, 200 );
		//x.insertEvento("Party", "2023-04-10", "Festa in piazza", TipoEvento.PUBBLICO, 5000);
		//x.insertEvento("Partita calcio", "2023-01-28", "Calcetto", TipoEvento.PRIVATO, 22 );
		//x.insertEvento("Fiera", "2023-09-08", "Salone Nautico", TipoEvento.PUBBLICO, 15000);*/
		
		
		//x.getEventoById(11);
		
		
		//x.deleteEventoById(11);
		
		x.updateEventoById(9, "Fiera", "2023-12-20", "Fiera di Pasqua", TipoEvento.PUBBLICO, 1000 );
		
		}

}
