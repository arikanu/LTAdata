
public class busStopCodeSet {

	private String busStopCodeID ;
	private String code;
	private String road;
	private String description;
	private String layout_num;
	private String max_pages;
	private String summary;
	private String createDate;
	
	public busStopCodeSet(String busStopCodeID, String code, String road, String description, String layout_num, String max_pages, String summary, String createDate){
		
		this.busStopCodeID = busStopCodeID;
		this.code = code;
		this.road = road;
		this.description = description;
		this.layout_num = layout_num;
		this.max_pages = max_pages;
		this.summary = summary;
		this.createDate = createDate;
	}

	public String getBusStopCodeID() {
		return busStopCodeID;
	}
	public String getCode() {
		return code;
	}
	public String getRoad() {
		return road;
	}
	public String getDescription() {
		return description;
	}
	public String getLayout_num() {
		return layout_num;
	}
	public String getMax_pages() {
		return max_pages;
	}
	public String getSummary() {
		return summary;
	}
	public String getCreateDate() {
		return createDate;
	}
}
