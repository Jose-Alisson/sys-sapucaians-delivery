package br.sapucaians.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sapucaians.delivery.model.LocalidadeModel;

public interface LocalidadeRepository extends JpaRepository<LocalidadeModel, Long>{
    
}
