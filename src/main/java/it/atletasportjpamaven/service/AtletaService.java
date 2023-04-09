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
	
	public void rimuoviSport(Atleta atletaEsistente, Sport sportInstance) throws Exception;
	
	public int sommaMedaglieVinteInSportChiusi() throws Exception;
	
	



	// per injection
	public void setAtletaDAO(AtletaDAO atletaDAO);
	public void setSportDAO(SportDAO sportDAO);

}
