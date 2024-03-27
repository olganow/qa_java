package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


public class LionTest {

    private Lion lion;

    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.spy(new Feline());
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testGetKittens() throws Exception {
        String maleSex = "Самец";
        lion = new Lion(maleSex, feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveTextException() {
        String message = "Несуществующий пол";
        String exceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        Throwable throwable = catchThrowable(() -> {
            lion = new Lion(message, feline);
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(exceptionMessage);
    }

    @Test
    public void testDoesHaveMane() {
        boolean actual = lion.doesHaveMane();

        Assert.assertTrue(actual);
    }

    @Test
    public void testGetFood() throws Exception {
        String foodExpected = "Мясо";
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of(foodExpected));

        List<String> foodActual = lion.getFood();

        Mockito.verify(feline).getFood("Хищник");

        Assert.assertEquals("Некорректный список еды", List.of(foodExpected), foodActual);
    }
}