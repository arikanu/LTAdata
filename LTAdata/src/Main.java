import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String accountKey = "zm6ephUeiqSKlB+jgVYdPQ==";
		String uniqueId = "4716319f-6e95-4485-989b-7302d216d627";
		
		HttpServletRequest request;
		
		
		ArrayList<busStopCodeSet> list = new ArrayList<busStopCodeSet>();
		int skip = 0;
		boolean cont = true;
		while (cont) {
			String apiUrl = "http://datamall.mytransport.sg/ltaodataservice.svc/BusStopCodeSet?$skip="+skip;
			apiUrl = "http://datamall.mytransport.sg/ltaodataservice.svc/ERPRateSet";
			try {
				URL url = new URL(apiUrl);
				URLConnection conn = url.openConnection();
				conn.setRequestProperty("accept", "*/*");
				conn.addRequestProperty("AccountKey", accountKey);
				conn.addRequestProperty("UniqueUserID", uniqueId);
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				StringBuilder strBuilder = new StringBuilder(); 
				String wholeXML = "";
				while ((line = br.readLine()) != null) {
					if (skip < 50) {
						wholeXML += line;
					}
				}
				System.out.println("wholexml: " + wholeXML);
				strBuilder.append(line);
				System.out.println(line);
				
				String[] splitString = strBuilder.toString().split("<m:properties>");
				for (String str : splitString) {
					System.out.println("the size is: " + list.size());
					if (str.contains("<d:BusStopCodeID m:type=\"Edm.Int32\">")) {
						int a = str.indexOf("<d:BusStopCodeID m:type=\"Edm.Int32\">") + 36;
						int b = str.indexOf("</d:BusStopCodeID>");
						String busStopCodeID = str.substring(a,b);
						a = str.indexOf("<d:Code>") + 8;
						b = str.indexOf("</d:Code>");
						String code = str.substring(a, b);
						a = str.indexOf("<d:Road>") + 8;
						b = str.indexOf("</d:Road>");
						String road = str.substring(a, b);
						a = str.indexOf("<d:Description>") + 15;
						b = str.indexOf("</d:Description>");
						String description = str.substring(a, b);
						a = str.indexOf("<d:Layout_Num>") + 14;
						b = str.indexOf("</d:Layout_Num>");
						String layout_num = str.substring(a, b);
						a = str.indexOf("<d:Max_Pages>") + 13;
						b = str.indexOf("</d:Max_Pages>");
						String max_pages = str.substring(a, b);
						a = str.indexOf("<d:Summary xml:space=\"preserve\">") + 32;
						b = str.indexOf("</d:Summary>");
						String summary = str.substring(a, b);
						a = str.indexOf("<d:CreateDate m:type=\"Edm.DateTime\">") + 36;
						b = str.indexOf("</d:CreateDate>");
						String createDate = str.substring(a, b);
						
						busStopCodeSet bs = new busStopCodeSet(busStopCodeID, code, road, description, layout_num, max_pages, summary, createDate);
						list.add(bs);
						System.out.println("id is: "+bs.getBusStopCodeID());
					}
				}
				if (list.size() % 50 == 0) {
					skip += 50;
				} else {
					cont = false;
				}
				
				//request.getSession().setAttribute("list", list);
				
				
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				//out.close();
			}
			 
		}
		System.out.println("adsf");
	}

}