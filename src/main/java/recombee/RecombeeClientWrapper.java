package recombee;

import com.google.common.collect.ImmutableMap;
import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.SetItemValues;
import com.recombee.api_client.api_requests.SetUserValues;
import com.recombee.api_client.exceptions.ApiException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class RecombeeClientWrapper {
  private static String DB_NAME = "acs-sac-dev";
  private static String PRIVATE_TOKEN = "qBvPhSEUkpkAt4GkFsxyeeG58QSjmD6gbrpfICSPyaY3ryRGfHHHfcEvczxsuCH9";

  private RecombeeClient client;

  private static RecombeeClientWrapper clientWrapperObject;
  private Logger logger = Logger.getLogger(RecombeeClientWrapper.class.getName());

  private RecombeeClientWrapper() {
    client = new RecombeeClient(DB_NAME, PRIVATE_TOKEN);
  }

  public static RecombeeClientWrapper getInstance() {
    if (clientWrapperObject == null) {
      clientWrapperObject = new RecombeeClientWrapper();
    }
    return clientWrapperObject;
  }

  public void registerUserRecombee(String userId, List<String> genres) throws ApiException {
    logger.info("Register user = " + userId + " with preferred genres: " + genres + " in Recombee System");
    Map<String, Object> userFavoriteGenresProperty = ImmutableMap.of(
        "favoriteGenres", new HashSet<>(genres));

    client.send(new SetUserValues(userId, userFavoriteGenresProperty)
        .setCascadeCreate(true));

    logger.info("Register done!");
  }
}
