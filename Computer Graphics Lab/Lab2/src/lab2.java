import java.util.Random;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class lab2 implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      lab2 l = new lab2();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight lab2");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
         int p=10;
         double [] xi = new double [p];
         double [] yi = new double [p];
         double [] xf = new double [p];
         double [] yf = new double [p];
         double [] slope = new double [p];
         for(int i=0;i<p;i++)
         {   Random r = new Random();
        	 xi[i]=r.nextDouble()*2-1;
        	 yi[i]=r.nextDouble()*2-1;
        	 xf[i]=r.nextDouble()*2-1;
        	 yf[i]=r.nextDouble()*2-1;
        	 
         }
         for(int n=0;n<slope.length;n++)
         {
        	 slope[n]=((yf[n]-yi[n])/(xf[n]-xi[n]));
        	 
         }
         
         //DDA
         double newy, xx;
         for(int i=0; i<xi.length; i++)
         {
        	 xx=xi[i];
        	 newy=yi[i];
        	 while(xx<xf[i])
        	 {
        		 gl.glVertex2d(xx, newy);
        		 xx=(double)(xx+0.001);
       		    newy=(double)(newy+0.001*slope[i]);
        	 }
        	 
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

