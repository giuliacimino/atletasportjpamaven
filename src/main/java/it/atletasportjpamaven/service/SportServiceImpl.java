package it.atletasportjpamaven.service;

import java.util.List;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Sport;

public class SportServiceImpl implements SportService{
	private SportDAO sportDAO;
	private AtletaDAO atletaDAO;
	@Override
	public List<Sport> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Sport caricaSingoloSport(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void aggiorna(Sport sportInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void inserisciNuovo(Sport sportInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void rimuovi(Long idSportToRemove) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Sport cercaPerDescrizione(String descrizione) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Sport> cercaErrori() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setAtletaDAO(AtletaDAO atletaDAO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setSportDAO(SportDAO sportDAO) {
		// TODO Auto-generated method stub
		
	}
	
	

}
