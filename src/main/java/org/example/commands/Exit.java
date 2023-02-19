package org.example.commands;

public class Exit implements Command{
    @Override
    public String execute() {
        System.exit(1);
        return "finish";
    }

    @Override
    public String getCommandName() {
        return "exit";
    }
}
