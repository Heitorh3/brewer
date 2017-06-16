package com.algaworks.brewer.session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		Optional<ItenVenda> itenVendaOptional = buscarItemPorCerveja(cerveja);
		
		ItenVenda itenVenda = null;
		if(itenVendaOptional.isPresent()){
			itenVenda = itenVendaOptional.get();
			itenVenda.setQuantidade(itenVenda.getQuantidade() + quantidade);
		}else{
			itenVenda = new ItenVenda();
		
			itenVenda.setCerveja(cerveja);
			itenVenda.setQuantidade(quantidade);
			itenVenda.setValorUnitario(cerveja.getValor());
			
			itens.add(0,itenVenda);
		}
	}

	public void alterarQuantidadeItens(Cerveja cerveja, Integer quantidade){
		ItenVenda itenVenda = buscarItemPorCerveja(cerveja).get();
		itenVenda.setQuantidade(quantidade);
	}

	public List<ItenVenda> getItens() {
		return itens;
	}

	public int total() {
		return itens.size();
	}
	
	private Optional<ItenVenda> buscarItemPorCerveja(Cerveja cerveja) {
		return itens.stream()
				.filter(i -> i.getCerveja().equals(cerveja))
				.findAny();
	}
}
