package info.sudr.hfooad.dougs;

public class DogDoor {

	private boolean open;

	public DogDoor() {
		open = false;
	}
	
	public DogDoor(boolean open) {
		this.open = open;
	}

	public boolean isOpen() {
		return open;
	}

	public void open() {
		System.out.println("SYSTEM: The dog door opens.");
		open = true;
	}

	public void close() {
		System.out.println("SYSTEM: The dog door closes.");
		open = false;
	}

}
