package Handlers;

import DAO.TaskDao;
import Model.Task;

import java.time.LocalDateTime;

public class CreateCommandHandler {

    public static void handle(String command) {
        //CREATE;NAME=TASK1;DESCRIPTION=SOME DESCRIPTION1;DEADLINE=11.02.2021 20:10;PRIORITY=0
        String[] parameterArray = command.split(";");
        String name = parameterArray[1].substring(5);
        String description = parameterArray[2].substring(12);
        LocalDateTime deadline = LocalDateTime.parse(parameterArray[3].substring(9));
        Integer priority = Integer.parseInt(parameterArray[4].substring(8));
        TaskDao.addTask(new Task(name, description, deadline, priority));
    }
}
