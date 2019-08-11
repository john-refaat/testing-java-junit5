package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By john on Aug, 2019
 **/

class PersonTest implements ModelTests {

    @Test
    void groupedAssertons() {
        Person person = new Person(1l, "Joe", "Buck");
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName()));
    }


    @Test
    void groupedAssertonsMsgs() {
        Person person = new Person(1l, "Joe", "Buck");
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name failed"),
                    () -> assertEquals("Buck", person.getLastName(), "Last Name Failed"));
    }


}