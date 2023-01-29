package Handlers;

import Dao.TaskDao;

public class ReadCommandHandler {
    //READ;NAME=TASK1
    // READ ALL;
    public static void readOne(String command) {
        String[] parameterArray = command.split(";");
        String name = parameterArray[1].substring(5);
       // TaskDao.getTasks(name);
    }
    public static void readAll() {

    }
}
