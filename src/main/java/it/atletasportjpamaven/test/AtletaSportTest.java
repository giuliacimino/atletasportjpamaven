package it.atletasportjpamaven.test;

import it.atletasportjpamaven.service.AtletaService;
import it.atletasportjpamaven.service.MyServiceFactory;
import it.atletasportjpamaven.service.SportService;
import it.atletasportjpamaven.dao.EntityManagerUtil;
import it.atletasportjpamaven.model.Sport;

public class AtletaSportTest {
	public static void main (String[] args) {
		AtletaService atletaServiceInstance = MyServiceFactory.getAtletaServiceInstance();
		SportService sportServiceInstance = MyServiceFactory.getSportServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			// inizializzo i ruoli sul db
			initSports(sportServiceInstance);
			
			
			
			
	
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
}
