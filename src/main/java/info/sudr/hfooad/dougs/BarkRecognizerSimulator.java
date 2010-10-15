package info.sudr.hfooad.dougs;

public class BarkRecognizerSimulator {

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		BarkRecognizer recognizer = new BarkRecognizer(door);
		recognizer.addDog("fido");
		System.out.println("Fido barks to go outside...");
		Bark bark = new Bark("fido");
		recognizer.recognize(bark);
		System.out.println("\nFido has gone outside...");
		System.out.println("\nFido is all done...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("...but he's stuck outside");
		System.out.println("\nFido starts barking...");
		recognizer.recognize(bark);
		System.out.println("\nFido is back inside...");
	}
}
