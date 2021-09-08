package main.java.base.functions;

import main.java.base.config.LogUtil;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.*;

public interface XmlFunctions extends TestResult {

    @Deprecated
    public default void xmlFileDelete(String xmlFileDeletePath) {
        boolean fileDeleted;
        File file = new File(xmlFileDeletePath);

        // checking file existence
        if (!file.exists()) {
            LogUtil.logger.debug("File not exist in " + xmlFileDeletePath);
        }
        // file deletion
        fileDeleted = file.delete();
        LogUtil.logger.debug("File deleted: " + fileDeleted);

    }


}
