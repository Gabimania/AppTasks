package Model;

import BBDD.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Rol extends ModeloBase{
    private int id;
    private String description;



    public Rol(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Rol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Rol> getRoles(){
        List<Rol>rolList = new ArrayList<>();
        Connection con = Conexion.conectar();
        String sql = "select * from rol";
        try {
            Statement stm = con.createStatement();
            ResultSet respuesta = stm.executeQuery(sql);
            while(respuesta.next()){
                Rol rol = new Rol();
                rol.setId(respuesta.getInt("idRol"));
                rol.setDescription(respuesta.getString("desciption"));
                rolList.add(rol);
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return rolList;
        }
        try{
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return rolList;
    }

    @Override
    protected String getNombreTabla() {
        return "rol";
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}




