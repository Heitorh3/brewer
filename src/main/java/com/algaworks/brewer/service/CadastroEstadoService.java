package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Estado;
import com.algaworks.brewer.repository.Estados;
import com.algaworks.brewer.service.exception.NomeEstadoJaCadastradoException;

@Service
public class CadastroEstadoService {

	@Autowired
	private Estados estados;
	
	@Transactional
	public void salvar(Estado estado){
		Optional<Estado>estadoOptional = estados.findByNome(estado.getNome());
		
		if(estadoOptional.isPresent()){
			throw new NomeEstadoJaCadastradoException("Nome estado já cadastrado");
		}
		estados.save(estado);
	}
	
}
