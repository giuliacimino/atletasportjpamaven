package it.atletasportjpamaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Sport;
import it.atletasportjpamaven.dao.EntityManagerUtil;

public class SportServiceImpl implements SportService {
	private SportDAO sportDAO;
	private AtletaDAO atletaDAO;

	@Override
	public void setAtletaDAO(AtletaDAO atletaDAO) {
		this.atletaDAO = atletaDAO;
	}

	@Override
	public void setSportDAO(SportDAO sportDAO) {
		this.sportDAO = sportDAO;
	}

	@Override
	public List<Sport> listAllSport() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			sportDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return sportDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Sport caricaSingoloSport(Long id) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// uso l'injection per il dao
					sportDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					return sportDAO.get(id);

				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
	}

	@Override
	public void aggiornaSport(Sport sportInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					sportDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					sportDAO.update(sportInstance);

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
	public void inserisciNuovoSport (Sport sportInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuoviSport(Long idSportToRemove) throws Exception {
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
}
