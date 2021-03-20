/* ----- C L A S S   A N D   C O N S T R U C T O R ----- */

public class Body {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass; 
  public String imgFileName;

  public Body(double xPos, double yPos, double xVel, double yVel, double m, String name) {
    xxPos = xPos;
    yyPos = yPos;
    xxVel = xVel;
    yyVel = yVel;
    mass = m;
    imgFileName = name;
  }
  
  public Body(Body b) {
    b = b;
  }


/* ----- M E T H O D S ----- */

/* ----- D I S T A N C E ----- */

  public double calcDistance(Body b) {
    double x1 = this.xxPos;
    double y1 = this.yyPos;
    double x2 = b.xxPos;
    double y2 = b.yyPos;
    double distance;

    distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    return distance;
  }
  
/* ----- F O R C E   E X E R T E D   B Y ----- */

  public double calcForceExertedBy(Body b) {
    double G = 6.67e-11;
    double mass1 = this.mass;
    double mass2 = b.mass;
    double radius = calcDistance(b);
    double F;

    F = G * mass1 * mass2 / Math.pow(radius, 2);
    return F;
  }

/* ----- F O R C E   E X E R T E D   B Y   X / Y ----- */

  public double calcForceExertedByX(Body b) {
    double F = calcForceExertedBy(b);
    double x1 = this.xxPos;
    double x2 = b.xxPos;
    double radius = calcDistance(b);
    double dx;

    dx = x2 - x1;
    double Fx = F * dx / radius;
    
    return Fx;
  }
  
  public double calcForceExertedByY(Body b) {
    double F = calcForceExertedBy(b);
    double radius = calcDistance(b);
    double y1 = this.yyPos;
    double y2 = b.yyPos;
    double dy;

    dy = y2 - y1;
    double Fy = F * dy / radius;

    return Fy;
  }

/* ----- N E T   F O R C E   E X E R T E D   B Y   X / Y ----- */

  public double calcNetForceExertedByX(Body[] b) {
    double netForce = 0;
    for (Body eachBody: b) {
      if(eachBody != this) {
        double force = calcForceExertedByX(eachBody);
        netForce += force; 
      }
    }
    return netForce;  
  }

  public double calcNetForceExertedByY(Body[] b) {
    double netForce = 0;
    for (Body eachBody: b) {
      if(eachBody != this) {
        double force = calcForceExertedByY(eachBody);
        netForce += force; 
      }
    }
    return netForce;  
  }

/* ----- U P D A T E   M E T H O D ----- */

  public void update(double dt, double fX, double fY) {
    double netAccelerationX;
    double netAccelerationY;
    
    netAccelerationX = fX / this.mass;
    netAccelerationY = fY / this.mass;

    xxVel = xxVel + netAccelerationX * dt;
    this.yyVel = this.yyVel + netAccelerationY * dt;

    this.xxPos = this.xxPos + this.xxVel * dt;
    this.yyPos = this.yyPos + this.yyVel * dt;
  }

/* ----- D R A W   M E T H O D ----- */

  public void draw() {
    StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
  }
}