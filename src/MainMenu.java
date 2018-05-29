import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;


public class MainMenu implements GameState {
    private String[] labels = { "Play" };
    private Rectangle[] bounds;
    private Font font;
    private Game game;

    public MainMenu (Game game) {
        this.game = game;
        bounds = new Rectangle[labels.length];
        font = new Font ("Fixedsys", Font.BOLD, 20);

        Graphics graphics = game.getWindow ().getGraphics ();
        FontMetrics metrics = graphics.getFontMetrics (font);
        for (int i = 0; i < labels.length; i++) {
            bounds[i] = new Rectangle (
                10,
                200 + i * metrics.getHeight (),
                metrics.stringWidth (labels[i]),
                metrics.getHeight ());
        }
    }

    @Override
    public void update () {
    }

    @Override
    public void render (Graphics2D graphics) {
        graphics.setColor (Color.GREEN);
        graphics.setFont (font);
        graphics.drawString ("This is the worst menu ever.", 10, 100);

        for (int i = 0; i < labels.length; i++) {
            graphics.setColor (Color.BLACK);
            graphics.drawRect (bounds[i].x, bounds[i].y, bounds[i].width, bounds[i].height);
            graphics.setColor (Color.GREEN);
            graphics.drawString (labels[i], bounds[i].x, bounds[i].y + bounds[i].height);
        }
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        if (bounds[0].contains (e.getX (), e.getY ())) {
            game.setState (new MatchState (game));
        }
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
