import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Rectangle;


public class MainMenu implements GameState {
    private Rectangle buttonBounds;

    public MainMenu () {
        buttonBounds = new Rectangle();
    }


    @Override
    public void update (Game game) {
        if (buttonBounds.contains(Game.mouseX, Game.mouseY)){
            game.setState(new MatchState());
            System.out.println("It's inside of the button");
}
    }

    @Override
    public void render (Graphics2D graphics) {
        graphics.setColor (Color.GREEN);
        Font font = new Font ("Fixedsys", Font.BOLD, 20);
        graphics.setFont (font);
        graphics.drawString ("This is the worst menu ever.", 10, 100);
        graphics.drawString("Play", 10, 120);
        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        buttonBounds = new Rectangle(10, 120, fontMetrics.stringWidth("Play"), fontMetrics.getHeight());

    }
}
