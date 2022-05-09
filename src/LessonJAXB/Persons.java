package LessonJAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Persons {

    @XmlElement(name = "person")
    private ArrayList<Person> list = new ArrayList<>();
    public Persons(){}

    public void setList(ArrayList<Person> list) {
        this.list = list;
    }
    public boolean add(Person person){
        return  list.add(person);
    }

    @Override
    public String toString() {
        return "Persons{" +
                "\n\tlist=" + list +
                '}';
    }
}
