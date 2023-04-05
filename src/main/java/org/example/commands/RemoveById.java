package org.example.commands;

import org.example.storage.Collection;

import java.util.Scanner;

public class RemoveById implements Command{
    /**
     *  удалить элемент из коллекции по его id
     * @return Element removed
     */
    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        long x = scanner.nextLong();
        Collection.getInstance().removeById(x);
        return "Element removed";
    }

    @Override
    public String getCommandName() {
        return "remove_by_id";
    }
}
