package com.algaworks.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	String savarTemporariamente(MultipartFile[] files);

	byte[] recuperarFotoTemporaria(String nome);
}
