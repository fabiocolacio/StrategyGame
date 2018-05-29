import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

public class MatchState implements GameState {
    private Game game;

    public MatchState (Game game) {
        this.game = game;
    }

    @Override
    public void update () {

    }

    @Override
    public void render (Graphics2D graphics) {
      graphics.setColor (Color.BLACK);
      graphics.setFont (new Font ("Fixedsys", Font.BOLD, 20));
      graphics.drawString ("This is the match state", 10, 100);
    }

    @Override
    public void mouseClicked (MouseEvent e) {
    
    }

    @Override
    public void mousePressed (MouseEvent e) {

    }

    @Override
    public void mouseReleased (MouseEvent e) {

    }

    @Override
    public void mouseEntered (MouseEvent e) {

    }

    @Override
    public void mouseExited (MouseEvent e) {

    }

    @Override
    public void mouseMoved (MouseEvent e) {

    }

    @Override
    public void mouseDragged (MouseEvent e) {

    }

    @Override
    public void keyTyped (KeyEvent e) {

    }

    @Override
    public void keyPressed (KeyEvent e) {

    }

    @Override
    public void keyReleased (KeyEvent e) {

    }
}
