package tqs.projet.airquality;

public class Pollen {
	
	public Pollen() {}

	public Pollen(String city_name, String country_code, String state_code, double lat, double lon,
			int pollen_level_tree, int pollen_level_grass, int pollen_level_weed, int mold_level,
			String predominant_pollen_type) {
		super();
		this.city_name = city_name;
		this.country_code = country_code;
		this.state_code = state_code;
		this.lat = lat;
		this.lon = lon;
		this.pollen_level_tree = pollen_level_tree;
		this.pollen_level_grass = pollen_level_grass;
		this.pollen_level_weed = pollen_level_weed;
		this.mold_level = mold_level;
		this.predominant_pollen_type = predominant_pollen_type;
	}
	
	private String city_name;
	private String country_code;
	private String state_code;
	private double lat;
	private double lon;
	private int pollen_level_tree;
	private int pollen_level_grass;
	private int pollen_level_weed;
	private int mold_level;
	private String predominant_pollen_type;
	
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
	public int getPollen_level_tree() {
		return pollen_level_tree;
	}
	public void setPollen_level_tree(int pollen_level_tree) {
		this.pollen_level_tree = pollen_level_tree;
	}
	public int getPollen_level_grass() {
		return pollen_level_grass;
	}
	public void setPollen_level_grass(int pollen_level_grass) {
		this.pollen_level_grass = pollen_level_grass;
	}
	public int getPollen_level_weed() {
		return pollen_level_weed;
	}
	public void setPollen_level_weed(int pollen_level_weed) {
		this.pollen_level_weed = pollen_level_weed;
	}
	public int getMold_level() {
		return mold_level;
	}
	public void setMold_level(int mold_level) {
		this.mold_level = mold_level;
	}
	public String getPredominant_pollen_type() {
		return predominant_pollen_type;
	}
	public void setPredominant_pollen_type(String predominant_pollen_type) {
		this.predominant_pollen_type = predominant_pollen_type;
	}
}
