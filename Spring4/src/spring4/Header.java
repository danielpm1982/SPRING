package spring4;
import java.util.TreeMap;

public class Header {
	private String appName;
	private String createdBy;
	private String site;
	private String email;
	public Header() {
	}
	public Header(String appName, String createdBy, String site, String email) {
		this.appName = appName;
		this.createdBy = createdBy;
		this.site = site;
		this.email = email;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TreeMap<String, String> getFieldsAndValues() {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("appName", getAppName());
		map.put("createdBy", getCreatedBy());
		map.put("site", getSite());
		map.put("email", getEmail());
		return map;
	}
	@Override
	public String toString() {
		return "appName: "+appName+"\ncreatedBy: "+createdBy+"\nsite: "+site+"\nemail: "+email;
	}
}
