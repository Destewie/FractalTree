import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

int len = 200;
float spessore = 10.0f;
int mode = 0; //modo in cui viene disegnato l'albero

//--------------------------------------------------------------------------------------

public void setup()
{
  

  stroke(0);
}

//--------------------------------------------------------------------------------------

public void draw()
{ 
  translate(width/2, height);
  background(204, 236, 180);  


  DisegnaRami(len, spessore);
}

//--------------------------------------------------------------------------------------

public void mousePressed()
{
  mode = (mode + 1) % 2;
}

//--------------------------------------------------------------------------------------

public void DisegnaRami(int l, float s)
{
  strokeWeight(s);

  if (l > 3)
  {
    line(0, 0, 0, -l);
    translate(0, - l);

    float angSXDX = AngoloInLargo() ;
    float angBassoAlto = AngoloInLungo();

    push();
    rotate(angSXDX);
    DisegnaRami(l* 2/3, s* 2/3);
    pop();

    if (mode == 0)
    {
      rotate(-angSXDX);
    } else if (mode == 1)
    {
      rotate(-angBassoAlto);
    }

    DisegnaRami(l* 2/3, s* 2/3);
  } else
  {
    return;
  }
}

//--------------------------------------------------------------------------------------

public float AngoloInLargo()  //calcola l'angolo con il quale far partire i rami in base alla posizione del mouse
{
  return (PI * mouseX/2 / width) ;
}
//--------------------------------------------------------------------------------------

public float AngoloInLungo()  //calcola l'angolo con il quale far partire i rami in base alla posizione del mouse
{
  return (PI * mouseY/2 / width) ;
}

//--------------------------------------------------------------------------------------
  public void settings() {  size(700, 700); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
