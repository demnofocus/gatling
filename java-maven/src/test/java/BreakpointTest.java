
import io.gatling.javaapi.core.ClosedInjectionStep;
import scenarios.Scenario;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.rampConcurrentUsers;
import static io.gatling.javaapi.core.CoreDsl.constantConcurrentUsers;

public class BreakpointTest extends BaseTest {

    public BreakpointTest() {
        super("BreakpointTest");
    }

    private int getBreakPointUsers(String path, int level) {
        int base = getUsers(path);
        return base + ((base/2) * level);
    }

    private ClosedInjectionStep[] injectBreakpointConcurrentUsers(String path) {
        return new ClosedInjectionStep[] {
                rampConcurrentUsers(1).to(getBreakPointUsers(path, 1)).during(Duration.ofMinutes(1)),
                constantConcurrentUsers(getBreakPointUsers(path, 1)).during(Duration.ofMinutes(3)),
                rampConcurrentUsers(getBreakPointUsers(path, 1)).to(getBreakPointUsers(path, 2)).during(Duration.ofMinutes(1)),
                constantConcurrentUsers(getBreakPointUsers(path, 2)).during(Duration.ofMinutes(3)),
                rampConcurrentUsers(getBreakPointUsers(path, 2)).to(getBreakPointUsers(path, 3)).during(Duration.ofMinutes(1)),
                constantConcurrentUsers(getBreakPointUsers(path, 3)).during(Duration.ofMinutes(3))
        };
    }

    {
        setUp (
                Scenario.getPokemonDetails(getPacing("GET_POKEMON_DETAILS"), TEST_DURATION)
                        .injectClosed(injectBreakpointConcurrentUsers("GET_POKEMON_DETAILS"))
        ).maxDuration(TEST_DURATION).protocols(httpProtocolBuilder);
    }

    @Override
    public void before() {
        System.out.println("Running " + getTestName() + "...");
        System.out.println("Test Duration " + TEST_DURATION);
    }
}
