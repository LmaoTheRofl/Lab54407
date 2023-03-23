package org.example.commands;

import org.example.storage.Collection;

public class ShowInfo implements Command{
    @Override
    public String execute() {
        return "класс коллекции: "+ Collection.getInstance().getAll().getClass()+"\nсоздано: " +Collection.getInstance().getFileCreationDate("Input.json")+"\nэлементов внутри: "+Collection.getInstance().getAll().size();
    }

    @Override
    public String getCommandName() {
        return "info";
    }
}
