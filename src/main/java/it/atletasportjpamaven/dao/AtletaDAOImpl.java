package it.atletasportjpamaven.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.atletasportjpamaven.model.Atleta;

public class AtletaDAOImpl implements AtletaDAO{
	
	
	
	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Atleta> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atleta get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Atleta o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Atleta o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Atleta o) throws Exception {
		// TODO Auto-generated method stub
		
	}
		

	@Override
	public Atleta findByIdFetchingSports(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sumMedaglieVinteByAtletiWithSportChiusi() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
