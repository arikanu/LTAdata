import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class abc {

	public static void main(String[] args) {

		String accountKey = "zm6ephUeiqSKlB+jgVYdPQ==";
		String uniqueId = "4716319f-6e95-4485-989b-7302d216d627";

		URL url;
		HttpURLConnection connection = null;
		
		try {
			
			url = new URL("http://datamall.mytransport.sg/ltaodataservice.svc/ERPRateSet");
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			connection.setRequestProperty("accept", "*/*");
			connection.addRequestProperty("AccountKey", accountKey);
			connection.addRequestProperty("UniqueUserID", uniqueId);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
			System.out.println("disconnected");
		}

	}

}