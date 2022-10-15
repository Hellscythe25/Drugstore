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


}
