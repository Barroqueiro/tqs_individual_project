package tqs.projet.airquality;

public class AirQuality {
	
	private String city_name;
	private String country_code;
	private String state_code;
	private double lat;
	private double lon;
	private int aqi;
	private int o3;
	private int so2;
	private int no2;
	private int co;
	private int pm10;
	private int pm25;
	
	public AirQuality() {

	}

	public AirQuality(String location, String country, String state, double lat, double lon, int aqi, int o3, int so2,
			int no2, int co, int pm10, int pm25) {
		super();
		this.city_name = location;
		this.country_code = country;
		this.state_code = state;
		this.lat = lat;
		this.lon = lon;
		this.aqi = aqi;
		this.o3 = o3;
		this.so2 = so2;
		this.no2 = no2;
		this.co = co;
		this.pm10 = pm10;
		this.pm25 = pm25;
	}
	
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public int getAqi() {
		return aqi;
	}
	public void setAqi(int aqi) {
		this.aqi = aqi;
	}
	public int getO3() {
		return o3;
	}
	public void setO3(int o3) {
		this.o3 = o3;
	}
	public int getSo2() {
		return so2;
	}
	public void setSo2(int so2) {
		this.so2 = so2;
	}
	public int getNo2() {
		return no2;
	}
	public void setNo2(int no2) {
		this.no2 = no2;
	}
	public int getCo() {
		return co;
	}
	public void setCo(int co) {
		this.co = co;
	}
	public int getPm10() {
		return pm10;
	}
	public void setPm10(int pm10) {
		this.pm10 = pm10;
	}
	public int getPm25() {
		return pm25;
	}
	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}
	@Override
	public String toString() {
		return "AirQuality [city_name=" + city_name + ", country_code=" + country_code + ", state_code=" + state_code
				+ ", lat=" + lat + ", lon=" + lon + ", aqi=" + aqi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aqi;
		result = prime * result + ((city_name == null) ? 0 : city_name.hashCode());
		result = prime * result + co;
		result = prime * result + ((country_code == null) ? 0 : country_code.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + no2;
		result = prime * result + o3;
		result = prime * result + pm10;
		result = prime * result + pm25;
		result = prime * result + so2;
		result = prime * result + ((state_code == null) ? 0 : state_code.hashCode());
		return result;
	}
	
}
