package com.algaworks.brewer.repository.helper.venda;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.brewer.model.Venda;
import com.algaworks.brewer.repository.filter.VendaFilter;

public interface VendasQueries {

	Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);
	
	Venda buscarComItens(Long codigo);
	
	BigDecimal valorTotalNoAno();
	
	BigDecimal valorTotalNoMes();
	
	BigDecimal valorTicketMedioNoAno();
}
