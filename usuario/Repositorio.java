package org.davidsal.jdbc.usuario;

import org.davidsal.jdbc.modelo.Usuario;

import java.util.List;

public interface Repositorio<T> {
    List<T> list();

    void updte(T t);

    void create(T t);

    void delete(Long id);



}
