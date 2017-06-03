package com.algaworks.brewer.session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.ItenVenda;

@SessionScope
@Component
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
