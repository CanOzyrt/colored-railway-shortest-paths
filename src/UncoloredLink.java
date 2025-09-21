public class UncoloredLink extends Link {
  public UncoloredLink (City c1, City c2, int len){
    super(c1, c2, len);
  }
  /* any route can use an uncolored link */
  @Override
  public boolean usable(String col) {
      return true;
  }
}
