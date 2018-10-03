package es.upm.grise.profundizacion2018.sudokuverifier;

//import static org.junit.Assert.fail;
import static org.junit.Assert.*;

//import org.junit.Test;
import org.junit.*;

public class SudokuVerifierTest {
	
	SudokuVerifier sudokuVer = new SudokuVerifier();
    
	@Test
	public void sudoku_OK() {
 		assertEquals(0, sudokuVer.verify("sudokuOK"));
    		}
	
	@Test
	public void sudoku_Negativo_O_Cero() {
 		assertEquals(-1, sudokuVer.verify("sudokuE1"));
    		}
	@Test
	public void sudoku_Repetido_Subgrid() {
 		assertEquals(-2, sudokuVer.verify("sudokuE2"));
    		}
	@Test
	public void sudoku_Repetido_Fila() {
 		assertEquals(-3, sudokuVer.verify("sudokuE3"));
    		}
	@Test
	public void sudokuRepetido_Col() {
 		assertEquals(-4, sudokuVer.verify("sudokuE4"));
    		}
	@Test
	public void sudoku_Error_Length() {
 		assertEquals(-5, sudokuVer.verify("sudokuE5"));
    		}
}
