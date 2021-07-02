package task4;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import task4.entity.Person;
import task4.utils.FileLocator;
import task4.utils.FileReader;

public class Main {
    public static void main(String[] args) {
        Path path = FileLocator.getFilePath();
        List<String> strings = FileReader.readFiles(path);

        Set<Person> people = new TreeSet<>();
        addPerson(strings, people);

        System.out.println(people);
    }

    private static void addPerson(List<String> strings, Set<Person> people) {
        for (int i = 1; i < strings.size(); i++) {
            String[] s = strings.get(i).split(" ");
            people.add(new Person(s[0], s[2], LocalDate
                    .parse(s[1], DateTimeFormatter.ofPattern("dd.MM.y"))));
        }
    }
}
