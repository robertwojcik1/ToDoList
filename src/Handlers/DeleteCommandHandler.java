package Handlers;

import Dao.TaskDao;

public class DeleteCommandHandler {

    public static void handle(String command) {
        String[] parameterArray = command.split(";");
        String name = parameterArray[1].substring(5);
        TaskDao.deleteTask(name);
    }
}
