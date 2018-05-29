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
    private volatile boolean renderFlag;
    private JFrame window;


    public Game () {
        window = new JFrame ();
        window.addMouseListener (this);
        window.addKeyListener (this);
        window.addMouseMotionListener(this);
        window.setSize (new Dimension (500, 300));
        window.setTitle (NAME);
        window.setResizable (false);
        window.setVisible (true);
        window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        setState (new MainMenu (this));
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

        graphics.setColor (Color.RED);
        graphics.fillRect (0, 0, window.getWidth (), window.getHeight ());

        currentState.render (graphics);
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        currentState.mouseClicked (e);
    }

    @Override
    public void mousePressed (MouseEvent e) {
        if (e.getButton() == 1)
            lmbDown = true;

        if (e.getButton() == 2)
            rmbDown = true;

        currentState.mousePressed (e);
    }

    @Override
    public void mouseReleased (MouseEvent e) {
        if (e.getButton() == 1)
            lmbDown = false;

        if (e.getButton() == 2)
            rmbDown = false;

        currentState.mouseReleased (e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        currentState.mouseDragged (e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e. getY();

        currentState.mouseMoved (e);
    }

    @Override
    public void mouseEntered (MouseEvent e) {
        currentState.mouseEntered (e);
    }

    @Override
    public void mouseExited (MouseEvent e) {
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
