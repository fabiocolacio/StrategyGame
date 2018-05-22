import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements MouseListener, KeyListener {
    public static final String NAME = "Strategy Game";

    private GameState currentState;
    private boolean renderFlag;

    public Game () {
        addMouseListener (this);
        addKeyListener (this);
        setSize (new Dimension (500, 300));
        setTitle (NAME);
        setResizable (false);
        setVisible (true);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        setState (new MainMenu ());
    }

    public void setState (GameState state) {
        currentState = state;
        queueRender ();
    }

    public void update () {
        currentState.update (this); 

        if (renderFlag) {
            repaint ();
            renderFlag = false;
        }
    }

    public void queueRender () {
        renderFlag = true;
    }

    @Override
    public void paint (Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        graphics.setColor (Color.RED);
        graphics.fillRect (0, 0, getWidth (), getHeight ());

        currentState.render (graphics); 
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
    public void keyTyped (KeyEvent e) {
    
    }

    @Override
    public void keyPressed (KeyEvent e) {

    }

    @Override
    public void keyReleased (KeyEvent e) {

    }
    
    public static void main (String[] args) {
        Game game = new Game ();

        while (true) {
            game.update ();
        }
    }
}
