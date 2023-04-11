package it.atletasportjpamaven.service;

import java.util.List;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;

public interface AtletaService {
	public List<Atleta> listAll() throws Exception;

	public Atleta caricaSingoloElemento(Long id) throws Exception;

	public void aggiornaAtleta (Atleta atletaInstance) throws Exception;

	public void inserisciNuovoAtleta(Atleta atletaInstance) throws Exception;

	public void rimuoviAtleta(Long idAtleta) throws Exception;
	
	public void aggiungiSport(Atleta atletaEsistente, Sport sportInstance) throws Exception;
			
	public void rimuoviSportDaAtleta(Long idAtleta, Long idSport) throws Exception;
	
	public Atleta caricaAtletaSingoloConSports (Long id) throws Exception;
	
	public List<Atleta> listaAtletiDiUnoSport (String descrizione) throws Exception;
	
	public Long sommaMedaglieVinteInSportChiusi() throws Exception;
	
	



	// per injection
	public void setAtletaDAO(AtletaDAO atletaDAO);
	public void setSportDAO(SportDAO sportDAO);

}
