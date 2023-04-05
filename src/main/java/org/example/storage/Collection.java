package org.example.storage;

import com.google.gson.Gson;
import org.example.organization.Organization;
import org.example.utils.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.sql.Date;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Collection {
    private ArrayDeque<Organization> collection;

    private static Collection INSTANCE;

    public static Collection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Collection();
        }
        return INSTANCE;
    }

    private Collection() {
        this.collection = new ArrayDeque<>();
    }

    /**
     * Метод? который отвечает за загрузку файла в коллекци.
     * @param filename
     */
    public void load(String filename) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(filename));
            String json = new BufferedReader(inputStreamReader).lines().collect(Collectors.joining());
            Gson gson = new Gson();
            Organization[] organizations = gson.fromJson(json, Organization[].class);
            for (Organization organization : organizations) {
                if (validate(organization)) {
                    organization.setId(generateId());
                    organization.setCreationDate(Date.from(Instant.now()));
                    collection.add(organization);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Валидация? полей организации
     * @param organization организазция для проверки
     * @return результат валидации
     */
    private boolean validate(Organization organization) {
        if (organization.getId() == null || organization.getId() <= 0) {
            return false;}
        if(organization.getName().trim().isEmpty()) {
            return false;}
        if(organization.getCoordinates().getY() > 274){
            return false;}
        if(organization.getAnnualTurnover()<=0) {
            return false;}
        if(organization.getCreationDate()==null) {
            return false;}
        if(organization.getType()==null) {
            return false;}
        if(organization.getOfficialAddress().getStreet() == null || organization.getOfficialAddress().getStreet().length()>83 || organization.getOfficialAddress().getTown() == null){
            return false;}
        return true;
    }

    public void print() {
        collection.forEach(System.out::println);
    }

    public void clear() {
        collection.clear();
    }
    public FileTime getFileCreationDate(String fileName) {
        try {
            return (FileTime) Files.getAttribute((new File(fileName)).toPath(), "creationTime");
        } catch (IOException e) {
            return null;
        }
    }

    public ArrayDeque<Organization> getAll() {
        return collection;
    }
    public void removeById(long id) {
        collection.removeIf(e -> String.valueOf(e.getId()).equals(String.valueOf(id)));
    }
    public void updateById(long id) {
        collection.removeIf(e -> String.valueOf(e.getId()).equals(String.valueOf(id)));
         Organization organization = Utils.readOrganization();
         organization.setId(id);
        collection.add(organization);
    }

    public void add(Organization organization) {
        organization.setId(generateId());
        collection.add(organization);
    }
    public void sortAscending() {
        ArrayDeque<Organization>  y = new ArrayDeque<Organization>();
        List<Organization> x = new ArrayList<Organization>(collection).stream().sorted(Comparator.comparing(Organization::getAnnualTurnover)).collect(Collectors.toList());
      y.addAll(x);
        this.collection = y;

}
public void sortByType() {
    ArrayDeque<Organization>  y = new ArrayDeque<Organization>();
    List<Organization> x = new ArrayList<Organization>(collection).stream().sorted(Comparator.comparing(Organization::getType)).collect(Collectors.toList());
    y.addAll(x);
    this.collection = y;
}

    private Long generateId() {
        Long id = collection.stream()
                .map(Organization::getId)
                .max(Comparator.comparing(Long::longValue))
                .orElse(0L);
        return ++id;
    }

}
