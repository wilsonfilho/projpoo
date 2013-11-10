package br.com.projetopoo.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class AcoesDao extends GenericDao {

	public AcoesDao(EntityManager entityManager) {
		
		super(entityManager);
	}

}
