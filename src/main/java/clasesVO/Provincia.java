package main.java.clasesVO;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Provincia {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("nm")
	@Expose
	private String nm;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nm=" + nm + "]";
	}
	
	
}