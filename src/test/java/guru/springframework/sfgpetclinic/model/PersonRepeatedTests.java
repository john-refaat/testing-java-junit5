package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

/**
 * Created By john on Aug, 2019
 **/

public class PersonRepeatedTests implements ModelRepeatedTests {
    @DisplayName("My Repeated Test")
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} of {totalRepetitions}")
    void myRepeatedTest() {
        System.out.println("repeated test...");

    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName()+": "+repetitionInfo.getCurrentRepetition());
    }

    @DisplayName("Another Repeated Test")
    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} of {totalRepetitions}")
    void newRepeatedTest() {

    }
}
