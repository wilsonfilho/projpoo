package br.com.projetopoo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetopoo.model.Acoes;

@Component
public class AcoesDao extends GenericDao {

	public AcoesDao(EntityManager entityManager) {
		
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Acoes> todasSolicitacoes() {
		
		// S -> Solicitação
		Query query = entityManager.createQuery("select a from Acoes a where a.tipoAcao = 'S' or a.tipoAcao = 'B'");
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Acoes> todasSolicitacoesAvaliar() {
		
		// S -> Solicitação
		Query query = entityManager.createQuery("select a from Acoes a where a.tipoAcao = 'A'");
		
		return query.getResultList();
	}
}
