package commands;

import com.github.rvesse.airline.annotations.Cli;
import com.github.rvesse.airline.annotations.Group;

@Cli(
    name = "recommender",
    description = "Recommender System CLI",
    groups = {
        @Group(
            name = "user-interaction",
            description = "Commands for user - item interaction",
            commands = {
                ViewItemCommand.class,
                BookmarkItemCommand.class,
                RateItemCommand.class
            }
        )
    },
    commands = {
        UserRegisterCommand.class,
        ItemsRecommendationCommand.class
    }
)
public class RecommenderCli {

}
