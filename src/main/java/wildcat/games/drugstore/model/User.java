package wildcat.games.drugstore.model;

import java.util.Date;

public class User {

    private String name;
    private String lastname;
    private String sex;
    private String address;
    private String dni;
    private String cellphone;
    private String username;
    private String pass;

    public User(String name, String lastname, String sex, String address, String dni, String cellphone, String username, String pass) {
        this.name = name;
        this.lastname = lastname;
        this.sex = sex;
        this.address = address;
        this.dni = dni;
        this.cellphone = cellphone;
        this.username = username;
        this.pass = pass;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
