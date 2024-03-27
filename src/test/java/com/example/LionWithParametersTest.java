package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionWithParametersTest {

    private Feline feline;
    private Lion lion;
    private Object sex;
    private boolean hasMane;

    private static final Object MALE = "Самец";
    private static final Object FEMALE = "Самка";

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    public LionWithParametersTest(Object sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {MALE, true},
                {FEMALE, false}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        lion = new Lion((String) sex, feline);
        boolean actualResult = lion.doesHaveMane();

        assertEquals(hasMane, actualResult);
    }

    @Test
    public void testGetKittens() throws Exception {
        int expectedQuantity = 3;
        Mockito.when(feline.getKittens()).thenReturn(3);
        lion = new Lion((String) sex, feline);
        int actualQuantity = lion.getKittens();

        assertEquals(expectedQuantity, actualQuantity);
    }
}
