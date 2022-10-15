package wildcat.games.drugstore.model;

import java.util.Date;

public class Client {

    private String name;
    private String lastname;
    private String sex;
    private String address;
    private String dni;
    private String cellphone;

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


    public Client(String name, String lastname, String sex, String address, String dni, String cellphone) {
        this.name = name;
        this.lastname = lastname;
        this.sex = sex;
        this.address = address;
        this.dni = dni;
        this.cellphone = cellphone;
    }
    public Client(){

    }
}
