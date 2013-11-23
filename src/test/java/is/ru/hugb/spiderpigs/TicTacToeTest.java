package is.ru.hugb.spiderpigs;
/**
 * Created with IntelliJ IDEA.
 * User: Grimur
 * Date: 22.11.2013
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */

import org.junit.*;

import static junit.framework.Assert.*;

public class TicTacToeTest {


	private Board board;

	@Before
	public void setup() {
		board = new Board();
	}

	@Test
	public void isBoardEmpty() {
        board.setTicTacToeBoard(new String[3][3]);
		assertEquals(true, board.isEmpty());
	}
	@Test
	public void boardIsFull() {
        String[][] gameBoard = new String[3][3];

        for(int i = 0; i < 3; i++) {
            for(int a = 0; a < 3; a++) {
                gameBoard[i][a] = "T";
            }
        }

        board.setTicTacToeBoard(gameBoard);
        assertEquals(true, this.board.isFull());
	}

    @Test
    public void boardWasCleared() {
        String[][] gameBoard = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int a = 0; a < 3; a++) {
                gameBoard[i][a] = "T";
            }
        }

        this.board.setTicTacToeBoard(gameBoard);
        this.board.clearBoard();

        assertEquals(true, this.board.isEmpty());
    }

    @Test
    public void tryToChangePlayerToX() {
        String player = "O";
        assertEquals("X", this.board.changePlayer(player));
    }

    @Test
    public void tryToChangePlayerToO() {
        String player = "X";
        assertEquals("O", this.board.changePlayer(player));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryToChangePlayerToNull() {
        String player = "";
        this.board.changePlayer(player);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryToChangePlayerToIllegalValue() {
        String player = "K";
        this.board.changePlayer(player);
    }

    @Test
    public void testY0HorizontalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[0][0] = "X";
        wonGame[0][0] = "X";
        wonGame[0][0] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testY1HorizontalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[1][0] = "X";
        wonGame[1][0] = "X";
        wonGame[1][0] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }

    @Test
    public void testY2HorizontalWin() {
        String[][] wonGame = new String[3][3];
        wonGame[2][0] = "X";
        wonGame[2][0] = "X";
        wonGame[2][0] = "X";
        board.setTicTacToeBoard(wonGame);
        assertEquals(true, this.board.someoneWinner());
    }
}