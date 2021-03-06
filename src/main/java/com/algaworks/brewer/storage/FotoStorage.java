package com.algaworks.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	String savarTemporariamente(MultipartFile[] files);

	byte[] recuperarFotoTemporaria(String nome);

	void salvar(String foto);

	byte[] recuperarFoto(String nome);
	
	byte[] recuperar(String foto);
	
	byte[] recuperarThumbnail(String fotoCerveja);

	void excluir(String foto);
}
