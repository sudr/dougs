package info.sudr.hfooad.dougs;

import java.util.ArrayList;
import java.util.Collection;

public class BarkRecognizer {

	private final DogDoor door;
	private final Collection<String> dogNames = new ArrayList<String>();

	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}
	
	public void addDog(String dog) {
		dogNames.add(dog);
	}

	public void recognize(Bark bark) {
		System.out.println("BarkRecognizer: heard " + bark.getDog() + " bark.");
		if (isBarkRecognized(bark)) {
			System.out.println("BarkRecognizer: recognized " + bark.getDog() + " bark.");
			triggerDoor();
		} else {
			System.out.println("BarkRecognizer: " + bark.getDog() + " is unrecognized.");
		}
	}

	private boolean isBarkRecognized(Bark bark) {
		for (String dogName : dogNames) {
			if (dogName.equals(bark.getDog())) {
				return true;
			}
		}
		return false;
	}

	private void triggerDoor() {
		if (!door.isOpen()) {
			door.open();
		} else {
			System.out.println("SYSTEM: The dog door is already open.");
		}
	}

}
