import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class LineClipping implements GLEventListener 
{ 
 double xmn=-.5;
 double xmx=.5;
 double ymn=-.5;
 double ymx=.5;

 int top=8, bottom=4, right=2, left=1;

 static GLProfile profile = GLProfile.get(GLProfile.GL2);
 static GLCapabilities capabilities = new GLCapabilities(profile);
 // The canvas
 static GLCanvas glcanvas = new GLCanvas(capabilities);

 public static void main(String[] args) 
 {
  // getting the capabilities object of GL2 profile

  LineClipping l = new LineClipping();
  // creating frame
  glcanvas.addGLEventListener(l);
  glcanvas.setSize(600, 400);

  final JFrame frame = new JFrame("Staight lines");
  // adding canvas to frame
  frame.getContentPane().add(glcanvas);
  frame.setSize(frame.getContentPane().getPreferredSize());
  frame.setVisible(true);

 }

 //Cohen_Sutherland
 public void display(GLAutoDrawable drawable) 
 {
  final GL2 gl = drawable.getGL().getGL2();

  gl.glBegin(GL2.GL_LINES);// static field
  gl.glColor3d(1f, 1f, 1f);
  gl.glVertex2d(xmn, ymx);
  gl.glVertex2d(xmx, ymx);

  gl.glVertex2d(xmn, ymn);
  gl.glVertex2d(xmx, ymn);
  
 gl.glVertex2d(xmn, ymx);
 gl.glVertex2d(xmn, ymn);
  
  gl.glVertex2d(xmx, ymx);
 gl.glVertex2d(xmx, ymn);

  gl.glEnd();


  Scanner sc=new Scanner(System.in);
  System.out.println("Number of lines");
	int n=sc.nextInt();
	for(int i=0;i<n;i++){
		Random r = new Random();

		double x0 = -1 + (1 +1) * r.nextDouble();
		double y0= -1 + (1 +1) * r.nextDouble();
		double x1 = -1 + (1 +1) * r.nextDouble();
		double y1= -1 + (1 +1) * r.nextDouble();
		System.out.println("x0: "+x0);
		System.out.println("y0: "+y0);
		System.out.println("x1: "+x1);
		System.out.println("y1: "+y1);

    
     System.out.println(x0 +","+y0+" "+x1+" , "+ y1);
		
		double x;
		double y;
    int outCode_0, outCode_1;
    
    outCode_0 = make_code(x0, y0);
    outCode_1 = make_code(x1, y1);
    
    System.out.println(outCode_0+" "+outCode_1);
    
    int or=outCode_0 | outCode_1;
    int and=outCode_0 & outCode_1;
    
    System.out.println("Or = "+or +" "+"And = "+and);
    
    if(or==0) 
    {
     System.out.println("Completely Accepted");

     gl.glBegin(GL2.GL_LINES);// static field     
     gl.glColor3d(0, 1f, 0);
     gl.glVertex2d(x0, y0);
     gl.glVertex2d(x1, y1);

     gl.glEnd();
    } 
    else if(and>0) 
    {
     System.out.println("Completely Rejected");
     gl.glColor3d(1f, 0, 0);
     gl.glBegin(GL2.GL_LINES);
     gl.glVertex2d(x0, y0);
     gl.glVertex2d(x1, y1);

     gl.glEnd();
    }
    else
    {
     System.out.println("Partially Acepted or Rejected");
     gl.glColor3d(0, 0, 1f);
     gl.glBegin(GL2.GL_LINES);
     gl.glVertex2d(x0, y0);
     gl.glVertex2d(x1, y1);

     gl.glEnd();
     
     
     int code;
     if(outCode_0>0){
  	   code=outCode_0;
     }
     else{
  	   code=outCode_1;
     }
     
     int and_8=code&top;
     int and_4=code&bottom;
     int and_2=code&right;
     if(and_8>0){ //intersecting with top
  	   y=ymx;
  	   x=x0+((ymx-y0)/(y1-y0))*(x1-x0);				        			   
     }
     else if(and_4>0){ //intersecting with bottom
  	   y=ymn;
  	   x=x0+((ymn-y0)/(y1-y0))*(x1-x0);
     }
     else if(and_2>0){ //intersecting with right
  	   x=xmx;
  	   y=y0+((xmx-x0)/(x1-x0))*(y1-y0);
     }
     else{ //intersecting with left
  	   x=xmn;
  	   y=y0+((xmn-x0)/(x1-x0))*(y1-y0);
     }
     
     if(code==outCode_0){
  	   x0=x;
  	   y0=y;
  	outCode_0= make_code(x0, y0);
     }
     
     else{ // if code==code1
  	   x1=x;
  	   y1=y;
  		outCode_1= make_code(x1, y1);
     }
     
     gl.glBegin(GL2.GL_LINES);// static field     
     gl.glColor3d(0, 1f, 0); //green
     gl.glVertex2d(x0, y0);
     gl.glVertex2d(x1, y1);

     gl.glEnd();
     
     
     
     
     int code1;
     if(outCode_1>0){
  	   code1=outCode_1;
     }
     else{
  	   code1=outCode_0;
     }
     
     int and11=code1&left;
     int and41=code1&bottom;
     int and21=code1&right;
     if(and11>0){ //intersecting with left
    	   x=xmn;
      	   y=y0+((xmn-x0)/(x1-x0))*(y1-y0);
    			        			   
     }
   
     else if(and21>0){ //intersecting with right
  	   x=xmx;
  	   y=y0+((xmx-x0)/(x1-x0))*(y1-y0);
     }
     else if(and41>0){ //intersecting with bottom
    	   y=ymn;
    	   x=x0+((ymn-y0)/(y1-y0))*(x1-x0);
       }
     else{ //intersecting with top
    	 y=ymx;
         x=x0+((ymx-y0)/(y1-y0))*(x1-x0);		
  	
     }
     
     if(code1==outCode_0){
  	   x0=x;
  	   y0=y;
  	outCode_0= make_code(x0, y0);
  	System.out.println("out" + outCode_0);
     }
     
     else{ // if code==code1
    	   gl.glBegin(GL2.GL_LINES);// static field     
    	     gl.glColor3d(0, 0, 1f); //blue
    	     gl.glVertex2d(x, y);
    	     gl.glVertex2d(x1, y1);

    	     gl.glEnd();
     }
     
  
     
    }

	}
 }

 

 public int make_code(double x, double y) 
 {
  int outCode=0;
  if(y>ymx) 
  {
   outCode+=top;
  } 
  else if(y<ymn) 
  {
   outCode+=bottom;
  }
  if(x>xmx) 
  {
   outCode+=right;
  }
  else if(x<xmn) 
  {
   outCode+=left;
  }

  return outCode;
 }

 public void dispose(GLAutoDrawable arg0) {
  // method body
 }

 public void init(GLAutoDrawable drawable) {
  // method body
  // 4. drive the display() in a loop
 }

 public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
   int arg4) {
  // method body
 }
 // end of main
}// end of classimport javax.media.opengl.GL2;

