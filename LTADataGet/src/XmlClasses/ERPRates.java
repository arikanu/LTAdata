package XmlClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ConsoleMessages.MsgFile;
import TextUtils.StrList;
import XmlUtils.XmlClassUnloadUtils;
import XmlUtils.XmlUtils;

public class ERPRates {

	private ArrayList<ERPRate> list;
	
	public ERPRates(String filepath) throws ParserConfigurationException, SAXException, IOException {
		File file = new File(filepath);
		this.list = new ArrayList<ERPRate>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		NodeList nodeLst = XmlUtils.getNodeListFromDocByTag(doc, "entry");
		for (int s = 0; s < nodeLst.getLength(); s++) {
			Node node = nodeLst.item(s);
			this.list.add(new ERPRate(node));
		}
	}
	
	public void writeToTabDelimitedFile(String pathname, String delimiter) throws IOException {
		FileWriter fos = new FileWriter(pathname); PrintWriter dos = new PrintWriter(fos);
		XmlClassUnloadUtils.addClassHeader(ERPRate.class, dos, delimiter);
		for (ERPRate item : list) {
			dos.println(new StrList(item.getStringList()).delimitedStr(delimiter));
		}
		dos.close(); fos.close();
		MsgFile.fileCreated(pathname);
	}

	public ArrayList<ERPRate> getList() {
		return list;
	}
}
