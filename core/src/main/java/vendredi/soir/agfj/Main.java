package vendredi.soir.agfj;

import com.badlogic.gdx.ApplicationAdapter;
import vendredi.soir.agfj.game.MyGame;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
  private MyGame myGame;

  @Override
  public void create() {
    myGame = new MyGame();
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
