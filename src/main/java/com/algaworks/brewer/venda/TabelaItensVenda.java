package com.algaworks.brewer.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.ItenVenda;

public class TabelaItensVenda {

	public List<ItenVenda> itens = new ArrayList<>();
	
	public BigDecimal getValorTotal(){
		return itens.stream()
				.map(ItenVenda::getValorTotal)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}

	public void adicionarItem(Cerveja cerveja, Integer quantidade) {
		ItenVenda iten = new ItenVenda();
		
		iten.setCerveja(cerveja);
		iten.setQuantidade(quantidade);
		iten.setValorUnitario(cerveja.getValor());
		
		itens.add(iten);
	}
}
