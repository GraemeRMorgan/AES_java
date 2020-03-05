/**
 * Graeme Morgan 
 * CPSC 499 - Computer Security
 * Prof: Saqib Haqaq
 * Mar 5, 2020
 * 
 * The following main method is simply a driver function for the Encryption_Decryption_AES class. 
 * 
 */
public class AES_Example {

	public static void main(String[] args) {

		//Message to be Encrypted and Decrypted. 
		String message = "Hello World";
		
		
		//Driver for Encryption.
		System.out.println("**ENCRYPTION**");
		String encryptedMessage;
		encryptedMessage = Encryption_Decryption_AES.encrypt(message);
		
		
		//Driver for Decryption.
		System.out.println();
		System.out.println("**DECRYPTION**");
		String decryptedMessage;
		decryptedMessage = Encryption_Decryption_AES.decrypt(encryptedMessage);
		System.out.println("Decrypted Message: " + decryptedMessage);
		
		
	}
}
