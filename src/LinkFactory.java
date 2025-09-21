import java.util.HashSet;
import java.util.Arrays;

public class LinkFactory {

  /* set of valid link colors */
  public static final HashSet<String> validColors = new HashSet<String>(Arrays.asList("red", "green"));

  /* build a colored link
   * returns a link of the chosen color if it is valid
   * returns null if color is not valid
   */
  public static Link buildLink(City city1, City city2, int length, String color) {
    if (color.equals("red")) {
      return new RedLink(city1, city2, length);
    }
    else if (color.equals("green")) {
      return new GreenLink(city1, city2, length);
    }
    else {
      return null;
    }
  }

  /* build an uncolored link
   * returns an uncolored link
   */
  public static Link buildLink(City city1, City city2, int length) {
    return new UncoloredLink(city1, city2, length);
  }

  /* return true if and only if the color is valid
   */
  public static boolean isValidColor(String col) {
    return validColors.contains(col);

  }
}
