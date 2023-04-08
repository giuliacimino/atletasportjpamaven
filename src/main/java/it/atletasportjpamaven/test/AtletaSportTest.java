package it.atletasportjpamaven.test;

import it.atletasportjpamaven.service.AtletaService;
import it.atletasportjpamaven.service.MyServiceFactory;
import it.atletasportjpamaven.service.SportService;

import java.time.LocalDate;
import java.util.List;

import it.atletasportjpamaven.dao.EntityManagerUtil;
import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;

public class AtletaSportTest {
	public static void main (String[] args) {
		AtletaService atletaServiceInstance = MyServiceFactory.getAtletaServiceInstance();
		SportService sportServiceInstance = MyServiceFactory.getSportServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			// inizializzo i ruoli sul db
			initSports(sportServiceInstance);
			
			System.out.println("in tabella Atleta ci sono "+atletaServiceInstance.listAll().size() + " elementi.");
			
			TestAggiornaAtleta(atletaServiceInstance);
			System.out.println("in tabella Atleta ci sono "+atletaServiceInstance.listAll().size() + " elementi.");

			TestInserisciNuovoAtleta(atletaServiceInstance);
			System.out.println("in tabella Atleta ci sono "+atletaServiceInstance.listAll().size() + " elementi.");

			
			
			
	
	} catch (Throwable e) {
		e.printStackTrace();
	} finally {
		// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
		// main
		EntityManagerUtil.shutdown();
	}

		
		
	}
	

	private static void initSports(SportService sportServiceInstance) throws Exception {
		if (sportServiceInstance.cercaPerDescrizione("Pallavolo") == null) {
			sportServiceInstance.inserisciNuovo(new Sport("Pallavolo"));
		}

		if (sportServiceInstance.cercaPerDescrizione("Calcio") == null) {
			sportServiceInstance.inserisciNuovo(new Sport("Calcio"));
			
		}
		if(sportServiceInstance.cercaPerDescrizione("Basket")== null) {
			sportServiceInstance.inserisciNuovo(new Sport("Basket"));
		}
		if (sportServiceInstance.cercaPerDescrizione("Tennis")==null) {
			sportServiceInstance.inserisciNuovo(new Sport("Tennis"));
		}
		
		
	}
	
	
	//
	private static void TestAggiornaAtleta (AtletaService atletaServiceInstance) throws Exception{
		System.out.println(".......testAggiornaAtleta inizio.......");
		List<Atleta> listaAtleti = atletaServiceInstance.listAll();
		if (listaAtleti.size() < 1)
			throw new RuntimeException("errori: non sono presenti atleti sul db.");
		Atleta atletaDaAggiornare = listaAtleti.get(0);
		String nuovoNome = "Marco";
		atletaDaAggiornare.setNome(nuovoNome);
		atletaServiceInstance.aggiornaAtleta(atletaDaAggiornare);
		System.out.println(atletaDaAggiornare);
		System.out.println(".......testAggiornaAtleta fine.......");
	}
	
	
	//
	private static void TestInserisciNuovoAtleta (AtletaService atletaServiceInstance) throws Exception{
		System.out.println(".......testInserisciNuovoAtleta inizio.............");

		Atleta atletaNuovo = new Atleta("Pippo", "Rossi", "pippo", LocalDate.of(2003, 07, 20), 2);
		atletaServiceInstance.inserisciNuovoAtleta(atletaNuovo);
		if (atletaNuovo.getId() == null)
			throw new RuntimeException("testInserisciNuovoAtleta fallito ");

		System.out.println(".......testInserisciNuovoAtleta fine.............\"");
	}
}
