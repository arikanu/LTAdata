package TextUtils;

import java.util.ArrayList;

public class StrList {

	private ArrayList<String> list;
	
	public StrList(ArrayList<String> strList) {
		this.list = strList;
	}
	
	public String delimitedStr(String delimiter) {
		if (this.list.size() == 0) { return ""; }
		else {
			String str = this.list.get(0);
			for (int i = 1; i < this.list.size(); i++) {
				str = str + delimiter + this.list.get(i);
			}
			return str;
		}
	}
}
