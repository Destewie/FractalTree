int len = 200;
float spessore = 10.0;
int mode = 0; //modo in cui viene disegnato l'albero

//--------------------------------------------------------------------------------------

void setup()
{
  size(700, 700);

  stroke(0);
}

//--------------------------------------------------------------------------------------

void draw()
{ 
  translate(width/2, height);
  background(204, 236, 180);  


  DisegnaRami(len, spessore);
}

//--------------------------------------------------------------------------------------

void mousePressed()
{
  mode = (mode + 1) % 2;
}

//--------------------------------------------------------------------------------------

void DisegnaRami(int l, float s)
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

float AngoloInLargo()  //calcola l'angolo con il quale far partire i rami in base alla posizione del mouse
{
  return (PI * mouseX/2 / width) ;
}
//--------------------------------------------------------------------------------------

float AngoloInLungo()  //calcola l'angolo con il quale far partire i rami in base alla posizione del mouse
{
  return (PI * mouseY/2 / width) ;
}

//--------------------------------------------------------------------------------------
