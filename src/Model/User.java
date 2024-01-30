package Model;

import BBDD.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String username;
    private String password;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User() {
    }

    public static User getUsuario(String username, String password) {
        Connection con = Conexion.conectar();
        String sql = "select * from user where username = ? and password = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet respuesta = stm.executeQuery();
            if (respuesta.next()) {
                User usuario = new User();
                usuario.setId(respuesta.getInt("idUser"));
                usuario.setUsername(respuesta.getString("username"));
                usuario.setPassword(respuesta.getString("password"));
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
