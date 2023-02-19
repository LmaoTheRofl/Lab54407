package org.example.commands;

import org.example.storage.Collection;
import org.example.utils.Utils;

public class Add implements Command{
    @Override
    public String execute() {
        Collection.getInstance().add(Utils.readOrganization());
        return "Element added";
    }

    @Override
    public String getCommandName() {
        return "add";
    }
}
