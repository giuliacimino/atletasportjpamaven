package it.atletasportjpamaven.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.atletasportjpamaven.model.Sport;

public class SportDAOImpl implements SportDAO {
	
	
	private EntityManager entityManager;
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	public List<Sport> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
				// non la tabella
				return entityManager.createQuery("from Sport",Sport.class).getResultList();
	}

	@Override
	public Sport get(Long id) throws Exception {
		return entityManager.find(Sport.class, id);
	}

	@Override
	public void update(Sport sportInstance) throws Exception {
		if (sportInstance == null) {
			throw new Exception("Problema valore in input");
		}
		sportInstance = entityManager.merge(sportInstance);
		
	}

	@Override
	public void insert(Sport sportInstance) throws Exception {
		if (sportInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(sportInstance);
		
	}

	@Override
	public void delete(Sport sportInstance) throws Exception {
		if(sportInstance==null) {
			throw new Exception("Problema antonello in input");
		}
		entityManager.remove(entityManager.merge(sportInstance));

		
	}

	
	@Override
	public Sport findByDescrizione(String descrizione){
		TypedQuery<Sport> query = entityManager
				.createQuery("select s from Sport s where s.descrizione=?1", Sport.class)
				.setParameter(1, descrizione);
		
		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public List<Sport> findMistakes(){
		TypedQuery<Sport> query = entityManager
				.createQuery("select s from Sport s where s.dataFine < s.dataInizio", Sport.class);
		return query.getResultList();
		
	}


	
	

}
