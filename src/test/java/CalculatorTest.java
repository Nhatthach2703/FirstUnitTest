import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @DisplayName("Test add parameter")
    @CsvSource({
            "5, 2, 3",
            "7, 3, 4",
            "11, 10, 1",
            "10, 5, 5"
    })
    void testAdd(String expectedStr, String aStr, String bStr) {
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        int expected = Integer.parseInt(expectedStr);
        assertEquals(expected, cal.Add(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", numLinesToSkip = 1)
    void add3(String aStr, String bStr, String expectedStr) {
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        int expected = Integer.parseInt(expectedStr);
        assertEquals(expected, cal.Add(a, b));
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

    @ParameterizedTest
    @CsvFileSource(resources = "/test2.csv", numLinesToSkip = 1)
    @DisplayName("Divide 2 number - 3")
    void testDivide3(String aStr, String bStr, String expectedStr) {
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        if ("Divide by zero".equals(expectedStr)) {
            Exception exception = assertThrows(ArithmeticException.class, () -> cal.Divide(a, b));
            assertEquals(expectedStr, exception.getMessage());
        } else {
            double expected = Double.parseDouble(expectedStr);
            assertEquals(expected, cal.Divide(a, b));
        }
    }

}