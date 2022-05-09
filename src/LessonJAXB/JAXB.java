package LessonJAXB;

import java.io.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXB {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
/**
 * 1) Создание XML из объекта класса и запись в файл
 */
        JAXBContext context = JAXBContext.newInstance(Persons.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // нормализует документ, добавляет отступы и пробелы

        Persons persons = new Persons() {
            {
                // добавление первого человека
                Person.Address addr = new Person.Address("The USA", "New Yourk", "5th Manhattan");
                Person person = new Person("george", "Rassel", "MHM", 2095306, addr);
                this.add(person);

                // добавление второго человека
                addr = new Person.Address("Mexico", "Mexico city", "23th Simona st.");
                person = new Person("cheko", "Peres", "OPO", 5468932, addr);
                this.add(person);
            }
        };
        m.marshal(persons, new FileOutputStream("src/LessonJAXB/PersonTest.xml"));

        /**
         * 2) Создание объекта из XML файла
         */
        Unmarshaller u = context.createUnmarshaller();
        Persons persons1 = (Persons) u.unmarshal(new FileReader("src/LessonJAXB/PersonTest.xml"));
        System.out.println(persons1);
    }
}
