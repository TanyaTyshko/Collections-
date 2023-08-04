import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player roma = new Player(1,"Рома",100);
        Player vlad = new Player(2,"Влад",150);
        Game game = new Game();

        game.register(roma);
        game.register(vlad);

        int actual = game.round("Влад","Рома");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin () {
        Player roma = new Player(1,"Рома",150);
        Player vlad = new Player(2,"Влад",130);
        Game game = new Game();

        game.register(roma);
        game.register(vlad);

        int actual = game.round("Влад","Рома");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNoOneWins() {
        Player roma = new Player(1,"Рома",120);
        Player vlad = new Player(2,"Влад",120);
        Game game = new Game();

        game.register(roma);
        game.register(vlad);

        int actual = game.round("Влад","Рома");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player roma = new Player(1,"Рома",100);
        Player vlad = new Player(2,"Влад",130);
        Game game = new Game();

        game.register(roma);
        game.register(vlad);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Антон", "Вадим")
        );

    }
    @Test
    public void testWhenFirstPlayerNotExistOne() {
        Player roma = new Player(1,"Рома",100);
        Player vlad = new Player(2,"Влад",130);
        Game game = new Game();

        game.register(roma);
        game.register(vlad);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вадим", "Влад")
        );

    }
    @Test
    public void testWhenFirstPlayerNotExistOneTwo() {
        Player roma = new Player(1,"Рома",100);
        Player vlad = new Player(2,"Влад",130);
        Game game = new Game();

        game.register(roma);
        game.register(vlad);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вадим", "Рома")
        );

    }
}
