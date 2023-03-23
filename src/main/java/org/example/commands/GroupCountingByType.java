package org.example.commands;

import org.example.storage.Collection;

public class GroupCountingByType implements Command{
    @Override
    public String execute() {
        Collection.getInstance().sortByType();
        return "Collection sorted";
    }

    @Override
    public String getCommandName() {
        return "group_counting_by_type";
    }
}
