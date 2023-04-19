package org.example;

import org.example.commands.CommandHandler;
import org.example.storage.Collection;

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Collection collection = Collection.getInstance();
        CommandHandler commandHandler = new CommandHandler();
        if (args.length == 0) {
            System.out.println("Входной файл не задан");
        }
        if (args.length == 1) {
            String filename = args[0];
            collection.load(filename);
        }
        collection.print();

        Scanner scanner = new Scanner(System.in);
      while (scanner.hasNextLine()) {
            System.out.println(commandHandler.execute(scanner.nextLine()));
            collection.sortById();
        }


    }
}
