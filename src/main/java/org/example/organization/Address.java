package org.example.organization;

public class Address {
    private String street; //Длина строки не должна быть больше 83, Поле может быть null
    private Location town; //Поле не может быть null

    public Address(String street, Location town) {
        this.street = street;
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", town=" + town +
                '}';
    }
}
