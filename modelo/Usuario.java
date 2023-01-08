package org.davidsal.jdbc.modelo;

public class Usuario {
    private Long id;
    private String userName;
    private String password;
    private String email;

    ///////////////////Constructor/////////////////////


    public Usuario() {
    }

    public Usuario(Long id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }


    ///////////////////get and Set/////////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    ///////////////////toString/////////////////////
    @Override
    public String toString() {
        return  id +
                " | " + userName +
                " | " + password +
                " | " + email ;
    }
}
