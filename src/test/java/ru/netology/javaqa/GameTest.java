package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(1, "Jack", 10);
    Player player2 = new Player(2, "Nick", 20);
    Player player3 = new Player(3, "Robert", 30);
    Player player4 = new Player(4, "Kris", 20);

    @Test
    public void registerTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(4, game.findAll().size());
    }

    @Test
    public void findByNamePlayerTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(player3, game.findByName("Robert"));

    }

    @Test
    public void findByNameIfNotFoundTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(null, game.findByName("Alex"));

    }


    @Test
    public void roundIf1PlayerWinTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Nick", "Jack"));

    }

    @Test
    public void roundIf2PlayerWinTest() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Jack", "Nick"));
    }

    @Test
    public void roundIfNobodyWinsTest() {
        Game game = new Game();

        game.register(player2);
        game.register(player4);

        Assertions.assertEquals(0, game.round("Nick", "Kris"));
    }

    @Test
    public void roundIfPlayer1IsNotRegisteredTest() {
        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jack", "Nick");
        });
    }

    @Test
    public void roundIfPlayer2IsNotRegisteredTest() {
        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nick", "Jack");
        });
    }
}