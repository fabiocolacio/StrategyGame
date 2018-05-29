import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;

public interface GameState extends MouseListener, MouseMotionListener, KeyListener {
    void update ();
    void render (Graphics2D graphics);
}
