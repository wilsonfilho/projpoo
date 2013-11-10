package br.com.projetopoo.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetopoo.model.Departamento;
import br.com.projetopoo.model.Empregado;

@Component
public class EmpregadoDao extends GenericDao {

	public EmpregadoDao(EntityManager entityManager) {
		
		super(entityManager);
	}
	
	public Empregado findGestorDepartamento(Departamento departamento) {
		
		Query query = entityManager.createQuery("select d.chefe from Departamento d where d.id = :id");
		query.setParameter("id", departamento.getId());
		
		return (Empregado) query.getSingleResult();		
	}
}
