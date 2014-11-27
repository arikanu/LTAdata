package XmlUtils;

import java.io.IOException;
import java.io.PrintWriter;

import TextUtils.StrList;
import ClassAnalysis.ClassUtils;

public class XmlClassUnloadUtils {

	
	public static PrintWriter addClassHeader(Class _class, PrintWriter dos, String delimiter) throws IOException {
		dos.println(getClassHeader(_class, delimiter));
		return dos;
	}
	
	public static String getClassHeader(Class _class, String delimiter) {
		return new StrList(ClassUtils.getFieldNameList(_class)).delimitedStr(delimiter);
	}
}
