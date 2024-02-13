package compare;

import domain.Man;
import domain.Person;
import util.CompareObjectUtils;

public class UpdateTest {

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("刻晴", 18);
        Man man = new Man("迪卢克",20);
        String compare = CompareObjectUtils.compare(person, man);
        System.out.println(compare);
    }
}
