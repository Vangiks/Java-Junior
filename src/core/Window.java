package core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window extends Canvas {

	private BufferStrategy bs;
	private Graphics g;
	private JFrame frame;
	
	
	public Window(String name, int wight, int height){
		setPreferredSize(new Dimension(wight, height));
		init(name);
		render();
	}
	
	private void init(String name){
		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this.frame);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void render(){
		if (bs == null)
			createBufferStrategy(3);
		bs = getBufferStrategy();
		
		g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		OnRender();
		g.dispose();
		bs.show();
		
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
		}
		
		EventQueue.invokeLater(() -> render());
	}
	
	private void OnRender(){
		
	}
	
}
