package org.example.commands;

import org.example.storage.Collection;

public class Clear implements Command {

    @Override
    public String execute() {
        Collection.getInstance().clear();
        return "Collection cleared";
    }

    @Override
    public String getCommandName() {
        return "clear";
    }
}
