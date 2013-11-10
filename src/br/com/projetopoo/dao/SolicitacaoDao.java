package br.com.projetopoo.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class SolicitacaoDao extends GenericDao {

	public SolicitacaoDao(EntityManager entityManager) {
		
		super(entityManager);
	}

}
