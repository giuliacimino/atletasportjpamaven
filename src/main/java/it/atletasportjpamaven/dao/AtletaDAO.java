package it.atletasportjpamaven.dao;

import it.atletasportjpamaven.model.Atleta;

public interface AtletaDAO extends IBaseDAO<Atleta> {
	
	public Atleta findByIdFetchingSports(Long id);
	public int sumMedaglieVinteByAtletiWithSportChiusi ();
	

}
