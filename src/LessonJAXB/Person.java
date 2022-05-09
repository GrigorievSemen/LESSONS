package LessonJAXB;



import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = {
        "telephone",
        "name",
        "address"}) //задание последовательности элементов XML
public class Person {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class) // удаляет лишние пробелы
    @XmlID
    private String login;
    @XmlElement(required = true)
    private String name;
    @XmlAttribute(required = true)
    private String fuculty;
    @XmlElement(required = true)
    private int telephone;
    @XmlElement(required = true)
    private Address address = new Address();

    public Person(){
    }

    public Person(String login, String name, String fuculty, int telephone, Address address) {
        this.login = login;
        this.name = name;
        this.fuculty = fuculty;
        this.telephone = telephone;
        this.address = address;
    }

    public String getLogin() {return login;}

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuculty() {
        return fuculty;
    }

    public void setFuculty(String fuculty) {
        this.fuculty = fuculty;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                "\n\tlogin = " + login +
                "\n\tname = " + name +
                "\n\tfuculty =" + fuculty +
                "\n\ttelephone = " + telephone +
                 address.toString();
    }

    @XmlRootElement
    @XmlType(name = "address", propOrder = {
            "city",
            "country",
            "street"}) //задание последовательности элементов XML
    public static class Address{
        private String country;
        private String city;
        private String street;

        public Address () {

        }

        public Address(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        @Override
        public String toString() {
            return "\nAddress" +
                    "\n\tcountry = " + country +
                    "\n\tcity = " + city +
                    "\n\tstreet = " + street + "\n";
        }
    }
}
