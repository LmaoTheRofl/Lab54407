package org.example.storage;

import com.google.gson.Gson;
import org.example.organization.Organization;

import java.io.*;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Collection {
    private final ArrayDeque<Organization> collection;

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
     * Валидация полей организации
     * @param organization организазция для проверки
     * @return результат валидации
     */
    private boolean validate(Organization organization) {
        if (organization.getId() == 0) {
            return false;
        }
        return true;
    }

    public void print() {
        collection.forEach(System.out::println);
    }

    public void clear() {
        collection.clear();
    }

    public ArrayDeque<Organization> getAll() {
        return collection;
    }

    public void add(Organization organization) {
        organization.setId(generateId());
        collection.add(organization);
    }

    private long generateId() {
        Long id = collection.stream()
                .map(Organization::getId)
                .max(Comparator.comparing(Long::longValue))
                .orElse(0L);
        return ++id;
    }
}
