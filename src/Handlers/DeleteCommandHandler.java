package Handlers;

import DAO.TaskDao;

public class DeleteCommandHandler {
    //DELETE;NAME=TASK4

    public static void handle(String command) {
        String[] parameterArray = command.split(";");
        String name = parameterArray[1].substring(5);
        TaskDao.deleteTask(name);
    }
}
