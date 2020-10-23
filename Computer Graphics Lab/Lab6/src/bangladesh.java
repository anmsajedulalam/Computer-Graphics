import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
public class bangladesh implements GLEventListener
{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
    public static void main(String[] args)
    {
    	//getting the capabilities object of GL2 profile
    	bangladesh l = new bangladesh();
    	//creating frame
    	glcanvas.addGLEventListener(l);
    	glcanvas.setSize(800, 800);
		      
    	final JFrame frame = new JFrame ("straight Line");
    	//adding canvas to frame
    	frame.getContentPane().add(glcanvas);
    	frame.setSize(frame.getContentPane().getPreferredSize());
    	frame.setVisible(true);
  
    }
   
    public void display(GLAutoDrawable drawable) 
    {
    	final GL2 gl = drawable.getGL().getGL2();
	    gl.glBegin(GL2.GL_POINTS);  
        //RECTANGLE GREEN
        double xmin=-0.5;
        double xmax=0.5;
        double ymin=-0.3;
        double ymax=0.3;		
       	  		
        while(ymin<=ymax)
        {
    	   double x0=xmin;
    	   double y0=ymin;
    	   double x1=xmax;
    	   double y1=ymin;	
    	   double m=(y1-y0)/(x1-x0);
    	   if(m>=-1 && m<=1)
    	   {
    		   while(x0<=x1)
    		   {
    			  x0=x0+0.0001;
    			   y0=y0+(m*0.0001);
    			   //gl.glBegin (GL2.GL_POINTS);				
    			   gl.glColor3f( 0.0f, 0.3f, 0.0f );
    			   gl.glVertex2d(x0,y0);
    			   

    		   } 
    	   }
		   else
		   {
			   while(x0<=x1)
			   {
				   x0=x0+(0.0001/m);
				   y0=y0+0.0001;		
				  gl.glColor3f( 0.0f, 0.3f, 0.0f );
				   gl.glVertex2d(x0,y0);
				  		
						
			   } 
		   } 
    	   
    	   
    		
    	 ymin=ymin+0.0001;
				
        }
       	  	
        
        //FLAG STICK
        
        
        xmax=-0.5;
        ymax=0.3;
        xmin=-0.52;
        ymin=-0.99;
       					
      
        while(ymin<=ymax)
        {
    	   double x0=xmin;
    	   double y0=ymin;
    	   double x1=xmax;
    	   double y1=ymin;	
    	   double m=(y1-y0)/(x1-x0);
    	   if(m>=-1 && m<=1)
    	   {
    		   while(x0<=x1)
    		   {
    			   x0=x0+0.0001;
    			   y0=y0+(m*0.0001);
    			   			
    			   gl.glColor3f( 0.7f, 0.35f, 0.05f);
    			   gl.glVertex2d(x0,y0);
    			   
    		   } 
    	   } 
    	   else
    	   {
    		   while(x0<=x1)
    		   {
    			   x0=x0+(0.0001/m);
    			   y0=y0+0.0001;		
    			   				
    			   gl.glColor3f( 0.7f, 0.35f, 0.05f);
    			   gl.glVertex2d(x0,y0);

						
    		   }
    	   } 
    	   ymin=ymin+0.0001;
				
        } 
       	  		
       	  		
        //drawing circle    	  		
        double r = 0.22;
        while(r>=0)
        {
    	   double x = 0.0;
    	   double y = r;
    		
    	   drawEightSymPixel(gl, x, y);
    		
    	   double dinit = 1 - r;

    	   while (x <= y)
    	   {
    		   if (dinit < 0) 
    		   {
    			   dinit += (2 * x) + 0.001;     
    		   } 
    		   else
    		   {
    			   dinit += -(2 * y) + (2 * x) + 0.001;
    			   y=y-0.001;
    		   }
    		   x=x+0.001;
    			
    		   drawEightSymPixel(gl, x, y);	
    	   }
    	   r=r-0.0001;
        }
	
       gl.glEnd();
   } 
   
   
   public void drawEightSymPixel(GL2 gl, double x, double y) 
   {
    	gl.glColor3f(1.0f,0.0f,0.0f );
    	gl.glVertex2d(x,y);
    	gl.glVertex2d(x,-y);
    	gl.glVertex2d(-x, y);
    	gl.glVertex2d(-x, -y);
    	gl.glVertex2d(y, x);
    	gl.glVertex2d(y, -x);
    	gl.glVertex2d(-y, x);
    	gl.glVertex2d(-y, -x);
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
