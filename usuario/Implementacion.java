package org.davidsal.jdbc.usuario;

import org.davidsal.jdbc.modelo.Usuario;
import org.davidsal.jdbc.util.Connect;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class Implementacion implements Repositorio<Usuario> {

    private Connection localGetConn(){
        return Connect.getConn();
    }

    @Override
    public List<Usuario> list() {
        List <Usuario> users = new ArrayList<>();
        try(Statement stmt = localGetConn().createStatement();
            ResultSet res =stmt.executeQuery("Select * from usuarios")){
            while(res.next()){
                Usuario usu = setUsuario(res);
               users.add(usu);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;

    }

    @Override
    public void updte(Usuario usu) {
        try(PreparedStatement stmt = localGetConn()
                //UPDATE `tareabd`.`usuarios` SET `username` = 'Alberto2' WHERE (`id` = '3');
                .prepareStatement("UPDATE tareabd.usuarios SET username=?, password=?, email=? WHERE id=? ")) {
                stmt.setString(1,usu.getUserName());
                stmt.setString(2,usu.getPassword());
                stmt.setString(3,usu.getEmail());
                stmt.setLong(4,usu.getId());
                stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Usuario usu) {
        try(PreparedStatement stmt = localGetConn()
                .prepareStatement("Insert into usuarios (username,password,email) VALUES (?,?,?) ");) {
            stmt.setString(1,usu.getUserName());
            stmt.setString(2,usu.getPassword());
            stmt.setString(3,usu.getEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = localGetConn().prepareStatement("Delete from usuario where id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    ///////////////////Setear valores en usuario/////////////////////
    private Usuario setUsuario(ResultSet res) throws SQLException {
        Usuario usu = new Usuario();
        usu.setId(res.getLong("id"));
        usu.setUserName(res.getString("username"));
        usu.setPassword(res.getString("password"));
        usu.setEmail(res.getString("email"));
        return usu;
    }
}
