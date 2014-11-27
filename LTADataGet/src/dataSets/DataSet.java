package dataSets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;

public class DataSet {

	private String fileName;
	private String apiUrl;
	private String wholeXML = "";
	
	public DataSet(String writeFileNumber, String dataSetName, String apiUrl) {
		this.fileName = "D:/Postdoc/Data/LTA/" + dataSetName + "-" + writeFileNumber;
		this.apiUrl = apiUrl;
	}
	
	public void createXmlFiles() throws IOException {
		String apiUrlSkip;
		int skip = 0;
		int connCount = 0;
		boolean cont = true;
		while (cont) {
			apiUrlSkip = apiUrl + "?$skip=" + skip;
			URLConnection conn = (new Connection(apiUrlSkip)).getConn();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			wholeXML = "";
			while ((line = br.readLine()) != null) {
				if (skip < 50) {
					wholeXML += line;
				}
			}
			System.out.println("wholexml: " + wholeXML);
						
			skip += 50;
			connCount += 1;
			if (wholeXML == "") {
				cont = false;
			} else {
				writeToFile(fileName + "-" + connCount + ".txt");
			}
			
		}
	}
	
	private void writeToFile(String currFileName) throws IOException {
		File file = new File(currFileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(wholeXML);
		bw.close();
	}

}