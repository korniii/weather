
public class CityCode {
	
	//Methode ermittelt den CityCode der jeweiligen Anfrage
	
	private final String projectName = "hsreutlingenqm";
	
	public String getCityCode(String name) throws Exception{
		//name ist entweder PLZ oder Name der Stadt
		
		//Checksum generien
		MD5Hash hashCreator = new MD5Hash(name);
    	String hash = hashCreator.createHash();
		
    	//URL zusammenbauen
		String url = "http://api.wetter.com/location/index/search/"+name+"/project/"+projectName+"/cs/"+hash;

		httpRequester test = new httpRequester();
		String response = test.getResponse(url);
		
		//CityCode rausziehen
		if(response.contains("<error>")) return null;
		return (response.substring(response.indexOf("<city_code>")+11, response.indexOf("</city_code>")));

	}

}
