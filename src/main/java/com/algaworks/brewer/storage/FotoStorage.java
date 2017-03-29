package com.algaworks.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	void savarTemporariamente(MultipartFile[] files);
}
