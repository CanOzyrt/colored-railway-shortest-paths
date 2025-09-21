public abstract class ColoredLink extends Link {
  String color = null;
  public ColoredLink(City c1, City c2, int len) {
    super(c1, c2, len);
  }

  /* only colored routes can use a colored link */
  @Override
  public boolean usable(String col) {
    if (color != null && color.equals(col)) {
      return true;
    }
    return false;
  }

  /* return a string representation of the Link
   * e.g. "City1 3 City2 red"
   * The city names should be in sorted order, e.g. Halifax comes before Toronto
   */
  public String toString() {
    String result = super.toString();
    if (color != null) {
      result = result + " " + color;
    }
    return result;
  }
}
