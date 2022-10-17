package wildcat.games.drugstore.dao;

import wildcat.games.drugstore.dao.mysql.MySqlConnection;
import wildcat.games.drugstore.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public int addUser(User user) throws Exception{

        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();
        int rowsAffected =0;

        String queryInsert ="INSERT INTO USERS (name, lastname, sex, address, dni, cellphone, username, pass) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(queryInsert);
        ps.setString(1,user.getName());
        ps.setString(2,user.getLastname());
        ps.setString(3,user.getSex());
        ps.setString(4,user.getAddress());
        ps.setString(5,user.getDni());
        ps.setString(6,user.getCellphone());
        ps.setString(7,user.getUsername());
        ps.setString(8,user.getPass());

        rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    public int updateUser(String dni,User user) throws Exception{
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();

        String querySelect = "SELECT * FROM USERS WHERE dni = ?";

        PreparedStatement ps = con.prepareStatement(querySelect);
        ps.setString(1,dni);
        ResultSet resultSet = ps.executeQuery();

        int count=0;
        while(resultSet.next()){
            count++;
        }

        if(count==0){
            return 0;
        }else{
            String queryUpdate = "UPDATE USERS SET name=?," +
                    "lastname=?," +
                    "sex=?," +
                    "address=?," +
                    "cellphone=?," +
                    "username=?," +
                    "pass=?" +
                    "WHERE dni=?";

            PreparedStatement psUpdate = con.prepareStatement(queryUpdate);
            psUpdate.setString(1,user.getName());
            psUpdate.setString(2,user.getLastname());
            psUpdate.setString(3,user.getSex());
            psUpdate.setString(4,user.getAddress());
            psUpdate.setString(5,user.getCellphone());
            psUpdate.setString(6,user.getUsername());
            psUpdate.setString(7,user.getPass());
            psUpdate.setString(8,dni);

            return psUpdate.executeUpdate();
        }
    }

    public User getUserByDni(String dni) throws Exception{
        MySqlConnection mySQLConnection = new MySqlConnection();
        Connection con = mySQLConnection.getConnection();

        String querySelect = "SELECT * FROM USERS WHERE dni = ?";

        PreparedStatement ps = con.prepareStatement(querySelect);
        ps.setString(1,dni);
        ResultSet resultSet = ps.executeQuery();

        User user = new User();

        while(resultSet.next()){
            user.setName(resultSet.getString("name"));
            user.setLastname(resultSet.getString("lastname"));
            user.setSex(resultSet.getString("sex"));
            user.setAddress(resultSet.getString("address"));
            user.setCellphone(resultSet.getString("cellphone"));
            user.setUsername(resultSet.getString("username"));
            user.setPass(resultSet.getString("pass"));
            break;
        }

        return user;

    }


}
