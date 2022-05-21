package LessonExampleJUnit.Example3;

public class MyMath {
    public static int add(int a, int b){
        return a + b;
    }
    public static int addAcrossTime(int a, int b) throws InterruptedException {
       Thread.sleep(200);
        return a + b;
    }

    public static int div(int a, int b){
        return a/b;
    }

    public static int divByZero(int a, int b){ //для примера, в тесте показано что я дествительно ловлю ошибку деления на ноль, что это не ошибка в моей программе, а так и задумано
        return a/b;
    }
}
