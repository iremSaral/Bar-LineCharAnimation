package sample;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XmlFile {

    public ArrayList<String> parsedDoCXML = new ArrayList<String>();
    public ArrayList<String> nameList = new ArrayList<>();
    public ArrayList<String> categoryList = new ArrayList<>();
    public ArrayList<String> countryList = new ArrayList<>();
    public ArrayList<Integer> valueList = new ArrayList<>();
    public ArrayList<Integer> yearList = new ArrayList<>();

    public ArrayList<String> parseDocXML() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        int count = 0;
        FileAndChartChooser getFile = new FileAndChartChooser();
        String fileName = getFile.getFileName();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));
            document.getDocumentElement().normalize();
            NodeList dataList = document.getElementsByTagName("record");

            for (int i = 0; i < dataList.getLength(); i++) {
                Node r = dataList.item(i);
                if (r.getNodeType() == Node.ELEMENT_NODE) {
                    count++;
                    Element data = (Element) r;
                    NodeList childeNodes = r.getChildNodes();
                    for (int j = 0; j < childeNodes.getLength(); j++) {
                        Node child = childeNodes.item(j);
                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            Element detail = (Element) child;
                            //System.out.println(detail.getAttribute("name") + ": " + detail.getTextContent());
                            parsedDoCXML.add(detail.getAttribute("name") + ": " + detail.getTextContent());

                        }
                    }
                    //   System.out.println(dene.get(i));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parsedDoCXML;
    }


    public void decomposeXML() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<String> parseddoc = parseDocXML();
        for (int i = 0; i < parseddoc.size(); i++) {
            //Name
            nameList.add(parseddoc.get(i).replaceAll("Name\\:\\s", ""));
            i++;
            //Country
            countryList.add(parseddoc.get(i).replaceAll("Country\\:\\s", ""));
            i++;
            //year
            yearList.add((Integer.parseInt(parseddoc.get(i).replaceAll("[^0-9]", ""))));
            i++;
            //Value
            valueList.add((Integer.parseInt(parseddoc.get(i).replaceAll("[^0-9]", ""))));
            i++;
            //category
            categoryList.add(parseddoc.get(i).replaceAll("Category\\:\\s", ""));
            // System.out.println(name + "\n" + country + "\n" + year + "\n" + value + "\n" + category);

        }
        //test
    /*  for (int k = 0; k < nameList.size(); k++) {
            System.out.println(nameList.get(k));
            System.out.println(yearList.get(k));
            System.out.println(categoryList.get(k));
            System.out.println(countryList.get(k));
            System.out.println(valueList.get(k));
            System.out.println("*****");
        }*/
    }
}
