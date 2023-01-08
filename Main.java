package org.davidsal.jdbc;

import org.davidsal.jdbc.modelo.Usuario;
import org.davidsal.jdbc.usuario.Implementacion;
import org.davidsal.jdbc.util.Connect;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try(Connection conn = Connect.getConn()){
            Implementacion imp = new Implementacion();
            imp.list().forEach(System.out::println);
            Usuario usu = new Usuario(3L,"Alberto","contalberto","alberto.@correo.com");
            System.out.println("===Crear usuario===");
            //imp.create(usu);
            //imp.list().forEach(System.out::println);
            System.out.println("===Actualizar usuario===");
            usu.setId(3L);
            usu.setUserName("SegundoAlbe");
            usu.setEmail("segundo@correo.com");
            imp.updte(usu);
            imp.list().forEach(System.out::println);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
