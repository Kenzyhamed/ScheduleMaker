package edu.ucalgary.oop;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class AnimalTest {

    @Test
    public void testGetAnimalID() {
        Animal animal = new Animal(16, "Fido", "coyote", "crepuscular");
        assertEquals(16, animal.getAnimalID());
    }

    @Test
    public void testGetAnimalNickname() {
        Animal animal = new Animal(16, "Fido", "coyote", "crepuscular");
        assertEquals("Fido", animal.getAnimalNickname());
    }

    @Test
    public void testGetAnimalSpecies() {
        Animal animal = new Animal(16, "Fido", "coyote", "crepuscular");
        assertEquals("crepuscular", animal.getAnimalSpecies());
    }

    @Test
    public void testGetAnimalType() {
        Animal animal = new Animal(16, "Fido", "coyote", "crepuscular");
        assertEquals("coyote", animal.getAnimalType());
    }
    @Test
    public void testGetOrphanTrue() {
        Animal animal = new Animal(16, "Fido", "coyote", "crepuscular");
        Treatment treatment = new Treatment( animal.getAnimalID(),1, 0, 31);
        ArrayList<String> addTreatment = new ArrayList<String>();
        addTreatment.add("16");
        addTreatment.add("1");
        addTreatment.add("0");
        Treatments.getOrderedTreatments().put(31, addTreatment);
        assertEquals(true, animal.getOrphan());
    }

    @Test
    public void testGetOrphanFalse() {
        Animal animal = new Animal(16, "Fido", "coyote", "crepuscular");
        Treatment treatment = new Treatment( animal.getAnimalID() ,2, 0, 31);
        ArrayList<String> addTreatment = new ArrayList<String>();
        addTreatment.add("16");
        addTreatment.add("2");
        addTreatment.add("0");
        Treatments.getOrderedTreatments().put(31, addTreatment);
        assertEquals(false, animal.getOrphan());
    }
}
