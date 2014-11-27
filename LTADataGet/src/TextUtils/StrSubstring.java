package TextUtils;

public class StrSubstring {

	public static String readAfterLast(String str, String readAfter) {
		return str.substring(str.lastIndexOf(readAfter) + 1);
	}
	public static String readUptoLast(String str, String readUpto) {
		return str.substring(0, str.lastIndexOf(readUpto));
	}
	
}
