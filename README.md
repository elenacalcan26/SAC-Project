# SAC-Project
Simple CLI Tool of a Movie Recommendation System with Recombee

## Build
     ./gradlew build 

## Commands

- All CLI commands can be executed by using the `recommender_tool.sh` script from the root directory
- Make sure that the script has the proper execute permission
- Basically, this script wraps the executable jar of the Java code

### Register User

    ./recommender_tool.sh register

### Recommend Movies To User

    ./recommender_tool.sh recommend --userId [userId-from-recombee-users-db]

### User - Items Interaction Commands

#### View Movie

    ./recommender_tool.sh user-interaction view --userId [userId-from-recombee-users-db] --movieId [itemId-from-recombee-items-db]

#### Bookmark Movie
    ./recommender_tool.sh user-interaction bookmark --userId [userId-from-recombee-users-db] --movieId [itemId-from-recombee-items-db]

#### Rate Movie

    ./recommender_tool.sh user-interaction view --userId [userId-from-recombee-users-db] --movieId [itemId-from-recombee-items-db] --rating [double-data-type-value]
