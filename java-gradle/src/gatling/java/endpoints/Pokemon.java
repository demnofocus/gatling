package endpoints;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.feed;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Pokemon {

  private static final FeederBuilder.Batchable<String> POKEMON_NAME_FDR =
      csv("data/pokemon_names.csv").random();

  public static ChainBuilder getPokemonDetails() {
    return feed(POKEMON_NAME_FDR)
        .exec(
            http(RequestName.T01_GET_POKEMON_DETAILS_BY_NAME.name())
                .get("pokemon/#{p_name}")
                .check(status().is(200)));
  }
}
