package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetVegetarianFood() throws Exception {
        List<String> expected = Arrays.asList("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");

        assertEquals(expected, actual);
    }

    @Test
    public void testGetNotVegetarianFood() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = animal.getFood("Хищник");

        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testGetFoodUnknownAnimalTypeThrowsException() throws Exception {
        animal.getFood("Другое");
    }

    @Test
    public void testGetFamilyDescription() {
        String descriptionTextExpected =
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String descriptionTextActual = animal.getFamily();

        assertEquals(descriptionTextExpected, descriptionTextActual);
    }
}