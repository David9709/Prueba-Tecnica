package com.libreria.apirest.Libreria;

//Librerias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Servicio para manejar las operaciones CRUD de la entidad Libreria
@Service
public class Libreriaservice {
    //Constructor de la Libreria
    private final LibreriaRepositorio libreriaRepository;
    //El repositorio de Libreria para administrar
    @Autowired
    public Libreriaservice(LibreriaRepositorio libreriaRepository) {
        this.libreriaRepository = libreriaRepository;
    }
    //Obtiene todas las entidad de la Libreria
    public List<Libreria> getAllUsers() {
        return libreriaRepository.findAll();
    }
    //Obtiene una entidad de la Libreria por su ID
    public Optional<Libreria> getUserById(Long id) {
        return libreriaRepository.findById(id);
    }
    //Crea una nueva entidad en la LIbreria
    public Libreria createUser(Libreria libro) {
        return libreriaRepository.save(libro);
    }
    //Actualiza la entidad Libreria existente
    public Optional<Libreria> updateUser(Long id, Libreria cambio) {
        return libreriaRepository.findById(id).map(user -> {
            user.setTitulo(cambio.getTitulo());
            user.setAutor(cambio.getAutor());
            user.setAnoPublicacion(cambio.getAnoPublicacion());
            user.setGenero(cambio.getGenero());
            return libreriaRepository.save(user);
        });
    }
    //Elimina una entidad de la LIbreria por su ID
    public boolean deleteUser(Long id) {
        if (libreriaRepository.existsById(id)) {
            libreriaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
