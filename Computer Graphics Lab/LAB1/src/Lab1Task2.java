

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Lab1Task2 implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Lab1Task2 l = new Lab1Task2();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Lab1Task2");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
 
       	try 
       	{
       	  FileReader fr= new FileReader("coordinates.txt");
       	  BufferedReader br = new BufferedReader(fr);
       	  String str;
       	  while((str=br.readLine())!=null)
       	  {
       		  for(int i=0; i<14 ; i++)
       		  {
       		String [] tokens = str.split(" ");
       		double  x= Double.parseDouble(tokens[0]);
       	 	double y= Double.parseDouble(tokens[1]);
       	     gl.glVertex2d(x, y);
       		  }
       	  }
       	  
       	}
       	catch(Exception e){
       		System.out.println("eee");
       	}
       	gl.glEnd();
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;
