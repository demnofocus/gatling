import io.gatling.javaapi.core.Simulation;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.http.HttpDsl.Proxy;
import static io.gatling.javaapi.http.HttpDsl.http;

public class BaseTest extends Simulation {

    public static final Duration TEST_DURATION = Duration.ofMinutes(
            Integer.parseInt(System.getProperty("duration","2")));
    public static final Duration RAMP_DURATION = Duration.ofMinutes(
            Integer.parseInt(System.getProperty("ramp_duration","2")));

    public final Config PROPERTIES = ConfigFactory.load("properties.conf");
    public final Config USER_PACING = ConfigFactory.load("properties.conf");

    public final HttpProtocolBuilder httpProtocolBuilder =
            http.baseUrl(PROPERTIES.getString("poke_api")).disableCaching()
//            .proxy(Proxy("localhost", 8888).https())
            ;

    private final String TEST_NAME;

    public BaseTest(String testName) {
        this.TEST_NAME = testName;
    }

    public String getTestName() {
      return TEST_NAME;
    }

    public int getUsers(String path) {
        return USER_PACING.getConfig(TEST_NAME).getConfig(path).getInt("users");
    }

    public int getPacing(String path) {
        return USER_PACING.getConfig(TEST_NAME).getConfig(path).getInt("pace");
    }

}
