package it.atletasportjpamaven.test;

import it.atletasportjpamaven.service.AtletaService;
import it.atletasportjpamaven.service.MyServiceFactory;
import it.atletasportjpamaven.service.SportService;

import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

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
			
//			System.out.println("in tabella Atleta ci sono "+atletaServiceInstance.listAll().size() + " elementi.");
//			
//			TestAggiornaAtleta(atletaServiceInstance);
//			System.out.println("in tabella Atleta ci sono "+atletaServiceInstance.listAll().size() + " elementi.");
//
//			TestInserisciNuovoAtleta(atletaServiceInstance);
//			System.out.println("in tabella Atleta ci sono "+atletaServiceInstance.listAll().size() + " elementi.");
//			
//			TestRimuoviAtleta(atletaServiceInstance);
//			System.out.println("in tabella Atleta ci sono "+atletaServiceInstance.listAll().size() + " elementi.");
			
			System.out.println("in tabella Sport ci sono " + sportServiceInstance.listAllSport().size() + " elementi.");
			
			TestAggiornaSport(sportServiceInstance);
			System.out.println("in tabella Sport ci sono " + sportServiceInstance.listAllSport().size() + " elementi.");



			
			
			
	
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
			sportServiceInstance.inserisciNuovoSport(new Sport("Pallavolo"));
		}

		if (sportServiceInstance.cercaPerDescrizione("Calcio") == null) {
			sportServiceInstance.inserisciNuovoSport(new Sport("Calcio"));
			
		}
		if(sportServiceInstance.cercaPerDescrizione("Basket")== null) {
			sportServiceInstance.inserisciNuovoSport(new Sport("Basket"));
		}
		if (sportServiceInstance.cercaPerDescrizione("Tennis")==null) {
			sportServiceInstance.inserisciNuovoSport(new Sport("Tennis"));
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
	
	//
	private static void TestRimuoviAtleta (AtletaService atletaServiceIstance) throws Exception {
		System.out.println(".......TestRimuoviAtleta inizio.............");
		List<Atleta> listaAtleti= atletaServiceIstance.listAll();
		if (listaAtleti.size()<1) {
			throw new RuntimeException("non sono presenti atleti sul db");
		}
		atletaServiceIstance.rimuoviAtleta(listaAtleti.get(0).getId());
		List<Atleta> listaAtletiDopoRimozione= atletaServiceIstance.listAll();
		if (listaAtleti.size() == listaAtletiDopoRimozione.size()) {
			throw new RuntimeException("test fallito: atleta non rimosso");

		}
		System.out.println(".......TestRimuoviAtleta fine.............");	
	}
	
	//
	private static void TestAggiornaSport (SportService sportServiceInstance) throws Exception{
		System.out.println(".......TestAggiornaSport inizio.............");
		List<Sport> listaSport = sportServiceInstance.listAllSport();
		if (listaSport.size() < 1)
			throw new RuntimeException("errori: non sono presenti atleti sul db.");
		Sport sportDaAggiornare = listaSport.get(0);
		String nuovaDescrizione = "Cricket";
		sportDaAggiornare.setDescrizione(nuovaDescrizione);
		sportServiceInstance.aggiornaSport(sportDaAggiornare);
		System.out.println(sportDaAggiornare);
		System.out.println(".......TestAggiornaSport fine.......");

	}
	
	//
	
	
}
