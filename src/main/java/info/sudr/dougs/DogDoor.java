package info.sudr.dougs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

	private int timeDelay = 5000;
	private boolean open;

	private final Collection<Bark> allowedBarks = new ArrayList<Bark>();

	public DogDoor() {
		open = false;
	}

	public DogDoor(boolean open) {
		this.open = open;
	}

	public DogDoor(boolean open, int timeDelay) {
		this(open);
		this.timeDelay = timeDelay;
	}

	public boolean isOpen() {
		return open;
	}

	public void open() {
		System.out.println("SYSTEM: The dog door opens.");
		open = true;

		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("SYSTEM: Timed out...");
				close();
				timer.cancel();
			}
		}, timeDelay);
	}

	public void close() {
		System.out.println("SYSTEM: The dog door closes.");
		open = false;
	}

	public void allowBark(Bark bark) {
		allowedBarks.add(bark);
	}

	public Collection<Bark> getAllowedBarks() {
		return Collections.unmodifiableCollection(allowedBarks);
	}
}
