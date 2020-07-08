package control;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameProcessTest2 {

	public static GameProcess gameControl;
	/*@Before
	public void setUp() throws Exception {
		gameControl=new GameProcess(10,10);
	}*/


	@BeforeClass
	public static void beforeClass()
	{
		gameControl=new GameProcess(10,10);
	}
	@Test
	public void testGameProcess() {
		GameProcess newGame=new GameProcess(10,10);
		assertNotSame(gameControl,newGame);
	}

	@Test
	public void testCellSavePrinciple() throws Exception{
		Method cellSavePrinciple = null;
		boolean status=false;
		
		Class rc=Class.forName("control.GameProcess");
		Object obj=rc.newInstance();
		System.out.println(rc.toString());
		if(rc!=null)
		{
			cellSavePrinciple=rc.getDeclaredMethod("cellSavePrinciple",boolean.class,int.class);	
		}
		System.out.println(cellSavePrinciple.toString());
		cellSavePrinciple.setAccessible(true);
		if(cellSavePrinciple!=null)
		{
			assertTrue((boolean)cellSavePrinciple.invoke(gameControl,false,3));
			assertEquals(true,(boolean)cellSavePrinciple.invoke(gameControl,true,2));
			assertFalse((boolean)cellSavePrinciple.invoke(gameControl, true,1));
		}	
	}

	@Test
	public void testChangeCellStatus() {
		boolean status=false;
		int row=5,col=5;
		status=gameControl.changeCellStatus(row, col);
		assertNotSame(false,gameControl.world.getCellStatus(row, col));
	}

}
