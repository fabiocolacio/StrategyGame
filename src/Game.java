import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;

public class Game extends JFrame implements MouseListener, KeyListener, MouseMotionListener {
    public static final String NAME = "Strategy Game";
    public static int mouseX;
    public static int mouseY;
    public static boolean lmbDown;
    public static boolean rmbDown;

    private GameState currentState;
    private boolean renderFlag;


    public Game () {
        addMouseListener (this);
        addKeyListener (this);
        addMouseMotionListener(this);
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
        if (e.getButton() == 1)
            lmbDown = true;

        if (e.getButton() == 2)
            rmbDown = true;
    }

    @Override
    public void mouseReleased (MouseEvent e) {
        if (e.getButton() == 1)
            lmbDown = false;

        if (e.getButton() == 2)
            rmbDown = false;
    }
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e. getY();
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
