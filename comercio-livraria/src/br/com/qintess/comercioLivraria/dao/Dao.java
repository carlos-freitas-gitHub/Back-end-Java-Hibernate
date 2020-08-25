package br.com.qintess.comercioLivraria.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.qintess.comercioLivraria.config.HibernateConfig;

public class Dao {
//insere
	public <T> void insere(T entidade) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(entidade);
			session.getTransaction().commit();
		}
	}

// atualiza
	public <T> void atualiza(T entidade) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.merge(entidade);
			session.getTransaction().commit();
		}
	}

// deleta
	public <T> void deleta(T entidade) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(entidade);
			session.getTransaction().commit();
		}
	}

// listar
	public <T> List<T> listar(Class<T> nomeClasse) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.createQuery("from " + nomeClasse.getName()).getResultList();
		}
	}

// listar por id
	public <T> T buscaPorId(Class<T> nomeClasse, int id) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.get(nomeClasse, id);
		}
	}
}
