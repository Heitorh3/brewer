package com.algaworks.brewer.session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.ItenVenda;

class TabelaItensVenda {
	
	private String uuid;
	public List<ItenVenda> itens = new ArrayList<>();
	
	
	public TabelaItensVenda(String uuid) {
		this.uuid = uuid;
	}

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
	
	public void excluirItem(Cerveja cerveja){
		int indice = IntStream.range(0, itens.size())
				.filter(i -> itens.get(i).getCerveja().equals(cerveja))
				.findAny().getAsInt();
		
		itens.remove(indice);
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

	public String getUuid() {
		return uuid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabelaItensVenda other = (TabelaItensVenda) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	
	
}
