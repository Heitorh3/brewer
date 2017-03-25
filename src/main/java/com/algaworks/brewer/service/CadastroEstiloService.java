package com.algaworks.brewer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.Estilos;

@Service
public class CadastroEstiloService {

	private Estilos estilos;
	
	@Transactional
	public void salvar(Estilo estilo){
		estilos.save(estilo);
	}
}
