import java.io.IOException;

import dataSets.DataSet;


public class main {

	public static void main(String[] args) throws IOException {

		String dayId = "0";
		
		new DataSet(dayId, "ERPRate", "http://datamall.mytransport.sg/ltaodataservice.svc/ERPRateSet").createXmlFiles();
		new DataSet(dayId, "TravelTimeSet", "http://datamall.mytransport.sg/ltaodataservice.svc/TravelTimeSet").createXmlFiles();	
		
	}

}
