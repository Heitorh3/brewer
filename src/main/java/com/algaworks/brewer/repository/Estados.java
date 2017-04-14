package com.algaworks.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.brewer.model.Estado;

@Repository
public interface Estados extends JpaRepository<Estado, Long> {

	Optional<Estado> findByNome(String nome);

}
