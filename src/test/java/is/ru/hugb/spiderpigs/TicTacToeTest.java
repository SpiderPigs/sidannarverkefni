package is.ru.hugb.spiderpigs;
/**
 * Created with IntelliJ IDEA.
 * User: Grimur
 * Date: 22.11.2013
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
<<<<<<< HEAD
import org.junit.*;

import static junit.framework.Assert.*;

public class TicTacToeTest {
	
	private int board;
	
	@Test
	public void isBoardEmpty(){
		//Board empty when created
		assertEquals(true, this.board.isEmpty());
	}
	@Test
	public void boardIsNotEmpty(){
		assertEquals(false, this.board.isFull());
	}
	@Test
	public void 
=======

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class TicTacToeTest {
	

>>>>>>> 723e9fc1d9cf6e01f377506615a66c50a55233f3
}