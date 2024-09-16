UserInput.java
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserInput extends KeyAdapter {
    char direction;

    public UserInput(char direction) {
        this.direction = direction;
    }
}