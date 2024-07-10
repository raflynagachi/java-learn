package raflynagachi.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.TestAbortedException;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll // should be static and run only once per class
    public static void setupOnce(){
        System.out.println("Before all");
    }

    @BeforeEach // always run before each test
    public void setup(){
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After Each");
    }

    @Test
    public void testSumSuccess(){
        var result = calculator.sum(1,5);
        assertEquals(6, result);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "env", matches = "prod")
    public void testDivideWhenError(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testDisabled(){
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    // abort unit test when env is not dev
    public void testAborted(){
        var env = System.getenv("env");
        if (!"dev".equals(env)) {
            throw new TestAbortedException();
        }

        assumeTrue(env=="dev"); // other way to abort
    }

    @DisplayName("Test with parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = {1,14,5})
    public void testWithParameter(int value){
        var result = value+value;
        assertEquals(result, calculator.sum(value, value));
    }
}
