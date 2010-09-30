package info.sudr.hfooad.dougs;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class ICanOperateDoor extends JUnitStory {

	@org.testng.annotations.Test
    public void run() throws Throwable {
        super.run();
    }

	// Here we specify the configuration, starting from default
	// MostUsefulConfiguration, and changing only what is needed
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
				.useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader())) // where to find the stories
				.usePendingStepStrategy(new FailingUponPendingStep())
				.useStoryReporterBuilder(new StoryReporterBuilder()
												.withDefaultFormats()
												.withFormats(Format.CONSOLE, Format.TXT)); // CONSOLE and TXT reporting
	}

	// Here we specify the steps classes
	@Override
	public List<CandidateSteps> candidateSteps() {
		// varargs, can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new RemoteSteps()).createCandidateSteps();
	}
}