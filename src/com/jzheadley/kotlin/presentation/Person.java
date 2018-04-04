package com.jzheadley.kotlin.presentation;

import java.util.Objects;

public class Person {
    private Country country;

    public Person() {

    }

    public Person(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(country, person.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }

    @Override
    public String toString() {
        return "Person{" +
                "country=" + country +
                '}';
    }

}
