import java.awt.Graphics2D;

public interface GameState {
    void update (Game game);
    void render (Graphics2D graphics);
}
