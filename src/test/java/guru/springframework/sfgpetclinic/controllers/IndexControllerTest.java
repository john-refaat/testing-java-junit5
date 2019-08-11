package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.assertj.core.api.Assertions.*;

/**
 * Created By john on Aug, 2019
 **/

class IndexControllerTest implements ControllerTests {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test Proper View Name is returned for Index Page")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Test Exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> indexController.oopsHandler(), () -> "My test Fail Message");
        //assertEquals("notimplemented", indexController.oopsHandler(), ()-> "Expensive message to Build");
    }

    @Test
    @Disabled("Demo of Timeout")
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
                Thread.sleep(2000);
                System.out.println("I got here");
        });

    }


    @Test
    @Disabled("Demo of Timeout")
    void testTimeoutPreemptive() {

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Preemptive: I got here");
        });

    }

    @Test
    void testAssumptionTrue() {
       //assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
        assumeTrue("GURU".equalsIgnoreCase("GURU"));

    }


    @EnabledIfEnvironmentVariable(named = "USER", matches = "john")
    @Test
    void testIfUserIsJohn() {

    }

}
