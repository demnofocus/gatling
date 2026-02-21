import static io.gatling.javaapi.core.CoreDsl.rampUsers;

import scenarios.Scenario;

public class LoadTest extends BaseTest {

  public LoadTest() {
    super("LoadTest");
  }

  {
    setUp(
            Scenario.getPokemonDetails(getPacing("GET_POKEMON_DETAILS"), TEST_DURATION)
                .injectOpen(rampUsers(getUsers("GET_POKEMON_DETAILS")).during(RAMP_DURATION)))
        .maxDuration(RAMP_DURATION.plus(TEST_DURATION))
        .protocols(httpProtocolBuilder);
  }

  @Override
  public void before() {
    System.out.println("Running " + getTestName() + "...");
    System.out.println("Ramp Duration " + RAMP_DURATION);
    System.out.println("Test Duration " + TEST_DURATION);
  }
}
