import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.*;
import edu.rpi.csci2600.u25.kuzmik2.*;

public class TicTacToeAppTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        game = new TicTacToe("X", "O", 4, 4);
        protocol = new TicTacToeProtocol(game);
    }

    @Test
    public void testGame() {
        InputStream inputStream = new ByteArrayInputStream("r\n".getBytes());
        System.setIn(inputStream);
        assertDoesNotThrow(() -> {
            TicTacToeApp.main(new String[]{"edu.rpi.csci2600.u25.kuzmik2.TicTacToeApp"});
        });
    }

    @Test
    public void testInitialState() {
        assertEquals("", game.getCell(0, 0));
        assertEquals("", game.getCell(1, 1));
        assertEquals("", game.getCell(2, 3));
    }

    @Test
    public void testProcessConfCommand() {
        assertEquals("conf OK Player(X)", protocol.process("conf X 4 3"));
    }

    private static TicTacToe game = null;
    private static TicTacToeProtocol protocol = null;
}
