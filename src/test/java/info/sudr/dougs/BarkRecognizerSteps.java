package info.sudr.dougs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class BarkRecognizerSteps {

	private BarkRecognizer barkRecognizer;
	private DogDoor door;
	private boolean doorState;

	@Given("that the door is $doorState and recognizes the $barkSound bark")
	public void theDoorInState(String doorState, String barkSound) {
		createDoor(doorState, barkSound);
		createBarkRecognizer();
	}

	@Given("that the door is $doorState and recognizes the barks $barkSound")
	public void theDoorInState(String doorState, List<String> barkSounds) {
		createDoor(doorState, barkSounds);
		createBarkRecognizer();
	}

	@When("$dog barks $barkSound")
	public void rexBarks(String dog, String barkSound) {
		Bark bark = new Bark(barkSound);
		barkRecognizer.recognize(bark);
		doorState = door.isOpen();
	}

	@Then("the door is $doorState")
	@Alias("the door remains $doorState")
	public void theDoorIs(String doorState) {
		boolean expectedDoorState = convertDoorStateFlag(doorState);
		assertThat(this.doorState, equalTo(expectedDoorState));
	}

	private void createDoor(String doorState, String barkSound) {
		createDoor(doorState, Arrays.asList(new String[] { barkSound }));
	}

	private void createDoor(String doorState, Collection<String> barkSounds) {
		boolean open = convertDoorStateFlag(doorState);
		door = new DogDoor(open);
		for (String sound : barkSounds) {
			door.allowBark(new Bark(sound));
		}
	}

	private void createBarkRecognizer() {
		barkRecognizer = new BarkRecognizer(door);
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
