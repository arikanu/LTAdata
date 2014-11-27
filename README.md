This program is designed for extracting:

* ERPRate

* TimeTravelSet

data sets from LTA (Land Transport Authority, http://www.lta.gov.sg/content/ltaweb/en.html).



How to use:

1)	make the required changes in (XmlUtils package) Connection.java

2)	make the required changes in (default package) ExtractDataMain.java
(required changes are noted as comment lines)

3)	Run ExtractDataMain.java to extract data

4)	Extracted data files will be located in the specified location (folderName) as Xml and delimited Txt files.

5)	make the required changes in (default package) CombineFilesMain.java

6)	Run CombineFilesMain.java to combine created Txt files in a single file



Other data sets can be found here: http://datamall.mytransport.sg/tool.aspx



In order to extract another data set:

1)	download a sample data set to find out the fields in the XML file

2)	create a class for the data set in the XmlClasses package (similar to ERPRate.java and TimeTravelSet.java)

3)	create a container class for data sets in the XmlClasses package (similar to ERPRates.java and TimeTravelSets.java)

4)	get the url of the dataset from http://datamall.mytransport.sg/tool.aspx

5)	add the following code in (default package) > main.java, just above MsgGeneral.processCompleted(); line
		(words in capitals to be updated)

	DataSet newDataSetInstance = new DataSet(folderName, dayId, "YOURDATASETNAME", "NewURL");
	newDataSetInstance.createXmlFiles(skipStartNb, itemLimit);
	for (String xmlFilepath : newDataSetInstance.getXmlFilepaths()) {
		YOUR_CONTAINER_CLASS yourContainerClass = new YOUR_CONTAINER_CLASS(xmlFilepath);
		yourContainerClass.writeToTabDelimitedFile(StrFileName.changeExtension(xmlFilepath, "txt"), delimiter);
	}
