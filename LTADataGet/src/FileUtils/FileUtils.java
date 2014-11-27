package FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

	public static String readAllText(String filepath) {
		Path path = Paths.get(filepath);
		try { return new String(Files.readAllBytes(path), StandardCharsets.UTF_8); }
		catch (IOException e) { e.printStackTrace(); return ""; }
	}
}
