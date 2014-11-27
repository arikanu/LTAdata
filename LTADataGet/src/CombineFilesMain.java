import java.io.IOException;

import FileUtils.FolderFiles;
import FileUtils.FolderFiles.Extension;


public class CombineFilesMain {

	public static void main(String[] args) throws IOException {
		
		//	Update 'folderName'
		//		this is where Txt files created by "ExtractDataMain.java" are located
		//		combined file will be created in the same folder
		//		name of the combined files are given to ".combineFiles" function as an argument
		//			by default: _ERPRate.txt and _TravelTimeSet.txt
		String folderName = "D:/Postdoc/Data/LTA/";
		
		FolderFiles folderFilesERPRate = new FolderFiles(folderName, Extension.TXT, "ERPRate");
		folderFilesERPRate.combineFiles("_ERPRate.txt");
		FolderFiles folderFilesTravelTimeSet = new FolderFiles(folderName, Extension.TXT, "TravelTimeSet");
		folderFilesTravelTimeSet.combineFiles("_TravelTimeSet.txt");
	}

}
