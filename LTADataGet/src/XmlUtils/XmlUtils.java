package XmlUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtils {

	public static NodeList getNodeListFromDocByTag(Document doc, String tag) {
		return doc.getElementsByTagName("entry");
	}
	
	public static NodeList getNodeListFromElementByTag(Element element, String tag) {
		return element.getElementsByTagName(tag);
	}
	
	public static String getFirstElementFromNodeList(NodeList nodeList) {
		Element fstNmElmnt = (Element) nodeList.item(0);
		NodeList fstNm = fstNmElmnt.getChildNodes();
		String value = ((Node) fstNm.item(0)).getNodeValue();
		return value;
	}
	
	public static String getFirstElementFromNodeByTag(Node node, String tag) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			NodeList fstNmElmntLst = XmlUtils.getNodeListFromElementByTag((Element) node, tag);
			return XmlUtils.getFirstElementFromNodeList(fstNmElmntLst);
		} else {
			return "XMLUtils-getFirstElementFromNodeByTag: Error reading node (tag = " + tag + ")";
		}
	}
	
}
