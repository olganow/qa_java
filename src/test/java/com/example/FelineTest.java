package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private static final int KITTENS_NUMBER_EXPECTED = 1;

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Количество котят не соответствует ожидаемому", expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittens() {
        int kittensNumberActual = feline.getKittens();
        Mockito.verify(feline).getKittens(KITTENS_NUMBER_EXPECTED);

        assertEquals("Количество котят не соответствует ожидаемому",
                KITTENS_NUMBER_EXPECTED, kittensNumberActual);
    }

    @Test
    public void testGetKittensWithParams() {
        int kittensNumberExpected = 3;
        int kittensNumberActual = feline.getKittens(kittensNumberExpected);
        assertEquals("Количество котят не соответствует ожидаемому",
                kittensNumberExpected, kittensNumberActual);
    }
}