package com.libreria.apirest.Libreria;

//Librerias
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//Clase de entidad que representa un libro en la libreria
public class Libreria {
    //Identificador unico para cada libro, este se genera automaticamente
    @Id
    @GeneratedValue
    private Long id;
    //Titulo del libro
    @Basic
    private String titulo;
    //Autor del Libro
    @Basic
    private String autor;
    //Año de publicacion
    @Basic
    private Integer anoPublicacion;
    //Genero del libro
    @Basic
    private String genero;

    //Fuines para obtener y establecer cada una de las caracteristicas del objeto 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(Integer anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
