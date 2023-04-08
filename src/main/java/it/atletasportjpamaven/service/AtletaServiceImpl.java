package it.atletasportjpamaven.service;

import java.util.List;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;

public class AtletaServiceImpl implements AtletaService{
	private AtletaDAO atletaDAO;
	private SportDAO sportDAO;

	@Override
	public void setAtletaDAO(AtletaDAO atletaDAO) {
		this.atletaDAO = atletaDAO;
	}

	@Override
	public void setSportDAO(SportDAO sportDAO) {
		this.sportDAO = sportDAO;
	}

	@Override
	public List<Atleta> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atleta caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Atleta atletaInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Atleta atletaInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Long idAtleta) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aggiungiSport(Atleta atletaEsistente, Sport sportInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuoviSport(Atleta atletaEsistente, Sport sportInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sommaMedaglieVinteInSportChiusi() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
