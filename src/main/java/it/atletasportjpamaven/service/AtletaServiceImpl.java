package it.atletasportjpamaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;
import it.atletasportjpamaven.dao.EntityManagerUtil;

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
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			atletaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return atletaDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	

	@Override
	public Atleta caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			atletaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return atletaDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiornaAtleta(Atleta atletaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			atletaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			atletaDAO.update(atletaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

		
	}

	@Override
	public void inserisciNuovoAtleta(Atleta atletaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			atletaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			atletaDAO.insert(atletaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuoviAtleta(Long idAtleta) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			entityManager.getTransaction().begin();

			// injection
			atletaDAO.setEntityManager(entityManager);

			atletaDAO.delete(atletaDAO.get(idAtleta));

			//commit
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			//rollback se esito negativo
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void aggiungiSport(Atleta atletaEsistente, Sport sportInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			atletaDAO.setEntityManager(entityManager);

			atletaEsistente = entityManager.merge(atletaEsistente);
			sportInstance = entityManager.merge(sportInstance);

			atletaEsistente.getSports().add(sportInstance);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

		
	}

	@Override
	public void rimuoviSportDaAtleta(Long idAtleta, Long idSport) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			atletaDAO.setEntityManager(entityManager);
			sportDAO.setEntityManager(entityManager);

			Atleta atletaEsistente = atletaDAO.findByIdFetchingSports(idAtleta);
			Sport SportInstance = sportDAO.get(idSport);

			atletaEsistente.getSports().remove(SportInstance);
	
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}
		

	
	@Override
	public Atleta caricaAtletaSingoloConSports(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			atletaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return atletaDAO.findByIdFetchingSports(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}
	
	@Override
	public List<Atleta> listaAtletiDiUnoSport(String descrizione) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			atletaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return atletaDAO.findByDescrizione(descrizione);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}


	@Override
	public Long sommaMedaglieVinteInSportChiusi() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// injection
			atletaDAO.setEntityManager(entityManager);

			// esecuzione metodo
			return atletaDAO.sumMedaglieVinteByAtletiWithSportChiusi();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}







}
