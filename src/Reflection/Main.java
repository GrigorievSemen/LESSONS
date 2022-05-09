package Reflection;

import Reflection.rabbit.Rabbit;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ReflectionChecker checker = new ReflectionChecker();
        Rabbit rabbit = new Rabbit();

        checker.showClassName(rabbit);
        checker.showClassFields(rabbit);
        checker.showClassMethods(rabbit);
        checker.showClassMethods(checker);
        checker.showFieldsAnnotations(rabbit);

        checker.fillPrivateFields(rabbit);
        System.out.println(rabbit.getRabbitAge());
        System.out.println(rabbit.getRabbitName());

        Object obj = checker.createNewObject(rabbit);
        checker.showClassName(obj);
    }
}
