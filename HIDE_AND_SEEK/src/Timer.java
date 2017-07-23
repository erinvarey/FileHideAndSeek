import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Timer extends JComponent {
	int time=0;
	int maxTime=10*10;
	private boolean done=false;
	Interface i;
	public Timer(Interface i){
		this.i=i;
	}
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon image1=new ImageIcon("clock1.png");
		g.drawImage(image1.getImage(),0,0,getWidth(),getHeight(),this);

		Image img=new ImageIcon("clock2.png").getImage();
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		double rotationRequired = Math.toRadians ((float)time/(float)maxTime*360.0);
		double locationX = bimage.getWidth() / 2;
		double locationY = bimage.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		// Drawing the rotated image at the required drawing locations
		g.drawImage(op.filter(bimage, null), 0, 0,getWidth(),getHeight(), null);
	}
	public void start(){
		new Thread(new TimingThread(this)).start();
	}
	public void inc(){	
		if(time<maxTime)time++;
		else {
			time=maxTime;
			done();
		}
		repaint();
	}
	public void done(){
		i.lose();

	}
	public boolean isDone(){
		return done;
	}
}
