
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
public class Line implements GLEventListener{
 
 static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
       //getting the capabilities object of GL2 profile
       

       Line l = new Line();
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
          //This code is for drawing lines based on zones, Line drawing algorithm
          try{
         Scanner read=new Scanner(new File("input.txt"));
         while(read.hasNextLine()){
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
   float dx=x1-x0; 
   float dy=y1-y0;
   float absdx=Math.abs(x1-x0); 
   float absdy=Math.abs(y1-y0);

//CALCULATE IN WHICH ZONE
   
   int zone=-1;
   // 0,3,4,7
   if(absdx>=absdy){ 
    if(dx>=0 && dy>=0){
     zone=0;
    }
    else if(dx<0 && dy>=0){
     zone=3;
    }
    else if(dx<0 && dy<0){
     zone=4;
    }
    else if(dx>=0 && dy<0){
     zone=7;
    } 
   }
   // 1,2,5,6 
   else{
    if(dx>=0 && dy>=0){
     zone=1;
    }
    else if(dx<0 && dy>=0){
     zone=2;
    }
    else if(dx<0 && dy<0){
     zone=5;
    }
    else if(dx>=0 && dy<0){
     zone=6;
    }
   }
   //System.out.println("The line belongs to zone: "+zone);

   
   
   if(zone==0){
    
    float dint=2*dy-dx;
    float dE=2*dy;
    float dNE=(2*dy)-(2*dx);
    float x=x0;
    float y=y0;
    
    gl.glVertex2d(x,y);
    while(x<=x1){
     if(dint<0){
      dint=dint+dE;
      x=x+0.0001f;
     }
     else{
      dint=dint+dNE;
      x=x+0.0001f;
      y=y+0.0001f;
     }
     gl.glColor3f( 0.0f, 0.0f, 0.0f );
     gl.glVertex2d(x,y);
     
    }
   }
   
   else if(zone==1){
    
    float dint=dy-2*dx;
    float dN=-2*dx;
    float dNE=2*(dy-dx);
    float x=x0;
    float y=y0;
    gl.glVertex2d(x,y);
    while(x<=x1){
     if(dint<0){
      dint=dint+dNE;
      x=x+0.0001f;
      y=y+0.0001f;
     }
     else{
      dint=dint+dN;
      y=y+0.0001f;
     }
     gl.glColor3f( 1.0f, 0.0f, 0.0f );
     gl.glVertex2d(x,y);
    }
   } 
   
   else if(zone==2){
    float dint=-dy-(2*dx);
    float dNW=-2*(dy+dx);
    float dN=-2*dx;
    float x=x0;
    float y=y0;
    gl.glVertex2d(x,y);
    while(x>=x1){
     if(dint<0){
      dint=dint+dN;
      y=y+0.0001f;
     }
     else{
      dint=dint+dNW;
      x=x-0.0001f;
      y=y+0.0001f;
     }
     gl.glColor3f( 0.0f, 1.0f, 0.0f );
     gl.glVertex2d(x,y);
    }
   }
   
   else if(zone==3){
    float dint=(-2*dy)-dx;
    float dNW=-2*(dy+dx);
    float dW=-2*dy;
    float x=x0;
    float y=y0;
    gl.glVertex2d(x,y);
    while(x>=x1){
     if(dint<0){
      dint=dint+dNW;
      x=x-0.0001f;
      y=y+0.0001f;
     }
     else{
      dint=dint+dW;
      x=x-0.0001f;
    
     }
     gl.glColor3f( 0.0f, 0.0f, 1.0f );
     gl.glVertex2d(x,y);
    }
   } 
   else if(zone==4){
    float dint=(-2*dy)+dx;
    float dSW=2*(dx-dy);
    float dW=-2*dy;
    float x=x0;
    float y=y0;
    gl.glVertex2d(x,y);
    while(x>=x1){
     if(dint<0){
      dint=dint+dW;
      x=x-0.0001f;
     }
     else{
      dint=dint+dSW;
      x=x-0.0001f;
      y=y-0.0001f;
     }
     gl.glColor3f( 1.0f, 0.0f, 0.8f );
     gl.glVertex2d(x,y);
    }
   } 
   else if(zone==5){
    float dint=-dy+(2*dx);
    float dSW=2*(dx-dy);
    float dS=2*dx;
    float x=x0;
    float y=y0;
    gl.glVertex2d(x,y);
    while(x>=x1){
     if(dint<0){
      dint=dint+dSW;
      x=x-0.0001f;
      y=y-0.0001f;
     }
     else{
      dint=dint+dS;
      y=y-0.0001f;
     }
     gl.glColor3f( 0.0f, 1.0f, 0.9f );
     gl.glVertex2d(x,y);
    }
   } 
   else if(zone==6){
    float dint=dy+2*dx;
    float dSE=2*(dy+dx);
    float dS=2*dx;
    float x=x0;
    float y=y0;
    gl.glVertex2d(x,y);
    while(x<=x1){
     if(dint<0){
      dint=dint+dS;
      y=y-0.0001f;
     }
     else{
      dint=dint+dSE;
      x=x+0.0001f;
      y=y-0.0001f;
     }
     gl.glColor3f( 0.7f, 0.4f, 1.0f );
     gl.glVertex2d(x,y);
    }
   }
   
   else{
    float dint=(2*dy)-dx;
    float dSE=2*(dy+dx);
    float dE=2*dy;
    float x=x0;
    float y=y0;
    gl.glVertex2d(x,y);
    while(x<=x1){
     if(dint<0){
      dint=dint+dSE;
      x=x+0.0001f;
      y=y-0.0001f;
     }
     else{
      dint=dint+dE;
      x=x+0.0001f;
     }
     gl.glColor3f( 0.0f, 0.8f, 0.0f );
     gl.glVertex2d(x,y);
    }
   } 
   
   
         } // end of while hasNextline()
   
  } // end of try
          
          
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
