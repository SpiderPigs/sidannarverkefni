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
		//Board empty when created
		// assertEquals(true, this.board.isEmpty());
	}
	@Test
	public void boardIsNotEmpty() {
		// assertEquals(false, this.board.isFull());
	}

	@Test
	public void gameSomeoneWinner() {
		assertEquals(false, this.board.someoneWinner());
	}
}