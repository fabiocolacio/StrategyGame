import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

public class MatchState implements GameState {

    public MatchState() {


    }
    public void update(Game game){

    }

    public void render(Graphics2D graphics) {
      graphics.setColor (Color.BLACK);
      graphics.setFont (new Font ("Fixedsys", Font.BOLD, 20));
      graphics.drawString ("This is the worst menu ever.", 10, 100);
      graphics.drawString("Play", 10, 120);

    }

}
