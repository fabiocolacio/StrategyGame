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
import java.io.InputStream;

public class Game extends JFrame implements MouseListener, KeyListener, MouseMotionListener {
    public static final String NAME = "Strategy Game";
    public static int mouseX;
    public static int mouseY;
    public static boolean lmbDown;
    public static boolean rmbDown;

    private Dimension gameSize = new Dimension (500, 300);
    private int scaleFactor = 2;

    private GameState currentState;
    private volatile boolean renderFlag;
    private JFrame window;
    private Dimension windowSize;

    public Game () {
        window = new JFrame ();
        window.addMouseListener (this);
        window.addKeyListener (this);
        window.addMouseMotionListener(this);
        window.setTitle (NAME);
        window.setResizable (false);
        window.setVisible (true);
        window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        updateWindowSize ();

        setState (new MainMenu (this));
    }

    /**
     * Opens a resource within the game's JAR file as an InputStream.
     * This is syntactic sugar, and is functionally equivalent to calling
     * ClassLoader.getSystemResourceAsStream ().
     *
     * Files outside of the JAR can be opened using usual Java standards.
     *
     * @param path The path of the resource to open, relative to the root of the JAR
     * @return The InputStream of the newly opened file.
     */
    public static InputStream openResource (String path) {
        return ClassLoader.getSystemResourceAsStream (path);
    }

    private void updateWindowSize () {
        windowSize = new Dimension (
            (int) (gameSize.getWidth () * scaleFactor),
            (int) (gameSize.getHeight () * scaleFactor));
        window.setSize (windowSize);
        queueRender ();  
    }

    public void setState (GameState state) {
        currentState = state;
        queueRender ();
    }

    public void update () {
        currentState.update ();

        if (renderFlag) {
            render (window.getGraphics ());
            renderFlag = false;
        }
    }

    public JFrame getWindow () {
        return window;
    }

    public void queueRender () {
        renderFlag = true;
    }

    public void render (Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.scale (scaleFactor, scaleFactor);

        graphics.setColor (Color.RED);
        graphics.fillRect (0, 0, window.getWidth (), window.getHeight ());

        currentState.render (graphics);
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        e.translatePoint (
            (e.getX () / scaleFactor) - e.getX (),
            (e.getY () / scaleFactor) - e.getY ());

        currentState.mouseClicked (e);
    }

    @Override
    public void mousePressed (MouseEvent e) {
        e.translatePoint (
            (e.getX () / scaleFactor) - e.getX (),
            (e.getY () / scaleFactor) - e.getY ());

        if (e.getButton() == 1)
            lmbDown = true;

        if (e.getButton() == 2)
            rmbDown = true;

        currentState.mousePressed (e);
    }

    @Override
    public void mouseReleased (MouseEvent e) {
        e.translatePoint (
            (e.getX () / scaleFactor) - e.getX (),
            (e.getY () / scaleFactor) - e.getY ());

        if (e.getButton() == 1)
            lmbDown = false;

        if (e.getButton() == 2)
            rmbDown = false;

        currentState.mouseReleased (e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        e.translatePoint (
            (e.getX () / scaleFactor) - e.getX (),
            (e.getY () / scaleFactor) - e.getY ());

        mouseX = e.getX();
        mouseY = e.getY();

        currentState.mouseDragged (e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        e.translatePoint (
            (e.getX () / scaleFactor) - e.getX (),
            (e.getY () / scaleFactor) - e.getY ());

        mouseX = e.getX();
        mouseY = e. getY();

        currentState.mouseMoved (e);
    }

    @Override
    public void mouseEntered (MouseEvent e) {
        e.translatePoint (
            (e.getX () / scaleFactor) - e.getX (),
            (e.getY () / scaleFactor) - e.getY ());

        currentState.mouseEntered (e);
    }

    @Override
    public void mouseExited (MouseEvent e) {
        e.translatePoint (
            (e.getX () / scaleFactor) - e.getX (),
            (e.getY () / scaleFactor) - e.getY ());

        currentState.mouseExited (e);
    }

    @Override
    public void keyTyped (KeyEvent e) {
        currentState.keyTyped (e);
    }

    @Override
    public void keyPressed (KeyEvent e) {
        currentState.keyPressed (e);
    }

    @Override
    public void keyReleased (KeyEvent e) {
        currentState.keyReleased (e);
    }

    public static void main (String[] args) {
        Game game = new Game ();

        while (true) {
            game.update ();
        }
    }
}
