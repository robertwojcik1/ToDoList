package Handlers;

import DAO.TaskDao;
import Model.Task;

import java.time.LocalDateTime;

public class UpdateCommandHandler {
//UPDATE;NAME=TASK3;DESCRIPTION=SOME NEW DESCRIPTION;DEADLINE=14.02.2021 20:10;PRIORITY=10
    public static void handle(String command) {
        String[] parameterArray = command.split(";");
        String name = parameterArray[1].substring(5);
        String description = parameterArray[2].substring(12);
        LocalDateTime deadline = LocalDateTime.parse(parameterArray[3].substring(9));
        Integer priority = Integer.parseInt(parameterArray[4].substring(9));
        TaskDao.updateTask(new Task(name, description, deadline, priority));
    }
}
