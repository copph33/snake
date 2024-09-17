import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameManager extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 6;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    GameLogic gameLogic;
    GameGraphics gameGraphics;
    UserInput userInput;

    public GameManager() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        gameLogic = new GameLogic(x, y, bodyParts, direction);
        gameGraphics = new GameGraphics();
        userInput = new UserInput(direction);

        this.addKeyListener(userInput);

        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void newApple() {
        appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameGraphics.draw(g, x, y, gameLogic.bodyParts, appleX, appleY, running);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            direction = userInput.getDirection();
            gameLogic.move();
            gameLogic.checkApple(appleX, appleY);
            if (gameLogic.checkCollisions(SCREEN_WIDTH, SCREEN_HEIGHT)) {
                running = false;
                timer.stop();
            }
        }
        repaint();
    }
}
