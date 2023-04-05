package org.example.commands;

import org.example.storage.Collection;

import java.util.Scanner;

public class UpdateById implements Command{
    /**
     * обновить значение элемента коллекции, id которого равен заданному
     * @return element updated
     */
    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        long x = scanner.nextLong();
        Collection.getInstance().updateById(x);
        return "Element updated";
    }

    @Override
    public String getCommandName() {
        return "update";
    }
}
