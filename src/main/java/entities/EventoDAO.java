package entities;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import utils.JpaUtil;

public class EventoDAO {

	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();	
	
	private static final EntityTransaction t = em.getTransaction();
	
	//-----------------------------INSERIMENTO o SAVE
	
	public void insertEvento(String titolo,String dataEvento,String descrizione, 
			TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
		
		try {
			Evento e = new Evento();
			e.setTitolo(titolo);
			e.setDataEvento(dataEvento);
			e.setDescrizione(descrizione);
			e.setTipoEvento(tipoEvento);
			e.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
			
			t.begin();
			em.persist(e);
			t.commit();
			
			System.out.println("Evento inserito corettamente");
			
			
		}catch (Exception e){
			System.out.println("Errore inserimento evento");
		}
		
	}
	
	
//--------------------------------------------------GET ID	
public static void getEventoById(int id) {
        
        Evento e = em.find(Evento.class, id);
        
        if( e == null ) {
            System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
            return;
        }
        
        System.out.println( "Dati evento #" + id );
        System.out.printf(  
            "Titolo: %s | Data evento: %s | Descrizione: %s | Tipo evento: %s | Numero massimo partecipanti: %d",
            e.getTitolo(), e.getDataEvento(), e.getDescrizione(), e.getTipoEvento(), e.getNumeroMassimoPartecipanti()
        );
}

//--------------------------------------------REFRESH/UPDATE
public static void updateEventoById(int id, String titolo,String dataEvento,String descrizione, 
		TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
	Evento e = getEvento(id);
	if( e == null ) return;
	
	try {
		e.setTitolo(titolo);
		e.setDataEvento(dataEvento);
		e.setDescrizione(descrizione);
		e.setTipoEvento(tipoEvento);
		e.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
		
		t.begin();
		em.persist(e);
		t.commit();
	
		
		System.out.println("L'evento con l'id " + id + " è stato aggiornato!");
	}
	catch(Exception x) {
		System.out.println( "Errore nella modifica dell'evento!" );
	}
	
}

public static Evento getEvento(int id) {
	Evento e = em.find(Evento.class, id);
	
	if( e == null ) {
		System.out.println( "L'evento con l'id " + id + " non è stato trovato!" );
		return null;
	}
	
	return e;
}


//--------------------------------------------DELETE
	public static void deleteEventoById(int id) {
		Evento e = em.find(Evento.class, id);
		
		if( e == null ) {
			System.out.println( "L'evento con " + id + " non è stato trovato!" );
			return;
		}
		
		t.begin();
		em.remove(e);
		t.commit();
		
		System.out.println( "L'evento con l'id " + id + " è stato eliminato!" );
	}
}
