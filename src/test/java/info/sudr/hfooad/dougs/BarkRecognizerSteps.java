package info.sudr.hfooad.dougs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Timer;
import java.util.TimerTask;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class BarkRecognizerSteps {

	private BarkRecognizer barkRecognizer;
	private DogDoor door;
	private boolean doorState; 

	@Given("that the door is $doorState and $dogName door")
	public void theDoorInState(String doorState, String dogName) {
		createDoor(doorState);
		createBarkRecognizer(dogName);
	}

	@Given("that the door is $doorState and $dogName door with $timeDelayinSeconds sec timer")
	public void theDoorInStateWithTimeDelay(String doorState, String dogName, int timeDelayInSeconds) {
		createDoor(doorState, timeDelayInSeconds * 1000);
		createBarkRecognizer(dogName);
	}

	@When("$dog barks")
	public void rexBarks(String dog) {
		Bark bark = new Bark(dog);
		barkRecognizer.recognize(bark);
		doorState = door.isOpen();
	}

	@Then("the door is $doorState for $timeInSeconds secs")
	public void theDoorIsOpenForTime(String doorState, int timeInSeconds) {
		final boolean expectedDoorState = convertDoorStateFlag(doorState);
		final Timer timer = new Timer();
		timer.schedule(new DoorTimer(this.doorState, expectedDoorState), timeInSeconds*1000);
	}
	
	@Then("the door is $doorState")
	@Alias("the door remains $doorState")
	public void theDoorIs(String doorState) {
		boolean expectedDoorState = convertDoorStateFlag(doorState);
		assertThat(this.doorState, equalTo(expectedDoorState));
	}
	
	private class DoorTimer extends TimerTask {

		private boolean doorState;
		private boolean expectedDoorState;

		public DoorTimer(boolean doorState, boolean expectedDoorState) {
			this.doorState = doorState;
			this.expectedDoorState = expectedDoorState;
		}
		
		@Override
		public void run() {
			assertThat(this.doorState, equalTo(expectedDoorState));
			cancel();
		}
		
	}
	
	private void createDoor(String doorState) {
		boolean open = convertDoorStateFlag(doorState);
		door = new DogDoor(open);
	}

	private void createDoor(String doorState, int timeDelay) {
		boolean open = convertDoorStateFlag(doorState);
		door = new DogDoor(open, timeDelay);		
	}
	
	private void createBarkRecognizer(String dogName) {
		barkRecognizer = new BarkRecognizer(door);
		barkRecognizer.addDog(dogName);
	}
	
	private boolean convertDoorStateFlag(String doorState) {
		boolean open = false;
		if ("closed".equals(doorState)) {
			open = false;
		} else if ("open".equals(doorState) || "opened".equals(doorState)) {
			open = true;
		}
		return open;
	}
	
}
