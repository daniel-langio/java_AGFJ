package vendredi.soir.agfj;

import com.badlogic.gdx.ApplicationAdapter;
import java.util.function.Supplier;
import vendredi.soir.agfj.game.Game;
import vendredi.soir.agfj.game.MyGame;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
  private final Supplier<Game> gameFactory;
  private Game myGame;

  public Main() {
    this(MyGame::new);
  }

  public Main(Supplier<Game> gameFactory) {
    this.gameFactory = gameFactory;
  }

  @Override
  public void create() {
    myGame = gameFactory.get();
  }

  @Override
  public void render() {
    input();
    logic();
    draw();
  }

  private void input() {
    myGame.input();
  }

  private void logic() {
    myGame.logic();
  }

  private void draw() {
    myGame.draw();
  }

  @Override
  public void resize(int width, int height) {
    myGame.resize(width, height);
  }

  @Override
  public void dispose() {
    myGame.dispose();
  }
}
