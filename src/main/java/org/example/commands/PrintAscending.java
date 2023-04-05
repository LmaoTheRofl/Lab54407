package org.example.commands;
import org.example.storage.Collection;

public class PrintAscending implements Command{
    @Override
    public String execute() {
       Collection.getInstance().sortAscending();
        return "Collection sorted";
    }

    @Override
    public String getCommandName() {
        return "print_ascending";
    }
}
