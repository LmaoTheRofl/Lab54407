package org.example.commands;

import org.example.organization.Organization;
import org.example.storage.Collection;

import java.util.Comparator;
import java.util.Optional;

import static org.example.utils.Utils.readOrganization;

public class AddIfMax implements Command {

    @Override
    public String execute() {
        Organization organization = readOrganization();
        Optional<Organization> maxElement = Collection.getInstance().getAll()
                .stream()
                .max(Comparator.comparing(Organization::getAnnualTurnover));
        if (maxElement.isPresent()) {
            if (maxElement.get().getAnnualTurnover() < organization.getAnnualTurnover()) {
                Collection.getInstance().add(organization);
                return "Element was added";
            } else {
                return "Current element not a max";
            }
        } else {
            return "No max element in collection!";
        }
    }

    @Override
    public String getCommandName() {
        return "add_if_max";
    }
}
