package Pr2;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class Human {
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        List<Human> list = new ArrayList<>();
        Human h1 = new Human(20, "Katya", "Jackson", LocalDate.of(2003, 12, 14), 56);
        Human h2 = new Human(19, "Alicia", "Silverstone", LocalDate.of(2004, 10, 15), 54);
        Human h3 = new Human(20, "Mike", "Carter", LocalDate.of(2004, 6, 17), 78);
        Human h4 = new Human(23, "Travis", "Scott", LocalDate.of(2000, 5, 20), 80);

        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);
        Stream<Human> stream = list.stream();
        Optional<Integer> sum = stream.map(Human::getAge).reduce(Integer::sum);
        System.out.println(sum.get());
    }
}
