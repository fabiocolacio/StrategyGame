import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;

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
    private int[][] loadMap(String fileName) {
        int rows = 0;
        int cols = 0;
        int[][] map = null;

        try (BufferedReader reader = new BufferedReader (new FileReader (fileName))) {
            {
                BufferedReader temp = new BufferedReader (new FileReader (fileName));
                int c;

                do {
                    c = temp.read();
                    if (c == '\n') {
                        rows++;
                    }
                    else {
                        cols++;
                    }
                } while (c != -1);
                    temp.close();

            }
            map = new int[rows][cols];

            for (int row = 0; row < rows; row++ ) {
                for (int col = 0; col < cols; col++) {
                    map[row][col] = reader.read();

                }
            reader.read();
            }

        }
        catch (Exception e) {
            System.out.printf("Unable to load instance with error: \n%s\n\n", e);
            System.out.println("Aborting.");
            System.exit(0);

        }
        return map;
    }

}
