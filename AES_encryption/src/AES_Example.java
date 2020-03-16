import java.util.Scanner;

public class AES_Example {

	public static void main(String[] args) {
		driver();
	}

	// The following main method is simply a driver function for the
	// Encryption_Decryption_AES class.
	static void driver() {
		Scanner sc = new Scanner(System.in);
		String userInput;

		try {
			System.out.println("Please input a message for Encryption...");
			userInput = sc.nextLine();

			// Driver for Encryption.
			System.out.println();
			System.out.println("**ENCRYPTION**");
			String encryptedMessage;
			encryptedMessage = Encryption_Decryption_AES.encrypt(userInput);

			// Driver for Decryption.
			System.out.println();
			System.out.println("**DECRYPTION**");
			String decryptedMessage;
			decryptedMessage = Encryption_Decryption_AES.decrypt(encryptedMessage);
			System.out.println("Decrypted Message: " + decryptedMessage);

		} catch (Exception e) {
			System.out.println("There has been an issue with the Encryption Process, please try again.");
		}
		sc.close();
	}
}
