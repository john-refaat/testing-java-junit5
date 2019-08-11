package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By john on Aug, 2019
 **/

class VetControllerTest implements ControllerTests {

    private VetController vetController;
    private VetService vetService;

    @BeforeEach
    void setUp() {
        vetService = new VetMapService(new SpecialityMapService());
        vetController = new VetController(vetService);
        vetService.save(new Vet(1L, "Joe", "Buck", new HashSet<>()));
        vetService.save(new Vet(2L, "Jimmy", "Smith", new HashSet<>()));
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        assertEquals("vets/index", vetController.listVets(model));
        assertThat(((Set)((ModelMapImpl) model).getMap().get("vets")).size()).isEqualTo(2);
    }
}