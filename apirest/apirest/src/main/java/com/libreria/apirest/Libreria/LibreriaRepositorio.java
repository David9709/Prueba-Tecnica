package com.libreria.apirest.Libreria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para la entidad Libreria
@Repository
public interface LibreriaRepositorio extends JpaRepository<Libreria, Long> {
    
}
