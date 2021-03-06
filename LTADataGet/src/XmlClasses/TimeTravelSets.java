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

public class TimeTravelSets {

	private ArrayList<TimeTravelSet> list;
	
	public TimeTravelSets(String filepath) throws ParserConfigurationException, SAXException, IOException {
		File file = new File(filepath);
		this.list = new ArrayList<TimeTravelSet>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		NodeList nodeLst = XmlUtils.getNodeListFromDocByTag(doc, "entry");
		for (int s = 0; s < nodeLst.getLength(); s++) {
			Node node = nodeLst.item(s);
			this.list.add(new TimeTravelSet(node));
		}
	}
	

	public void writeToTabDelimitedFile(String pathname, String delimiter) throws IOException {
		FileWriter fos = new FileWriter(pathname); PrintWriter dos = new PrintWriter(fos);
		XmlClassUnloadUtils.addClassHeader(TimeTravelSet.class, dos, delimiter);
		for (TimeTravelSet item : list) {
			dos.println(new StrList(item.getStringList()).delimitedStr(delimiter));
		}
		dos.close(); fos.close();
		MsgFile.fileCreated(pathname);
	}
	
	public ArrayList<TimeTravelSet> getList() {
		return list;
	}
}
