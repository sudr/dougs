package info.sudr.hfooad.dougs;

import java.util.Timer;
import java.util.TimerTask;

public class Remote {

	private static final int TIMER_DELAY = 5000;
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
			final Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println("SYSTEM: Timed out...");
					door.close();
					timer.cancel();
				}
			}, TIMER_DELAY);
		}
	}

}
