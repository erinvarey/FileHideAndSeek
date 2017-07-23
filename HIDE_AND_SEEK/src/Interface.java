import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface extends JFrame {
	private JPanel root;
	private JPanel root2;
	JPanel win;
	JPanel lose;
	Timer timer;
	JLabel title;
	JLabel fileName;
	JButton go;
	JButton easy;
	FileMethods test=null;
	JButton hard;
	String URL="WIN";
	private int dif=-1;
	public Interface(){		
		super("File Hider");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setPreferredSize(new Dimension((int)width,(int)height));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		root=new JPanel(new BorderLayout());
		root.setOpaque(false);
		this.setBackground(Color.cyan);
		go=new JButton(scale(new ImageIcon("startGame.png"),700,100));
		go.setBorderPainted(false);
		setContentPane(root);
		title=new JLabel(new ImageIcon("fILEhideAndSeek.png"));	
		JPanel dificulty=new JPanel(new BorderLayout());
		easy=new JButton(new ImageIcon("EASYMODE.png"));		
		hard=new JButton(new ImageIcon("HARDMODE.png"));
		easy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				easy.setEnabled(false);
				hard.setEnabled(true);
				dif=0;
			}			
		});
		hard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				hard.setEnabled(false);
				easy.setEnabled(true);
				dif=1;
			}			
		});
		go.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(root2);				
				pack();
				repaint();
				timer.start();
				
				try {
					System.out.println("hello");
					test=new FileMethods();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				URL=test.getNewFileLocation();
				fileName.setText(test.getFileName());
				//grabFile();	
				//System.out.println(getFileName());
				//System.out.println(getFilePath());
				
				
			//	moveFile("C:\\Python27","kyle.txt","C:\\testcase");
				
				
				
				
			}			
		});
		dificulty.add(easy,BorderLayout.WEST);
		dificulty.add(hard,BorderLayout.EAST);
		root.add(dificulty);
		root.add(title,BorderLayout.NORTH);
		root.add(go,BorderLayout.SOUTH);
		pack();
		easy.setIcon(scale(new ImageIcon("EASYMODE.png"),easy.getWidth(),easy.getHeight()));
		easy.setDisabledIcon(scale(new ImageIcon("EASYMODE2.png"),easy.getWidth(),easy.getHeight()));
		hard.setIcon(scale(new ImageIcon("HARDMODE.png"),hard.getWidth(),hard.getHeight()));
		hard.setDisabledIcon(scale(new ImageIcon("HARDMODE2.png"),hard.getWidth(),hard.getHeight()));
		//go.setIcon(scale(new ImageIcon("startGame.png"),go.getWidth(),go.getHeight()));
		title.setIcon(scale(new ImageIcon("fILEhideAndSeek.png"),title.getWidth(),title.getHeight()));		
		repaint();
		root2=new JPanel(new BorderLayout());
		JPanel top=new JPanel(new BorderLayout());
		JTextField ans=new JTextField("Enter The URl Here");
		timer=new Timer(this);
		JButton submit=new JButton("Submit");
		root2.setOpaque(false);
		top.setOpaque(false);
		root2.add(top,BorderLayout.NORTH);	
		root2.add(timer);
		top.add(ans);
		fileName=new JLabel();
		top.add(fileName,BorderLayout.SOUTH);
		top.add(submit,BorderLayout.EAST);
		win=new JPanel();
		lose=new JPanel();
		win.add(new JLabel(new ImageIcon("win.png")));
		lose.add(new JLabel(new ImageIcon("lose.png")));
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				test.moveFile(test.getNewFileLocation(),test.getFileName(),test.getFilePath());
				if(ans.getText().equals(URL))setContentPane(win);
				else setContentPane(lose);
				pack();
				repaint();
			}			
		});
	}
	public void lose(){
		setContentPane(lose);
		pack();
		repaint();
	}
	private ImageIcon scale(ImageIcon img,int w,int h){
		Image i=img.getImage();		
		return new ImageIcon(i.getScaledInstance(w, h, Image.SCALE_FAST));		
	}
}
