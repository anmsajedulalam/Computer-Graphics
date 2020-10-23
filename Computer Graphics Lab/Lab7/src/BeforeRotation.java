
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class BeforeRotation implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      BeforeRotation l = new BeforeRotation();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600,600);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      	  gl.glBegin (GL2.GL_LINES);//static field
      	  //length of each side is 0.6
      	 double x1=-0.3,y1=0.3;
         double x2=0.3,y2=0.3;
         double x3=-0.3,y3=-0.3;
         double x4=0.3,y4=-0.3;
         double x5=0.0,y5=0.0;
         double x6=0.6,y6=0.0;
         double x7=0.0,y7=-0.6;
         double x8=0.6,y8=-0.6;
          //1st square
          gl.glVertex2d(x1,y1);
          gl.glVertex2d(x2,y2);
          gl.glVertex2d(x1,y1);
          gl.glVertex2d(x3,y3);
          gl.glVertex2d(x3,y3);
          gl.glVertex2d(x4,y4);
          gl.glVertex2d(x2,y2);
          gl.glVertex2d(x4,y4);
          
       //2nd
          gl.glVertex2d(x5,y5);
          gl.glVertex2d(x6,y6);
          gl.glVertex2d(x5,y5);
          gl.glVertex2d(x7,y7);
          gl.glVertex2d(x7,y7);
          gl.glVertex2d(x8,y8);
          gl.glVertex2d(x6,y6);
          gl.glVertex2d(x8,y8);
          
          //connect corner
          gl.glVertex2d(x1,y1);
          gl.glVertex2d(x5,y5);
          gl.glVertex2d(x2,y2);
          gl.glVertex2d(x6,y6);
          gl.glVertex2d(x3,y3);
          gl.glVertex2d(x7,y7);
          gl.glVertex2d(x4,y4);
          gl.glVertex2d(x8,y8);
        
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
