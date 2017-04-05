package com.algaworks.brewer.repository.helper.estilo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.algaworks.brewer.model.Estilo;

public class EstilosQueriesImpl implements EstilosQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public Page<Estilo> filtra(Estilo estilo, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegisto = paginaAtual * totalRegistroPorPagina;
		
		criteria.setFirstResult(primeiroRegisto);
		criteria.setMaxResults(totalRegistroPorPagina);
		
		Sort sort = pageable.getSort();
		if(sort != null){
			Sort.Order order = sort.iterator().next(); 
			String property = order.getProperty();
			criteria.addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
		}
		
		adicionarFiltro(estilo, criteria);
		return new PageImpl<>(criteria.list(), pageable, total(estilo));
	}

	private Long total(Estilo filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);
		this.adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		
		return (Long)criteria.uniqueResult();
	}
	
	private void adicionarFiltro(Estilo estilo, Criteria criteria) {
		if(estilo != null){
			if (!StringUtils.isEmpty(estilo.getNome())) {
				criteria.add(Restrictions.eq("nome", estilo.getNome()));
			}
		}
	}

}
