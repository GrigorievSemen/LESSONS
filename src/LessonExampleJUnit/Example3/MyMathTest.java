package LessonExampleJUnit.Example3;

import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class) // необходим для метода numbers
public class MyMathTest {
    int a, b , expResult;

    public MyMathTest(int a, int b, int expResult) { // данный конструтор необходим для работы Parameterized.Parameters
        this.a = a;
        this.b = b;
        this.expResult = expResult;
    }

    @Rule
    public TestRule timeout = new Timeout(300); // тесты считаються  провалены при работе более 300мс

    @Parameterized.Parameters // для нескольких проверок значений в каждом тесте, первых два параметра это исходные данные, третий - ожидаемый результат
    public static Collection numbers(){
        return Arrays.asList(new Object [][] {{1, 2, 3}, {2, 9, 11}, {3, 3, 5}});
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAdd() {
        System.out.println("add");
//        int a = 2;
//        int b = 3;
//        int expResult = 5;
        int result = MyMath.add(a, b);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }

    @Test
    public void testAddAcrossTime() throws InterruptedException {
        System.out.println("AcrossTimeAdd");
//        int a = 2;
//        int b = 3;
//        int expResult = 5;
        int result = MyMath.addAcrossTime(a, b);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testDiv() {
        System.out.println("div");
        int a = 8;
        int b = 2;
        int expResult = 4;
        int result = MyMath.div(a, b);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void testDivByZero(){ //для примера, в тесте показано что я дествительно ловлю ошибку деления на ноль, что это не ошибка в моей программе, а так и задумано
        System.out.println("div");
        int a = 8;
        int b = 0;
        int expResult = 4;
        int result = MyMath.divByZero(a, b);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }
}