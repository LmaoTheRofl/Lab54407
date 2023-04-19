package org.example.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.organization.Organization;
import org.example.storage.Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

public class Save implements Command{

    /**
     *  сохранить коллекцию в файл
     * @return saved
     */
    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename to save collection");
        String filename = scanner.nextLine();
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return "cannot create file";
            }
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            printWriter.write(gson.toJson(Collection.getInstance().getAll().toArray()));
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "cannot write to file";
        }
        return "saved";
    }

    @Override
    public String getCommandName() {
        return "save";
    }
    private Long generateId() {
        Long id = Collection.getInstance().getAll().stream()
                .map(Organization::getId)
                .max(Comparator.comparing(Long::longValue))
                .orElse(0L);
        return ++id;
    }
}
