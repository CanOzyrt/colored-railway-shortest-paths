import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Test cases
   1. usable black-box
   1a. red links are only usable on red routes
   1b. blue links are only usable on blue routes
   2. toString black-box
   2a. red links print the color
   2b. blue links print the color

 */

class ColoredLinkTest {

  public static final String city1Name = "City1";
  public static final String city2Name = "City2";
  public static final String invalidColor = "blue";
  public static final int cityDistance = 3;

  @Test
  void usable_red() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link redLink = LinkFactory.buildLink(city1, city2, cityDistance, "red");
    assertTrue(redLink.usable("red"));
    assertFalse(redLink.usable("green"));
    assertFalse(redLink.usable(invalidColor));
    assertFalse(redLink.usable(null));
  }

  @Test
  void usable_green() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link greenLink = LinkFactory.buildLink(city1, city2, cityDistance, "green");
    assertTrue(greenLink.usable("green"));
    assertFalse(greenLink.usable("red"));
    assertFalse(greenLink.usable(invalidColor));
    assertFalse(greenLink.usable(null));
  }

  @Test
  void testToString_red() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link redLink = LinkFactory.buildLink(city1, city2, cityDistance, "red");
    assertEquals(redLink.toString(), city1Name + " " + cityDistance + " " + city2Name + " red");
  }

  @Test
  void testToString_green() {
    City city1 = new City(city1Name);
    City city2 = new City(city2Name);
    Link greenLink = LinkFactory.buildLink(city1, city2, cityDistance, "green");
    assertEquals(greenLink.toString(), city1Name + " " + cityDistance + " " + city2Name + " green");
  }
}