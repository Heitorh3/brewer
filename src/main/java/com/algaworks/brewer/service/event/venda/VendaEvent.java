package com.algaworks.brewer.service.event.venda;

import com.algaworks.brewer.model.Venda;

public class VendaEvent {

	private Venda venda;

	 
	public VendaEvent() {
	}
	
	public VendaEvent(Venda venda) {
		super();
		this.venda = venda;
	}


	public Venda getVenda() {
		return venda;
	}
	
}
