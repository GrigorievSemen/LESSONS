package Reflection;

import Reflection.rabbit.RabbitAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionChecker {

    public void showClassName(Object object) {
        Class clazz = object.getClass();
        System.out.println("Полное имя класса - " + clazz.getName());
        System.out.println("Имя класса - " + clazz.getSimpleName());
    }

    public void showClassFields(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Поля класса " + clazz.getSimpleName() + ":");
        for (Field field : fields) {
            System.out.println(" - " + field.getName());
        }
    }

    public void showClassMethods(Object object) {
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        System.out.println("Методы класса " + clazz.getSimpleName() + ":");
        for (Method method : methods) {
            System.out.println(" - " + method.getName());
        }
    }

    public void showFieldsAnnotations(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Аннотации класса " + clazz.getSimpleName() + ":");
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("Имя поля - " + field.getName() + ". Аннотация: " + annotation.toString());
            }
        }
    }

    public void fillPrivateFields(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Аннотации класса " + clazz.getSimpleName() + ":");
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(RabbitAnnotation.class);
            if (annotation == null) continue;

            field.setAccessible(true); // делаем приватное поле доступным
            field.set(object, "Borya");
            field.setAccessible(false);
        }
    }

    public  Object createNewObject(Object object) throws InstantiationException, IllegalAccessException {
        Class clazz = object.getClass();
        return clazz.newInstance(); // в данном примере создаеться объект с конструктором по умолчанию
    }
}
