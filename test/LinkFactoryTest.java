import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkFactoryTest {

/* Test cases
   1. buildLink(..., String color) black-box
   1a. buildLink() constructs a RedLink
   1b. buildLink() constructs a BlueLink
   1c. buildLink() returns null if the color is green
   2. buildLink() black-box
   2a. buildLink() constructs an UncoloredLink
   3. isValidColor() black-box
   3a. isValidColor() returns true if the color is red
   3a. isValidColor() returns true if the color is blue
   3a. isValidColor() returns false if the color is green
   3a. isValidColor() returns false if the color is null
 */

  public static final String city1Name = "City1";
  public static final String city2Name = "City2";
  public static final String city3Name = "City3";
  public static final String invalidColor = "blue";
  public static final int cityDistance = 3;

  /* clear the cities HashMap after every test */
  @AfterEach
  public void clearCities() {
    City.cities.clear();
  }

  @Test
  void buildLink_red() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link l = LinkFactory.buildLink(city1, city2, cityDistance, "red");
    assertTrue(l instanceof RedLink);
  }

  @Test
  void buildLink_green() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link l = LinkFactory.buildLink(city1, city2, cityDistance, "green");
    assertTrue(l instanceof GreenLink);
  }

  @Test
  void buildLink_invalidColor() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link l = LinkFactory.buildLink(city1, city2, cityDistance, "invalidColor");
    assertNull(l);
  }

  @Test
  void buildLink_uncolored() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link l = LinkFactory.buildLink(city1, city2, cityDistance);
    assertTrue(l instanceof UncoloredLink);
  }

  @Test
  void isValidColor_red() {
    assertTrue(LinkFactory.isValidColor("red"));
  }

  @Test
  void isValidColor_green() {
    assertTrue(LinkFactory.isValidColor("green"));
  }

  @Test
  void isValidColor_invalidColor() {
    assertFalse(LinkFactory.isValidColor(invalidColor));
  }

  @Test
  void isValidColor_null() {
    assertFalse(LinkFactory.isValidColor(null));
  }
}