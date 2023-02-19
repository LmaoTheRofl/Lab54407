package org.example.commands;

import java.util.List;

public class CommandHandler {
    private List<Command> commands = List.of(
            new Add(),
            new AddIfMax(),
            new Clear(),
            new Help(),
            new Show(),
            new Exit(),
            new ExecuteScript(),
            new Save()
    );

    public String execute(String commandLine) {
        for (Command command : commands) {
            if (command.getCommandName().equals(commandLine)) {
                return command.execute();
            }
        }
        return "Incorrect commandName!\n" + new Help().execute();
    }
}
