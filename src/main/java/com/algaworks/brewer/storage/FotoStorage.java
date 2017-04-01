package com.algaworks.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	String savarTemporariamente(MultipartFile[] files);

	byte[] recuperarFotoTemporaria(String nome);

	void salvar(String foto);

	byte[] recuperarFoto(String nome);
}
