import java.util.*;



public class RouteCost {

  public static void main(String [] args) {
    Scanner inp = new Scanner(System.in);
    TreeSet<Link> links = new TreeSet<Link>();

    try {

      /* read in Cities and Links */
      for (String line = inp.nextLine(); !line.equals("done"); line = inp.nextLine()) {
        Scanner lineScanner = new Scanner(line);

        try {
          String c1Name = lineScanner.next();
          City c1 = City.find(c1Name);
          int length = lineScanner.nextInt();
          String c2Name = lineScanner.next();
          City c2 = City.find(c2Name);
          if (lineScanner.hasNext()) {
            String color = lineScanner.next();
            Link l = LinkFactory.buildLink(c1, c2, length, color);
            if (l == null) {
              throw new InvalidLineException(line);
            }
          } else {
            Link l = LinkFactory.buildLink(c1, c2, length);
          }
        }
        catch (NoSuchElementException e) {
          throw new InvalidLineException(line, e);
        }
        if (lineScanner.hasNext()) {
          throw new InvalidLineException(line);
        }
      }

      /* read in and compute routes */
      for (String line = inp.nextLine(); !line.equals("done"); line = inp.nextLine()) {
        Scanner lineScanner = new Scanner(line);
        String c1Name = null;
        String c2Name = null;
        String col = null;

        try {
          c1Name = lineScanner.next();
          c2Name = lineScanner.next();
          if (lineScanner.hasNext()) {
            col = lineScanner.next();
            if (!LinkFactory.isValidColor(col))
              throw new InvalidLineException(line);
          }
        }
        catch (NoSuchElementException e) {
          throw new InvalidLineException(line, e);
        }

        if (lineScanner.hasNext()) {
          throw new InvalidLineException(line);
        }
        City c = City.find(c1Name);
        c.makeTree(col);
        if (!c.getLinksTo(City.find(c2Name), links)) {
          System.out.println("Error: Route not found! " + c1Name);
          return;
        }
      }

      /* print final rail network */
      int total = 0;
      System.out.println("The rail network consists of:");
      for (Link l : links) {
        System.out.println("  " + l);
        total += l.getLength();
      }
      System.out.println("The total cost is: " + total);

    }
    catch (InvalidLineException e) {
      System.out.println("Invalid line: " + e.getMessage());
    }
  }
}
