package com.algaworks.brewer.model;

public enum StatusVenda {

	RCAMENTO("Orçamento"), 
	EMITIDA("Emitida"), 
	CANCELADA("Cancelada");

	private String descricao;

	StatusVenda(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
