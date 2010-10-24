package info.sudr.dougs;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

public class BarkRecognizer {

	private final DogDoor door;

	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}

	public void recognize(Bark bark) {
		System.out.println("BarkRecognizer: heard " + bark.getSound() + " bark.");
		if (isBarkRecognized(bark)) {
			System.out.println("BarkRecognizer: recognized " + bark.getSound() + " bark.");
			triggerDoor();
		} else {
			System.out.println("BarkRecognizer: " + bark.getSound() + " is unrecognized.");
		}
	}

	private boolean isBarkRecognized(Bark bark) {
		int matches = CollectionUtils.countMatches(door.getAllowedBarks(), PredicateUtils.equalPredicate(bark));
		return matches > 0;
	}

	private void triggerDoor() {
		if (!door.isOpen()) {
			door.open();
		} else {
			System.out.println("SYSTEM: The dog door is already open.");
		}
	}

}
