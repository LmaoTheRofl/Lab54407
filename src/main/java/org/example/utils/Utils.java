package org.example.utils;

import org.example.organization.*;

import java.sql.Date;
import java.time.Instant;
import java.util.Locale;
import java.util.Scanner;

public class Utils {
    /**
     * метод для создани? объекта организации чтением консоли
     * @return organization
     */
    public static Organization readOrganization() {
        Scanner scanner = new Scanner(System.in);
        Organization organization = new Organization();
        System.out.println("Введите имя организации:");
        organization.setName(getName(scanner));
        System.out.println("Введите координаты организации(2 координаты float, long):");
        organization.setCoordinates(new Coordinates(getFloatId(scanner), getLongId(scanner)));
        organization.setCreationDate(Date.from(Instant.now()));
        System.out.println("Введите годовой оборот организации long:");
        organization.setAnnualTurnover(getLongId(scanner));
        System.out.println("Введите тип организации(COMMERCIAL, PUBLIC, TRUST):");
        organization.setType(getType(scanner));
        System.out.println("Введите адрес организации(имя и 3 координаты double double int):");
       organization.setOfficialAddress(new Address(getName(scanner), new Location(getDoubleId(scanner), getDoubleId(scanner), getIntId(scanner))));
        return organization;
    }

    /**
     * getters для валидации некоторых полей
     * @param scanner
     * @return values
     */
    private static float getFloatId(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                float l = Float.parseFloat(s);
                if (l > 0) {
                    return l;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }
    }
    private static int getIntId(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                int l = Integer.parseInt(s);
                if (l > 0) {
                    return l;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }
    }
    private static Integer getIntegerId(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                Integer l = Integer.valueOf(s);
                if (l > 0) {
                    return l;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }
    }
    private static double getDoubleId(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                double l = Double.parseDouble(s);
                if (l > 0) {
                    return l;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }
    }
    private static long getLongId(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                long l = Long.parseLong(s);
                if (l > 0) {
                    return l;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }
    }
    private static OrganizationType getType(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
          try{  if (s != null && s.length() > 0) {
                return OrganizationType.valueOf(s.toUpperCase(Locale.ENGLISH).trim());
            }}
            catch (IllegalArgumentException e) {
                System.out.println("Incorrect input!"); }
        }
    }
    private static String getName(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
           if (s != null && !s.isEmpty()) {
               String[] x = s.split(" ");
               if(x.length>=1) {
                return s; }
            }

        }
    }
}
