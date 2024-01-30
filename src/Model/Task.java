package Model;

import BBDD.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task extends ModeloBase{

    private int id;

    private String title;

    private String description;

    private LocalDateTime datetime;
    private LocalDate deadline;
    private boolean status;

    private User user;

    public Task(int id, String title, String description, LocalDateTime datetime, LocalDate deadline, boolean status, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.deadline = deadline;
        this.status = status;
        this.user = user;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

    public static List<Task> getTasks(){
        List<Task>taskList = new ArrayList<>();
        Connection con = Conexion.conectar();
        String sql = "select * from task";
        try {
            Statement stm = con.createStatement();
            ResultSet respuesta = stm.executeQuery(sql);
            while (respuesta.next()) {
                Task task = new Task();
                User user = new User();
                task.setId(respuesta.getInt("idTask"));
                task.setTitle(respuesta.getString("title"));
                task.setDescription(respuesta.getString("description"));
                task.setDatetime(respuesta.getObject("datetime", LocalDateTime.class));
                task.setDeadline(respuesta.getObject("deadline", LocalDate.class));
                task.setStatus(respuesta.getBoolean("status"));
                user.setId(respuesta.getInt("idUser"));
                user.setUsername(respuesta.getString("username"));
                task.setUser(user);
                taskList.add(task);

            }  } catch (SQLException e) {
            //throw new RuntimeException(e);
            return taskList;
        }
        try{
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return taskList;
    }


    @Override
    public String toString () {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", deadline=" + deadline +
                ", status=" + status +
                '}';
    }

    @Override
    protected String getNombreTabla() {
        return "task";
    }
}


