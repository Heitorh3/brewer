package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.repository.Cidades;
import com.algaworks.brewer.service.exception.ImpossivelExcluirEntidadeException;
import com.algaworks.brewer.service.exception.NomeCidadeJaCadastradoException;

@Service
public class CadastroCidadeService {

	@Autowired
	private Cidades cidades;
	
	@Transactional
	public void salvar(Cidade cidade){
		Optional<Cidade> cidadeExistente = cidades.findByNomeAndEstado(cidade.getNome(), cidade.getEstado());
		
		if(cidadeExistente.isPresent()){
			throw new NomeCidadeJaCadastradoException("Nome de cidade já cadastrado");
		}
		
		cidades.save(cidade);
	}

	@Transactional
	public void excluir(Cidade cidade) {
		try {
			cidades.delete(cidade.getCodigo());
		}catch(ImpossivelExcluirEntidadeException e) {
			throw new ImpossivelExcluirEntidadeException("Não foi possível apagar a cidade."); 
		}
		
	}
}
