package Input;

import Handlers.CreateCommandHandler;
import Handlers.DeleteCommandHandler;
import Handlers.ReadCommandHandler;
import Handlers.UpdateCommandHandler;

public class UserInputCommand {

    private String line;

    public UserInputCommand(String line) {
        this.line = line;
    }
    public void getCommandFromLine() {
        if(line.contains("CREATE")) {
            CreateCommandHandler.handle(line);
        } else if (line.contains("UPDATE")){
            UpdateCommandHandler.handle(line);
        } else if (line.contains("READ")) {
            ReadCommandHandler.readOne(line);
        } else if (line.contains("DELETE")) {
            DeleteCommandHandler.handle(line);
        } else {
            throw new RuntimeException("Nieprawiłowa komenda");
        }
    }
}
