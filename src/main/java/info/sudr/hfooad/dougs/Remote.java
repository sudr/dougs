package info.sudr.hfooad.dougs;


public class Remote {

	private final DogDoor door;

	public Remote(DogDoor door) {
		this.door = door;
	}

	public void pressButton() {
		System.out.println("SYSTEM: Pressing the remote control button...");
		if (door.isOpen()) {
			door.close();
		} else {
			door.open();
		}
	}

}
