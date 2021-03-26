package mx.tec.TheChamberWeb.gamer.model;

import java.io.Serializable;

//1. Implementa la interfaz serializable
//Superclase Object
public class Gamer implements Serializable {
    //2. Encapsular los atributos
    private int idCandidato;
    private String gamerID;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String curp;

    //3. Constructores


    public Gamer(int idCandidato, String gamerID, String firstName, String lastName, String password, String email, String curp) {
        this.idCandidato = idCandidato;
        this.gamerID = gamerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.curp = curp;
    }

    public Gamer(String gamerID, String firstName, String lastName, String password, String email, String curp) {
        this.gamerID = gamerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.curp = curp;
    }

    public Gamer() {
    }

    //4. Sobreescribir el método toString()
    // sout(account)


    @Override
    public String toString() {
        return "Gamer{" +
                "idCandidato=" + idCandidato +
                ", gamerID='" + gamerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", curp='" + curp + '\'' +
                '}';
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getGamerID() {
        return gamerID;
    }

    public void setGamerID(String gamerID) {
        this.gamerID = gamerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}
