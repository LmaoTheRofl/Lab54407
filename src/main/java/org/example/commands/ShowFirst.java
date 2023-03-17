package org.example.commands;

import org.example.storage.Collection;

public class ShowFirst implements  Command{
    @Override
    public String execute() {
        return Collection.getInstance()
                .getAll()
                .stream().iterator().next().toString();
    }

    @Override
    public String getCommandName() {
        return "head";
    }
}
