package info.sudr.hfooad.dougs;

public class RemoteSimulator {

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		Remote remote = new Remote(door);
		System.out.println("Fido barks to go outside...");
		remote.pressButton();
		System.out.println("\nFido has gone outside...");
		System.out.println("\nFido is all done...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("...but he's stuck outside");
		System.out.println("\nFido starts barking...");
		System.out.println("\n...so Gina grabs the remote control.");
		remote.pressButton();
		System.out.println("\nFido is back inside...");
	}
}
