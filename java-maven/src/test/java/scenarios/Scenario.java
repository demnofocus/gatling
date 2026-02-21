package scenarios;

import static io.gatling.javaapi.core.CoreDsl.pace;
import static io.gatling.javaapi.core.CoreDsl.scenario;

import endpoints.Pokemon;
import io.gatling.javaapi.core.ScenarioBuilder;
import java.time.Duration;

public class Scenario {

  public static ScenarioBuilder getPokemonDetails(Duration pace, Duration testDuration) {
    return scenario(ScenarioName.S01_GET_POKEMON_DETAILS.name())
        .during(testDuration)
        .on(pace(pace).exec(Pokemon.getPokemonDetails()).pause(1));
  }
}
