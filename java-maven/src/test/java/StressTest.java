public class StressTest extends BaseTest {

  public StressTest() {
    super("StressTest");
  }

  {
    setUp().maxDuration(RAMP_DURATION.plus(TEST_DURATION)).protocols(httpProtocolBuilder);
  }

  @Override
  public void before() {
    System.out.println("Running " + getTestName() + "...");
    System.out.println("Ramp Duration " + RAMP_DURATION);
    System.out.println("Test Duration " + TEST_DURATION);
  }
}
