package com.algaworks.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.brewer.model.Estado;
import com.algaworks.brewer.repository.Estados;

@Service
public class CadastroEstadoService {

	@Autowired
	private Estados estados;
	
	public void salvar(Estado estado){
		estados.save(estado);
	}
	
}
