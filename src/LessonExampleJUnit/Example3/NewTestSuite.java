package LessonExampleJUnit.Example3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class) // анотоция говорит используй класс Suite
@Suite.SuiteClasses({MyMathTest.class}) // в скобках пишем через запятую какие классы с тестами надо запускать

public class NewTestSuite { // класс для набора тестов
}
