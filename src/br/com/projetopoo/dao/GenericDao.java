package br.com.projetopoo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.util.StringUtils;

public class GenericDao {

	public final EntityManager entityManager;
	
	public GenericDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	// Busca todos os elementos do tipo do objeto
	@SuppressWarnings("unchecked")
	public <E> List<E> findAll(E objeto) {
		
		Query query = entityManager.createQuery("select g from " + objeto.getClass().getName() + " g");
		
		return query.getResultList();
	}
	
	// Busca um elemento pela chave campo
	public <E> E findBy(String campo, E objeto) {
	       
		E doReturn = null;
		String campoGet = "get" + StringUtils.capitalize(campo);
			
		try {
			Object valor = objeto.getClass().getMethod(campoGet).invoke(objeto);
			Query query = entityManager.createQuery("select g FROM " + objeto.getClass().getName() + " g where g." + campo + " = :campo" );
			query.setParameter("campo", valor);
			
			doReturn = getResultAsSingle(query);
			
		} catch (Exception e) {

		} 		
        
        return doReturn;
	}
	
	// Executa a query e retorna um elemento
	@SuppressWarnings("unchecked")
	public <E> E getResultAsSingle(Query query) {

		E resultado = (E) query.getSingleResult();
		
		return resultado;
	}
	
	public Object save(Object object) {
		
		entityManager.persist(object);
		
		return object;
	}
}
