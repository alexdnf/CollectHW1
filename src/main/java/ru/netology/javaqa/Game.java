package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public HashMap<String, Player> findAll() {
        return players;
    }

    public Player findByName(String playerName) {
        return players.get(playerName);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " не зарегистрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " не зарегистрирован");
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }

    }
}