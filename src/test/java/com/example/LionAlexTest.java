package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionAlexTest {
    @Mock
    private Feline feline;

    private LionAlex lionAlex;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lionAlex = new LionAlex(feline);
    }

    @Test
    public void testGetKittens() throws Exception {
        int expectedQuantity = 0;
        int actualQuantity = lionAlex.getKittens();

        assertEquals("Количество львят не соответствует ожидаемому", expectedQuantity, actualQuantity);
    }

    @Test
    public void testGetFriends() throws Exception {
        List<String> expectedFriendsList = List.of("Марти", "Глория", "Мелман");
        List<String> actualFriendsList = lionAlex.getFriends();

        assertEquals("Список друзей не соответствует ожидаемому", expectedFriendsList, actualFriendsList);
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        String expectedLivingPlace = "Нью-Йоркский зоопарк";
        String actualLivingPlace = lionAlex.getLivingPlace();

        assertEquals("Некорректное место проживания льва", expectedLivingPlace, actualLivingPlace);
    }
}