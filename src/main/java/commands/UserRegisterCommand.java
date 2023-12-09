package commands;

import com.github.rvesse.airline.annotations.Command;
import org.apache.commons.lang3.StringUtils;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import utils.GenresEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Command(
    name = "register",
    description = "Register a new user in the recommendation system")
public class UserRegisterCommand implements Runnable {
  private TextIO textIO = TextIoFactory.getTextIO();

  @Override
  public void run() {
    registerUser();
  }

  private void registerUser() {
    String username = getUsername();
    List<String> genres = new ArrayList<>(getUserFavoriteGenres());

    System.out.println(username + " favorite genres: " + genres);
  }

  private String getUsername() {
    return textIO.newStringInputReader().read("Enter username:");
  }

  private List<String> getUserFavoriteGenres() {
    boolean isInputValid = false;
    List<String> genres = null;
    while (!isInputValid) {
      genres = textIO
        .newStringInputReader()
        .readList("Please enter your favourite genres from list:" + GenresEnum.getGenresAsList());

      genres = genres.stream().map(StringUtils::capitalize).collect(Collectors.toList());
      isInputValid = checkUserGenres(genres);

      if (!isInputValid) {
        System.out.println("One of the entered genres is invalid! Please reenter your preferences!");
      }
    }

    return genres;
  }

  private boolean checkUserGenres(List<String> userGenres) {
    return GenresEnum
        .genresStream()
        .map(GenresEnum::getGenre)
        .collect(Collectors.toSet())
        .containsAll(userGenres);
  }
}
