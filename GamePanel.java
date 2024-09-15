GameGraphics.java
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

public class GameGraphics {
    final int SCREEN_WIDTH = 600;
    final int SCREEN_HEIGHT = 600;
    final int UNIT_SIZE = 25;

    public void draw(Graphics g, int[] x, int[] y, int bodyParts, int appleX, int appleY, boolean running) {
        if (running) {
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            
	    }
	     // Vẽ táo
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
