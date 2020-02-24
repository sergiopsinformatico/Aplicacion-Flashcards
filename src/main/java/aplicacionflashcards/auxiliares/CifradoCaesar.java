package main.java.aplicacionflashcards.auxiliares;

public class CifradoCaesar {
	
	/* * * * * * * * *
	 *  Encriptacion *
	 * * * * * * * * */
	
	/* * * * * * * 
     * VARIABLES *
	 * * * * * * */
	
	int key=5;
	char ch;
	StringBuilder sB;
	
	/* * * * * * 
     * METODOS *
	 * * * * * */
	
	/*
	 * Extraido de: https://www.thejavaprogrammer.com/caesar-cipher-java-encryption-decryption/
	 */
	
	/* * * * * * * * *  *
	 *  Encriptar Texto *
	 * * * * * * * * *  */
	
	public String encryptText(String message) {
		sB = new StringBuilder();
		
		for(int i = 0; i < message.length(); ++i){
			ch = message.charAt(i);
			
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch + key);
	            
	            if(ch > 'z'){
	                ch = (char)(ch - 'z' + 'a' - 1);
	            }
	            
	            sB.append(ch);
	        }
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch + key);
	            
	            if(ch > 'Z'){
	                ch = (char)(ch - 'Z' + 'A' - 1);
	            }
	            
	            sB.append(ch);
	        }
	        else {
	        	sB.append(ch);
	        }
		}
				
		return sB.toString();
		
	}
	
	/* * * * * * * * * * * *
	 *  Desencriptar Texto *
	 * * * * * * * * * * * */
	
	public String decryptText(String message) {
		sB = new StringBuilder();
 
		for(int i = 0; i < message.length(); ++i){
			ch = message.charAt(i);
			
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch - key);
	            
	            if(ch < 'a'){
	                ch = (char)(ch + 'z' - 'a' + 1);
	            }
	            
	            sB.append(ch);
	        }
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch - key);
	            
	            if(ch < 'A'){
	                ch = (char)(ch + 'Z' - 'A' + 1);
	            }
	            
	            sB.append(ch);
	        }
	        else {
	        	sB.append(ch);
	        }
		}
		
		return sB.toString();
	}
		
}