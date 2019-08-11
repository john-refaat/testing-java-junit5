package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By john on Aug, 2019
 **/

class OwnerTest implements ModelTests {

        @Test
        void dependentAssertions() {
            Owner owner = new Owner(1l, "Joe", "Buck");
            owner.setCity("Key West");
            owner.setTelephone("0044332211225");

            assertAll("Properties Test",
                    () -> assertAll("Person Properties",
                            () -> assertEquals("Joe", owner.getFirstName()),
                            () -> assertEquals("Buck", owner.getLastName())),
                    () -> assertAll("Owner Properties",
                            () -> assertEquals("Key West", owner.getCity()),
                            () -> assertEquals("0044332211225", owner.getTelephone())
                    ));
        }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings= {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource(
            {"FL, 1, 1",
            "OH, 2, 2",
            "MI, 1, 2"})
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.printf("%s %d %d\n", stateName, val1, val2);
    }


    @DisplayName("CSV Input File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvInputFileTest(String stateName, int val1, int val2) {
        System.out.printf("%s %d %d\n", stateName, val1, val2);
    }


    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.printf("%s %d %d\n", stateName, val1, val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(Arguments.of("FL", 1, 1),
                Arguments.of("OH", 2, 8),
                Arguments.of("MI", 3, 4));
    }

    @DisplayName("Cuusstom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int val1, int val2) {
        System.out.printf("%s %d %d\n", stateName, val1, val2);
    }

}