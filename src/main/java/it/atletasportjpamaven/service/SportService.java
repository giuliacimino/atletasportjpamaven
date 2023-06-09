package it.atletasportjpamaven.service;

import java.util.List;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Sport;

public interface SportService {
	public List<Sport> listAllSport() throws Exception;

	public Sport caricaSingoloSport(Long id) throws Exception;

	public void aggiornaSport(Sport sportInstance) throws Exception;

	public void inserisciNuovoSport(Sport sportInstance) throws Exception;

	public void rimuoviSport(Long idSportToRemove) throws Exception;

	public Sport cercaPerDescrizione(String descrizione) throws Exception;
	
	public List<Sport> cercaErrori() throws Exception;
 
	// per injection
	public void setAtletaDAO(AtletaDAO atletaDAO);

	public void setSportDAO(SportDAO sportDAO);

}
