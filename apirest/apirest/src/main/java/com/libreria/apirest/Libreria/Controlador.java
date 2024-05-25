package com.libreria.apirest.Libreria;

//Librerias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController //Controlador Rest para gestionar las operaciones CRUD de la entidad Libreria
@RequestMapping("/libros")
public class Controlador {

    private final Libreriaservice Libreriaservice; //Consturctor del controlador de la dependencia del servicio Libreservice

    @Autowired
    public Controlador(Libreriaservice libreriaservice) {
        this.Libreriaservice = libreriaservice;
    }
    // Obtiene una lista de todos los libros
    @GetMapping
    public List<Libreria> getAllUsers() {
        return Libreriaservice.getAllUsers();
    }
    //Obtiene los detalles de un libro por su ID
    @GetMapping("/{Id}")
    public Optional<Libreria> getlibro(@PathVariable Long Id) {
        return Libreriaservice.getUserById(Id);
    }
    // Crea un nuevo libro
    @PostMapping
    public Libreria createUser(@RequestBody Libreria libro) {
        return Libreriaservice.createUser(libro);
    }
    // Modifica la informacion de un libro existente
    @PutMapping("/{id}")
    public ResponseEntity<Libreria> updateUser(@PathVariable Long id, @RequestBody Libreria cambio) {
        Optional<Libreria> updatedLibro = Libreriaservice.updateUser(id, cambio);
        return updatedLibro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Elimina un libro por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = Libreriaservice.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}