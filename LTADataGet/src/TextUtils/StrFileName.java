package TextUtils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StrFileName {

	public static String getFilenameFromFullPathExt(String pathname) {
		Path path = Paths.get(pathname);
		return path.getFileName().toString();
	}
	
	public static String clearExtensionFromFilename(String filename) {
		return StrSubstring.readUptoLast(filename, ".");
	}
	
	public static String getFilenameFromFullPath(String pathname) {
		return StrSubstring.readUptoLast(getFilenameFromFullPathExt(pathname), ".");
	}
	
	public static String getOnlyPath(String pathname) {
		return StrSubstring.readUptoLast(pathname, getFilenameFromFullPathExt(pathname));
	}
	
	public static String changeExtension(String pathname, String newExt) {
		return getOnlyPath(pathname) + getFilenameFromFullPath(pathname) + "." + newExt;
	}
}
