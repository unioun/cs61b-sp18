public class Planet {

  double xxPos;
  double xxVel;
  double yyPos;
  double yyVel;
  double mass;
  String imgFileName;
  static final double G = 6.67E-11;
  String imgStorePath = "images/";

  public Planet(double xP, double yP, double xV, double yV, double m, String img) {
    xxPos = xP;
    xxVel = xV;
    yyPos = yP;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Planet(Planet p) {
    xxPos = p.xxPos;
    xxVel = p.xxVel;
    yyPos = p.yyPos;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = new String(p.imgFileName);
  }

  private double dx(Planet b) {
    return b.xxPos - xxPos;
  }

  private double dy(Planet b) {
    return b.yyPos - yyPos;
  }

  private double calcDistancePow(Planet b) {
    // return a double represent the square of distance
    return Math.pow(dx(b), 2) + Math.pow(dy(b), 2);
  }

  double calcDistance(Planet b) {
    /*
     * This method will take in a single Planet and should return a double equal to
     * the distance between the supplied Planet and the Planet that is doing the
     * calculation
     */
    return Math.sqrt(calcDistancePow(b));
  }

  private double calcForceExertedBy(Planet b) {
    return (G * mass * b.mass) / calcDistancePow(b);
  }

  public double calcForceExertedByX(Planet b) {
    return calcForceExertedBy(b) * dx(b) / calcDistance(b);
  }

  public double calcForceExertedByY(Planet b) {
    return calcForceExertedBy(b) * dy(b) / calcDistance(b);
  }

  public boolean equal(Planet b) {
    if ((xxPos == b.xxPos) && (yyPos == b.yyPos)) {
      return true;
    } else {
      return false;
    }
  }

  public double calcNetForceExertedByX(Planet[] Planets) {
    /*
     * Following tow method each take in an array of Planets and calculates the net
     * X
     * and net Y force exerted by all bodies in that array upon the current Planet.
     */
    double force = 0;
    for (Planet b : Planets) {
      if (equal(b)) {
        continue;
      }
      force += calcForceExertedByX(b);
    }
    return force;
  }

  public double calcNetForceExertedByY(Planet[] Planets) {
    double force = 0;
    for (Planet b : Planets) {
      if (equal(b)) {
        continue;
      }
      force += calcForceExertedByY(b);
    }
    return force;
  }

  void update(double dt, double fx, double fy) {
    double ax = fx / mass;
    double ay = fy / mass;
    xxVel += ax * dt;
    yyVel += ay * dt;
    xxPos += xxVel * dt;
    yyPos += yyVel * dt;
  }

  public void draw() {
    // StdDraw.setScale(100, -100);
    StdDraw.clear();
    StdDraw.picture(xxPos, yyPos, imgFileName);
  }
}
