package Model;

import java.time.LocalDateTime;

public class Task {

    private String name;
    private String description;

    private LocalDateTime deadline;
     private Integer priority;

    public Task(String name, String description, LocalDateTime deadline, Integer priority) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public Integer getPriority() {
        return priority;
    }
}
