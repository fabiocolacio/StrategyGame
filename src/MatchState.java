import java.lang.ClassLoader;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MatchState implements GameState {
    private Game game;
    private int[][] map;

    public MatchState (Game game) {
        this.game = game;
        this.map = loadMap (Game.openResource ("maps/test.map"));

        // a simple test to see if the map was properly loaded
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                System.out.print ((char) map[r][c]);
            }
            System.out.print ('\n');
        }
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

    /**
     * Loads a mapfile into memory.
     *
     * The file size for a map is restricted to 1 kib.
     * This restriction can be altered by changing the value of
     * BUFFER_SIZE (measured in bytes).
     *
     * @param stream The InputStream for a valid mapfile.
     * @return The map data modeled as a 2D array.
     */
    private int[][] loadMap (InputStream stream) {
        final int BUFFER_SIZE = 1024;

        int rows = 0;
        int cols = 0;
        int tmpcols = 0;

        int[][] map = null;

        try (BufferedReader reader = new BufferedReader (new InputStreamReader (stream), BUFFER_SIZE)){
            int c;
            reader.mark (BUFFER_SIZE);
            do {
                c = reader.read();
                if (c == '\n') {
                    rows++;
                    cols = Math.max (cols, tmpcols);
                    tmpcols = 0;
                }
                else {
                    tmpcols++;
                }
            } while (c != -1);
            reader.reset ();

            map = new int[rows][cols];
            for (int row = 0; row < rows; row++ ) {
                for (int col = 0; col < cols; col++) {
                    map[row][col] = reader.read();
                }
                reader.read();
            }
        }
        catch (Exception e) {
            System.out.printf("Unable to load map with error: \n%s\n\n", e);
            System.out.println("Aborting.");
            System.exit(0);
        }

        return map;
    }
}
