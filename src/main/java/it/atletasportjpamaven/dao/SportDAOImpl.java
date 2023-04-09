package it.atletasportjpamaven.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
	public void insert(Sport o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sport o) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Sport> findMistakes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
