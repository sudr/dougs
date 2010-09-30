package info.sudr.hfooad.dougs;

public class Simulator {

	public static void main(String[] args) {
		DogDoor door = new DogDoor();
		Remote remote = new Remote(door);
		System.out.println("Fido barks to go outside...");
		remote.pressButton();
		System.out.println("\nFido has gone outside...");
		remote.pressButton();
		System.out.println("\nFido is all done...");
		remote.pressButton();
		System.out.println("\nFido is back inside...");
		remote.pressButton();
	}
}
