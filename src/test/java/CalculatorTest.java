import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator cal;
    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getA() {
        cal.setA(4);
        assertEquals(4, 4);
    }

    @Test
    void add() {
        assertEquals(4, cal.Add(2,2));
    }





    @Test
    @DisplayName("Check 2 number is both even")
    void testBothNumberIsEven(){
        assertTrue(cal.testEven(4,6));
    }

    @Test
    @DisplayName("Subtract 2 number")
    void testSubtract(){
        assertEquals( -2, cal.Subtract(4,6));
    }

    @Test
    @DisplayName("Multiply 2 number")
    void testMultiply(){
        assertEquals( 24, cal.Multiply(4,6));
    }

    @Test
    @DisplayName("Divide 2 number")
    void testDivide(){
        assertEquals( 1.5, cal.Divide(6,4));
    }

    @Test
    @DisplayName("Divide 2 number - 2")
    void testDivide2() {
        Exception exception = assertThrows(ArithmeticException.class, () -> cal.Divide(3, 0));
        assertEquals("Divide by zero", exception.getMessage());
    }

}