package org.example.commands;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExecuteScript implements Command{
    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename with script");
        String filename = scanner.nextLine();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename));
            String script = new BufferedReader(inputStreamReader).lines().collect(Collectors.joining("\n"));
            String[] commands = script.split("\n");
            CommandHandler commandHandler = new CommandHandler();
            for (String command : commands) {
                System.out.println(commandHandler.execute(command));
            }

        } catch (IOException e) {
            return "incorrect filename!";
        }

        return "Script executed!";
    }

    @Override
    public String getCommandName() {
        return "execute_script";
    }
}
