import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

public class MainMenuState implements GameState {
    public MainMenuState () {

    }

    @Override
    public void update (Game game) {
        
    }

    @Override
    public void render (Graphics2D graphics) {
        graphics.setColor (Color.GREEN);
        graphics.setFont (new Font ("Fixedsys", Font.BOLD, 20));
        graphics.drawString ("THIS IS THE BEST MENU EVER!!1!", 10, 100);
        System.out.println ("test");
    }
}
