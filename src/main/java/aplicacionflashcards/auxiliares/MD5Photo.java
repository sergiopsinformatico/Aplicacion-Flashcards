package main.java.aplicacionflashcards.auxiliares;

import java.security.MessageDigest;

public class MD5Photo {
	
	public String getMD5Photo(String photoFile){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(photoFile.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
			return sb.toString();
		}catch(Exception ex) {
			return "inventado";
		}
	}
	
}
