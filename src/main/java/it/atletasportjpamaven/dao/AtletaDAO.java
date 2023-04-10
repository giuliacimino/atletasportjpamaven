package it.atletasportjpamaven.dao;

import java.util.List;

import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;

public interface AtletaDAO extends IBaseDAO<Atleta> {
	
	public Atleta findByIdFetchingSports(Long id);
	public Long sumMedaglieVinteByAtletiWithSportChiusi ();
	public List<Atleta> findAllBySport (Sport sportInput);
	public List<Atleta> findByDescrizione (String descrizione);
	

}
