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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sport get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Sport o) throws Exception {
		// TODO Auto-generated method stub
		
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
