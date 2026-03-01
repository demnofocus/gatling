package endpoints;

import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.csv;
import static io.gatling.javaapi.core.CoreDsl.feed;
import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.header;
import static io.gatling.javaapi.http.HttpDsl.status;
import static io.gatling.javaapi.http.HttpDsl.addCookie;
import static io.gatling.javaapi.http.HttpDsl.Cookie;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;


public class Pokemon {

    private static final FeederBuilder.Batchable<String> POKEMON_NAME_FDR = csv("data/pokemon_names.csv").random();

    private static final Map<CharSequence, String> AUTH_HDR = Map.of("Content-Type", "application/json");

    private static final String SECRET_ID = System.getProperty("secret_id", "");
    private static final String SECRET_KEY = System.getProperty("secret_key", "");

    public static ChainBuilder authentication() {
        return exec(session -> session.set("secret_id", SECRET_ID).set("secret_key", SECRET_KEY))
                .exec(http(RequestName.T00_AUTHENTICATION.name())
                        .post("pokemon/auth") //not real endpoint
                        .body(ElFileBody("payload/auth.json"))
                        .headers(AUTH_HDR)
                        .check(header("X-AUTH-TOKEN").saveAs("token"))
                ).exec(addCookie(Cookie("X_AUTH_TOKEN", "#{token}")));
    }

    public static ChainBuilder getPokemonDetails() {
        return feed(POKEMON_NAME_FDR)
                .exec(
                        http(RequestName.T01_GET_POKEMON_DETAILS_BY_NAME.name())
                                .get("pokemon/#{p_name}")
                                .check(status().is(200)));
    }

}
