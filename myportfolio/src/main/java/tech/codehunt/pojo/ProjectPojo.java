package tech.codehunt.pojo;

public class ProjectPojo {

	private int sn;
	private String filename;
	public ProjectPojo(int sn, String filename) {
		super();
		this.sn = sn;
		this.filename = filename;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
