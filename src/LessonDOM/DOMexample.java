package LessonDOM;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMexample {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
// Создается построитель документа
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // Создается дерево DOM документа из файла
        Document document = documentBuilder.parse("src/LessonDOM/PersonBeforeChange.xml");
        document.normalizeDocument();// приводим к форматированному виду

        printInfoAboutAllChildNodes(document.getChildNodes());

    }

    private static void printInfoAboutAllChildNodes(NodeList list) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);

            // У элементов есть два вида узлов - другие элементы или текстовая информация.
            // Потому нужно разбираться две ситуации отдельно.
            if (node.getNodeType() == Node.TEXT_NODE) {
                // Фильтрация информации, так как пробелы и переносы строчек нам не нужны. Это не информация.
                String textInformation = node.getNodeValue().replace("\n", "").trim();

                if (!textInformation.isEmpty())
                    System.out.println("Внутри элемента найден текст: " + node.getNodeValue());
            }
            // Если это не текст, а элемент, то обрабатываем его как элемент.
            else {
                // Получение атрибутов
                NamedNodeMap attributes = node.getAttributes();
                if (attributes.getLength() == 0) {
                    System.out.println("Найден элемент: " + node.getNodeName() + ", без атрибутов");
                } else {
                    // Вывод информации про все атрибуты
                    System.out.println("Найден элемент: " + node.getNodeName() + ", его атрибуты:");
                    for (int k = 0; k < attributes.getLength(); k++) {
                        System.out.println("Имя атрибута: " + attributes.item(k).getNodeName() + ", его значение: " + attributes.item(k).getNodeValue());
                    }
                }
            }

            // Если у данного элемента еще остались узлы, то вывести всю информацию про все его узлы.
            if (node.hasChildNodes())
                printInfoAboutAllChildNodes(node.getChildNodes());
        }
    }
}
