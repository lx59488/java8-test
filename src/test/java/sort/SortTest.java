package sort;

import domain.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.junit.Test;

public class SortTest {

    @Test
    public void normalSortTest() throws Exception {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("刻晴", 17));
        list.add(new Person("甘雨", 19));
        list.add(new Person("胡桃", 14));
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        list.forEach(System.out::println);
    }

    @Test
    public void lambdaSortTest() throws Exception {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("刻晴", 17));
        list.add(new Person("甘雨", 19));
        list.add(new Person("胡桃", 14));
        list.sort(Comparator.comparing(Person::getAge));
        list.forEach(System.out::println);
    }


    @Test
    public void streamSortTest() throws Exception {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("刻晴", 17));
        list.add(new Person("甘雨", 19));
        list.add(new Person("胡桃", 14));
        list.stream().sorted((p1, p2) -> p2.getAge().compareTo(p1.getAge())).forEach(System.out::println);
        System.out.println("========================");
        list.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
    }

}
