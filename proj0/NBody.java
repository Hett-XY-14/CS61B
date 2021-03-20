public class NBody {
  
  /** ----- M E T H O D S ----- */

  /** ----- R E A D   R A D I U S ----- */
  public static double readRadius(String fileName) {
    In in = new In(fileName);
    
    in.readInt();
    double universeRadius = in.readDouble();
    
    return universeRadius;
  }


  public static Body[] readBodies(String fileName) {
    In in = new In(fileName);
    int size = in.readInt();
    Body bodiesArray[] = new Body[size];
    in.readDouble();

    double xPos;
    double yPos;
    double xVel;
    double yVel;
    double mass;
    String imgFile;

    for (int i = 0; i < size; i += 1) {
      xPos = in.readDouble();
      yPos = in.readDouble();
      xVel = in.readDouble();
      yVel = in.readDouble();
      mass = in.readDouble();
      imgFile = in.readString();
      
      bodiesArray[i] = new Body(xPos, yPos, xVel, yVel, mass, imgFile);
    }
    return bodiesArray;
  }

  /** -----  M  A  I  N  ----- */

  public static void main(String args[]) {
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    
    double radius = readRadius(filename);
    Body bodies[] = readBodies(filename);

    StdDraw.setScale(-radius, radius);
    StdDraw.picture(0, 0, "images/starfield.jpg");

    for(Body b: bodies) { 
      b.draw();
    }

  /** --- A n i m a t i o n --- */

    StdDraw.enableDoubleBuffering();
    double time = 0.0;
    
    for (time = 0; time <= T; time += 1) {
      double xForces[] =  new double[bodies.length];
      double yForces[] =  new double[bodies.length];
    
      for(int i = 0; i < bodies.length; i += 1) {
        xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
        yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
      }
    
      for(int i = 0; i < bodies.length; i+= 1) {
        bodies[i].update(dt, xForces[i], yForces[i]);
      }
    
      StdDraw.picture(0, 0, "images/starfield.jpg");
      
      for(Body b: bodies) {
        b.draw();
      }
      
      StdDraw.show();
      StdDraw.pause(10);
      time += dt;
    }
    
    StdOut.printf("%d\n", bodies.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < bodies.length; i++) {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
    }
  }
}