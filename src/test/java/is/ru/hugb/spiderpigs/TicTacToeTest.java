package is.ru.hugb.spiderpigs;
/**
 * Created with IntelliJ IDEA.
 * User: Grimur
 * Date: 22.11.2013
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
import org.junit.Test;

import static org.junit.framework.Assert.assertEquals;
import static org.junit.framework.Assert.*;

public class TicTacToeTest {
	
	private Board board;
	
	@Test
	public void isBoardEmpty(){
		// Board empty when created
		assertEquals(true, this.board.isEmpty());
	}
	@Test
	public void boardIsNotEmpty(){
		assertEquals(false, this.board.isFull());
	}
}