import Controller.TasksController;
import Model.Task;
import Model.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TasksController tasksController = new TasksController();
        tasksController.createUser("Gabriel", "contraseña1", 2);
        tasksController.login("Gabriel", "contraseña1");


    }
}