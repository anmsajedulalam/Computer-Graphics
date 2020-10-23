
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
public class lab3 implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  

	   
	      lab3 l = new lab3();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	     frame.setVisible(true);
	   	
	     
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
       	  
       	  try{
       		
       		 Scanner read=new Scanner(new File("co-ordinates.txt"));
       		 while(read.hasNextLine())
       		 { 
       		  	String line=read.nextLine();
				StringTokenizer st = new StringTokenizer(line, ",");
				String token1=st.nextToken();
				String token2=st.nextToken();
				float x0=Float.valueOf(token1);
				float y0=Float.valueOf(token2);
				String aline=read.nextLine();
				StringTokenizer st1 = new StringTokenizer(aline, ",");
				String token3=st1.nextToken();
				String token4=st1.nextToken();
				float x1=Float.valueOf(token3);
				float y1=Float.valueOf(token4);
				System.out.println("x0: "+x0);
				System.out.println("y0: "+y0);
				System.out.println("x1: "+x1);
				System.out.println("y1: "+y1);
				
				//swapping if x1<x0
				if(x1<x0)
				{
					float tempx=x0;
					float tempy=y0;
					x0=x1;
					y0=y1;
					x1=tempx;
					y1=tempy;
					System.out.println("newx0: "+x0);
					System.out.println("y0: "+y0);
					System.out.println("x1: "+x1);
					System.out.println("y1: "+y1);
				}
				
				float m=(y1-y0)/(x1-x0);
				System.out.println("m: "+m);
				System.out.println();
				if(m==-1){
					while(x0<=x1){
						x0=x0+0.0001f;
						y0=y0-0.0001f;
						gl.glVertex2d(x0,y0);
					}
				}
				
				else if(m==1){
					while(x0<=x1){
						x0=x0+0.0001f;
						y0=y0+0.0001f;
						gl.glVertex2d(x0,y0);
					}
				}
				else if(m==0){
					while(x0<=x1){
						x0=x0+0.0001f;
						gl.glVertex2d(x0,y0);
					}
				}
				else if((x1-x0)==0){
					 if(y0>y1){
						 float temp=y0;
						 y0=y1;
						 y1=temp;
					 }
					while(y0<=y1){
						y0=y0+0.0001f;
						gl.glVertex2d(x0,y0);
					}
				}
				else{
					System.out.println("INVALID");
					
				}
				
				
				
				
				
				
       		}

			
       	  }
       	  
       	  catch (FileNotFoundException e) {
				System.out.println("File not Found");
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


