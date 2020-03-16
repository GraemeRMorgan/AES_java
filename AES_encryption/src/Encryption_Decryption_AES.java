
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption_Decryption_AES {
	//Key must be 128 bits (16 characters)
	private static final String key = "unbcCompScience1";
	//Initialization Vector must be 128 bits (16 characters)
	private static final String initVector = "thisMustBe16Char";

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Encryption 
	public static String encrypt(String value) {
		try {
			//Print the original message.
			System.out.println("Original Message: \t\t" + value);

			
			//128 bit Initialization vector. 
			IvParameterSpec vector = new IvParameterSpec(initVector.getBytes("UTF-8"));			
			//Generate a 128 bit secret key.
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			//Generate a cipher using the initialization vector and the secretKey.
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, vector);
			
			
			
			
			//Convert the encrypted data to a byte array.
			byte[] encrypted = cipher.doFinal(value.getBytes());
			// Print the current byte array:
			System.out.print("Encrypted Byte Array: \t\t");
			printByteArray(encrypted);
		

			
			
			/**
			 *  Encoding the byte array using Base64. Not necessary but 
			 *  this would be done in practice. This allows the array to 
			 *  be delivered in a non-binary form. Not as important for textual
			 *  messages, but if you were emailing an encrypted image, it MUST be 
			 *  encoded to Base64, or other similar ASCII encoding tools. Mail 
			 *  servers expect ASCII and if they receive a binary message, the 
			 *  message contents will be corrupted. 
			 */
			Base64.Encoder encoder = Base64.getEncoder();
			//This is done just for demonstration.
			byte[] encoded = encoder.encode(value.getBytes());
			//This is what we're actually using.
			byte[] encryptedEncoded = encoder.encode(encrypted);

			// Print the Encoded and Encrypted byte arrays.
			System.out.print("Encoded Original Message: \t");
			printByteArray(encoded);
			System.out.print("Encoded/Encrypted Message: \t");
			printByteArray(encryptedEncoded);
			
			
			//Print the Encoded bits.
			printBitArray(encoded, "Encoded Binary: " );
			//Print the Encrypted bits.
			printBitArray(encrypted, "Encrypted Binary: ");
			//Print the Encrypted/Encoded bits.
			printBitArray(encryptedEncoded, "Encrypted/Encoded Binary: ");
			
			

			//Cast the Encrypted/Encoded data to a String and return. 
			String encryptedMessage = new String(encryptedEncoded);
			return encryptedMessage;


		} catch (Exception ex) {
			System.out.println("There has been an error encrypting the message.");
			ex.printStackTrace();
		}
		return null;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Decryption
	 
	public static String decrypt(String encrypted) {
	    try {
	    	
	    	//128 bit Initialization Vector from vector in Encrypt Object.
	        IvParameterSpec vector = new IvParameterSpec(initVector.getBytes("UTF-8"));
	        //Generate the 128 bit secret key.
	        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	        //Generate the decryption cipher.
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, vector);
	        
	        
	        
	        //Decode the Encoded data.
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] decoded = decoder.decode(encrypted);
			
			
			
			//Now Decrypt the Decoded byte array.
	        byte[] original = cipher.doFinal(decoded);
	 
	        
	        //Cast the data to a String and return the original message. 
	        return new String(original);
	        
	    } catch (Exception ex) {
	    	System.out.println("There has been an issue decrypting the message.");
	        ex.printStackTrace();
	    }
	 
	    return null;
	}

	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Simple function to print a byte array.
	static void printByteArray(byte[] barr) {
		for (int i : barr) {
			System.out.print((char) i);
		}
		System.out.println();
	}
	
	
	// Simple function to print a bit stream. 
	static void printBitArray(byte[] barr, String printMessage) {
		System.out.println(printMessage);
		for (byte b : barr) {
		    System.out.print(Integer.toBinaryString(b & 255 | 256).substring(1));
		}
		System.out.println();
	}

}
