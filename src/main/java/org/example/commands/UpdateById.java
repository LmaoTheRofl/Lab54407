package org.example.commands;

import org.example.storage.Collection;

import java.util.Scanner;

public class UpdateById implements Command{
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
