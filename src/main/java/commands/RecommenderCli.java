package commands;

import com.github.rvesse.airline.annotations.Cli;

@Cli(
    name = "recommender",
    description = "Recommender System CLI",
    commands = {
        UserRegisterCommand.class
    }
)
public class RecommenderCli {

}
