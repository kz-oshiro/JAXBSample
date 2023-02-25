import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlToJavaExample {
    public static void main(String[] args) throws Exception {
    	
    	String workingDir = System.getProperty("user.dir");
        File xmlFile = new File(workingDir + "/src/main/java/example.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        Node rootNode = doc.getDocumentElement();
        NodeList nodes = rootNode.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(node.getNodeName() + " : " + node.getTextContent());
            }
        }
    }
}
