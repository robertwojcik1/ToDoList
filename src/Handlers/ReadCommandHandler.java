package Handlers;

import Dao.TaskDao;

public class ReadCommandHandler {
    //READ;NAME=TASK1
    // READ ALL;
    public static void readOne(String command) {
        String[] parameterArray = command.split(";");
        String name = parameterArray[1].substring(5);
        TaskDao.getSelectedTask(name);
    }
    public static void readAll(String command) {
        String[] parameterArray = command.split(";");
        if(parameterArray.length == 1) {
            TaskDao.getAllTasks();
            return;
        } else {
            String sortingParameter = parameterArray[1];
            String[] split = sortingParameter.split(",");
            String sortedBy = split[0].substring(5);
            String order = split[1];
            TaskDao.getSortedTasks(sortedBy, order);
            return;
        }
    }
}
