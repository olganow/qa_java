package com.example;

import java.util.ArrayList;
import java.util.List;

public class LionAlex extends Lion {

    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        List<String> friends = new ArrayList<>();
        friends.add("Марти");
        friends.add("Глория");
        friends.add("Мелман");
        return friends;
    }

    public String getLivingPlace() {
        return "Нью-Йоркский зоопарк";
    }
}

