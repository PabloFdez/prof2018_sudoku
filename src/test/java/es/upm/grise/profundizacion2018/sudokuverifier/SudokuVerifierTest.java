package es.upm.grise.profundizacion2018.sudokuverifier;

//import static org.junit.Assert.fail;
import static org.junit.Assert.*;

//import org.junit.Test;
import org.junit.*;

public class SudokuVerifierTest {
	
	SudokuVerifier sudokuVer = new SudokuVerifier();
    
	@Test
	public void sudoku_OK() {
 		assertEquals(0, sudokuVer.verify("984576213513482967726139548631947852495268371872351694257613489368794125149825736"));
    		}
	
	@Test
	public void sudoku_Negativo_O_Cero() {
 		assertEquals(-1, sudokuVer.verify("980576213513482967726139548631947852495268371872351694257613489368794125149825736"));
    		}
	@Test
	public void sudoku_Repetido_Subgrid() {
 		assertEquals(-2, sudokuVer.verify("984976213413482967726139948631947852495268371872351694257613489368794125149825736"));
    		}
	@Test
	public void sudoku_Repetido_Fila() {
 		assertEquals(-3, sudokuVer.verify("984976213513482567726135948631947852495268371872351694257613489368794125149825736"));
    		}
	@Test
	public void sudokuRepetido_Col() {
 		assertEquals(-4, sudokuVer.verify("984576213513482967726139548631947852495268371872351694257613489368794125941825736"));
    		}
	@Test
	public void sudoku_Error_Length() {
 		assertEquals(-5, sudokuVer.verify("99984576213513482967726139548631947852495268371872351694257613489368794125149825736"));
    		}
}
