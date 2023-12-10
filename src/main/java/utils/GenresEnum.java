package utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GenresEnum {
  HORROR("Horror"),
  SCIFI("Sci-Fi"),
  DRAMA("Drama"),
  CRIME("Crime"),
  MYSTERY("Mystery"),
  THRILLER("Thriller"),
  ACTION("Action"),
  ADVENTURE("Adventure"),
  ROMANCE("Romance"),
  COMEDY("Comedy"),
  MUSICAL("Musical"),
  FANTASY("Fantasy")
  ;

  private final String genre;
  GenresEnum(String genre) {
    this.genre = genre;
  }

  public String getGenre() {
    return genre;
  }

  public static List<GenresEnum> getGenresAsList() {
    return Stream.of(GenresEnum.values()).collect(Collectors.toList());
  }

  public static Stream<GenresEnum> genresStream() {
    return Stream.of(GenresEnum.values());
  }
  
}
