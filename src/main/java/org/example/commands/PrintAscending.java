package org.example.commands;

import org.example.organization.Organization;
import org.example.storage.Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PrintAscending implements Command{
    @Override
    public String execute() {
       Collection.getInstance().sortAscending();
        return "Collection sorted";
    }

    @Override
    public String getCommandName() {
        return "print_ascending";
    }
}
