package org.example.commands;

import org.example.storage.Collection;

public class GroupCountingByType implements Command{
    /**
     * сгруппировать элементы коллекции по значению поля type, вывести количество элементов в каждой группе
     * @return collection sorted
     */
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
