import java.math.BigInteger;
import java.security.*;

public class MD5Hash {
	
	private final String projectName = "hsreutlingenqm";
	private final String apiKey = "2f0c8a31f8dac0b84c5b871c5a9f7200";
	private String SearchString;
	
	public MD5Hash(String SearchString){
		this.SearchString=SearchString;
	}

	public  String createHash() throws Exception {
		
		String all = projectName+apiKey+SearchString;
		
		byte[] bytesOfMessage = all.getBytes("UTF-8") ;

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		BigInteger bigInt = new BigInteger(1,thedigest);
		String hashtext = bigInt.toString(16);

		return hashtext;

	}

}
