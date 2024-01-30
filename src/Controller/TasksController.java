package Controller;

import Model.Rol;
import Model.Task;
import Model.User;

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
}
