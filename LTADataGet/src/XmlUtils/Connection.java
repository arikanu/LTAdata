package XmlUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connection {

	//	Update 'accountKey'
	//		enter the accountKey provided by LTA.
	private String accountKey = "zm6ephUeiqSKlB+jgVYdPQ==";
	
	//	Update "uniqueId"
	//		enter the uniqueId which can be obtained by clicking the "Generate GUID" button in the
	//		http://datamall.mytransport.sg/tool.aspx
	//		after entering your "accountKey"
	private String uniqueId = "4716319f-6e95-4485-989b-7302d216d627";
	
	
	
	private URLConnection conn = null;
	
	public Connection(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			try {
				
				URLConnection conn = url.openConnection();
				conn.setRequestProperty("accept", "*/*");
				conn.addRequestProperty("AccountKey", accountKey);
				conn.addRequestProperty("UniqueUserID", uniqueId);
				this.conn = conn;
				
			} catch (IOException e) { e.printStackTrace(); }
		} catch (MalformedURLException e) { }
	}

	public URLConnection getConn() {
		return conn;
	}
	
	
		
}
