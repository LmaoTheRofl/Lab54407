package org.example.commands;

import org.example.storage.Collection;

public class ShowFirst implements  Command{
    /**
     * @return вывести первый элемент коллекции
     */
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
