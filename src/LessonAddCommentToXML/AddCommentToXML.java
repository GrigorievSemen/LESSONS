package LessonAddCommentToXML;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class AddCommentToXML {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        // например будем вставлять комментарий перед тегом name
        String tagName = "name";
        String comment = "Yes it's Comment!";

        DocumentBuilderFactory documentBuilderFactory =DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document= builder.parse("src/LessonComment/PersonBeforeChange.xml");

        NodeList nodeList = document.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Comment documentComment = document.createComment(comment);
            documentComment.normalize();
            Node item = nodeList.item(i);
            item.getParentNode().insertBefore(documentComment, item);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "no");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        DOMSource source = new DOMSource(document);
        File newXMLFile = new File("src/LessonComment/PersonAfterChange.xml");
        FileOutputStream fos = new FileOutputStream(newXMLFile);
        StreamResult result = new StreamResult(fos);
        transformer.transform(source, result);
    }
}
