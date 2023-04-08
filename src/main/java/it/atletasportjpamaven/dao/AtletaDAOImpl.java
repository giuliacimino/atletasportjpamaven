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
		return entityManager.createQuery("from Atleta",Atleta.class).getResultList();

	}

	@Override
	public Atleta get(Long id) throws Exception {
		return entityManager.find(Atleta.class, id);
	}

	@Override
	public void update(Atleta atletaInstance) throws Exception {
		if (atletaInstance == null) {
			throw new Exception("Problema valore in input");
		}
		atletaInstance = entityManager.merge(atletaInstance);
		
	}

	@Override
	public void insert(Atleta atletaInstance) throws Exception {
		if (atletaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(atletaInstance);
		
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
