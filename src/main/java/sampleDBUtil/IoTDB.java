package sampleDBUtil;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IoTDB{

	@Id
	String id;
	String transportNo;
	String temp;
	String humid;
	String longitude;
	String latitude;
	String travelDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTransportNo() {
		return transportNo;
	}
	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getHumid() {
		return humid;
	}
	public void setHumid(String humid) {
		this.humid = humid;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	@Override
	public String toString() {
		return "{id=" + id + ", transportNo=" + transportNo + ", temp="
				+ temp + ", humid=" + humid + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", travelDate=" + travelDate + "}";
	}

	
}
