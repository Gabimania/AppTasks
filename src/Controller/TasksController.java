package Controller;

import Model.ModeloBase;
import Model.Rol;
import Model.Task;
import Model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TasksController {

    private User userLogged;

    private List<Rol> rolList;

    private List<Task> taskList;


    public TasksController() {
        rolList = new ArrayList<>();
        rolList = Rol.getRoles();
        taskList = new ArrayList<>();
        taskList = Task.getTasks();
    }

    public boolean login(String username, String password){
        this.userLogged=User.getUsuario(username,password);
       if( userLogged!=null){
           return true;
       }else{
           return false;
       }
    }

    public boolean createUser(String username, String password, int idRol){
        User u = new  User();
        if(u.insertar("(username,password,idRol) values(?,?,?)", username, password,idRol)){
            return true;
        }else{
            return false;
        }
    }

    public boolean updateUsername(String username, String password){
        User u = new User();
        if(u.actualizar("username = ? where password= ?", username, password)){
            return true;
        }else{
            return false;
        }

    }

    public boolean deleteUser(String username, String password){
        User u = new User();
        if(u.borrar("username = ? where password = ?", username, password)){
            return true;
        }else{
            return false;
        }

    }

    public boolean createTask(String title, String description, LocalDate deadline,boolean status, User u){
        return new Task().insertar("title = ?, description=?, deadline = ?, status = ?, iduser= ?", title,description, deadline,status,u.getId());
    }

    public boolean updateTask(String title, String description){
        return new Task().actualizar("description= ? where title= ?", description,title);
    }

    public boolean deleteTask(String title){
        return new Task().borrar("title=?", title);

    }

    public boolean updateRol( int idRol)
    {
        return new Rol().actualizar("idRol=?", idRol);
    }
}
