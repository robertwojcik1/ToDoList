package Handlers;

import Dao.TaskDao;
import Model.Task;
import Utils.AuxiliaryMethods;

import java.time.LocalDateTime;

public class UpdateCommandHandler {

    public static void handle(String command) {
        String[] parameterArray = command.split(";");
        String name = parameterArray[1].substring(5);
        String description = parameterArray[2].substring(12);
        LocalDateTime deadline = AuxiliaryMethods.getDateTime(parameterArray[3]
                .substring(9));
        Integer priority = Integer.parseInt(parameterArray[4].substring(9));
        TaskDao.updateTask(new Task(name, description, deadline, priority));
    }
}
