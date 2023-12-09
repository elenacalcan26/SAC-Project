import com.github.rvesse.airline.Cli;
import commands.RecommenderCli;

public class Main {
  public static void main(String[] args) {
    Cli<Runnable> cli = new Cli<>(RecommenderCli.class);
    Runnable cmd = cli.parse(args);
    cmd.run();
  }
}
