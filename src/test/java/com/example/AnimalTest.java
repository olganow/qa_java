package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class AnimalTest {

    private Animal animal;
    private static final String UNKNOWN_ANIMAL_TYPE = "Неизвестный вид животного";
    private static final String EXCEPTION_TEXT_EXPECTED = "Неизвестный вид животного, используйте значение" +
            " Травоядное или Хищник";
    private static final String FAMILY_DESCRIPTION_TEXT_EXPECTED =
            "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFoodException() {
        Throwable throwable = catchThrowable(() -> {
            animal.getFood(UNKNOWN_ANIMAL_TYPE);
        });

        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(EXCEPTION_TEXT_EXPECTED);
    }

    @Test
    public void testGetFamily() {
        String descriptionTextActual = animal.getFamily();

        assertEquals(FAMILY_DESCRIPTION_TEXT_EXPECTED, descriptionTextActual);
    }
}