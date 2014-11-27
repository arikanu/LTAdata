package ClassAnalysis;

import java.lang.reflect.Field;
import java.util.ArrayList;

import XmlClasses.ERPRate;

public class ClassUtils {

	public static ArrayList<String> getFieldNameList(Class _class) {
		ArrayList<String> fieldList = new ArrayList<String>();
		Field[] fields = _class.getDeclaredFields();
		for (Field field : fields) {
			fieldList.add(field.getName().toString());
		}
		return fieldList;
	}
	
}
