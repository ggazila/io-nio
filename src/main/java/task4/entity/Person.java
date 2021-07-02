package task4.entity;

import java.time.LocalDate;
import java.time.Period;

public class Person implements Comparable<Person> {
    private String name;
    private String location;
    private LocalDate birthday;

    public Person(String name, String location, LocalDate birthday) {
        this.name = name;
        this.location = location;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        int birthday = Period.between(getBirthday(),LocalDate.now())
                .getYears();
        return "Person{" + " name='" + name + '\'' + ", location='" + location
                + '\'' + ", year=" + birthday + '}';
    }

    @Override
    public int compareTo(Person o) {
        return getBirthday().compareTo(o.getBirthday());
    }
}
