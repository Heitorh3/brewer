package com.algaworks.brewer.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.brewer.model.ItenVenda;

public class TabelaItensVenda {

	public List<ItenVenda> itens = new ArrayList<>();
	
	public BigDecimal getValorTotal(){
		return itens.stream()
				.map(ItenVenda::getValorTotal)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
}
