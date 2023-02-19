package org.example.commands;

import org.example.organization.Organization;
import org.example.storage.Collection;

import java.util.stream.Collectors;

public class Show implements Command{
    @Override
    public String execute() {
        return Collection.getInstance()
                .getAll()
                .stream()
                .map(Organization::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String getCommandName() {
        return "show";
    }
}
