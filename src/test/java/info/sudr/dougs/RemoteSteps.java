package info.sudr.dougs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class RemoteSteps {

	private Remote remote;
	private DogDoor door;
	private boolean doorState;

	@Given("a remote and an $doorState door")
	@Aliases(values = { "a remote and a $doorState door" })
	public void aRemote(String doorState) {
		boolean open = false;
		if ("closed".equals(doorState)) {
			open = false;
		} else if ("open".equals(doorState)) {
			open = true;
		}
		door = new DogDoor(open);
		this.remote = new Remote(door);
	}

	@When("I press the button")
	public void iPressTheButton() {
		remote.pressButton();
		doorState = door.isOpen();
	}

	@When("I press the button and wait $numberSeconds seconds")
	public void iPressTheButtonAndWait(int numberSeconds) throws InterruptedException {
		remote.pressButton();
		Thread.sleep(numberSeconds * 1000 * 2);
		doorState = door.isOpen();
	}

	@Then("the door is automatically closed")
	public void theDoorIsAutomaticallyClosed() throws InterruptedException {
		boolean expectedDoorState = false;
		assertThat(this.doorState, equalTo(expectedDoorState));
	}

	@Then("the door is $doorState")
	public void theDoorIs(String doorState) {
		boolean expectedDoorState = false;
		if ("closed".equals(doorState)) {
			expectedDoorState = false;
		} else if ("open".equals(doorState)) {
			expectedDoorState = true;
		}
		assertThat(this.doorState, equalTo(expectedDoorState));
	}

}
