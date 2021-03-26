package mx.tec.TheChamberWeb.administrator.model;

import java.io.Serializable;

//1. Implementa la interfaz serializable
//Superclase Object
public class Administrator implements Serializable {
    //2. Encapsular los atributos
    private int id;
    private String user;
    private String password;
    private String email;

    //3. Constructores
    public Administrator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Administrator() {
    }

    //4. Sobreescribir el método toString()
    // sout(account)
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
}
