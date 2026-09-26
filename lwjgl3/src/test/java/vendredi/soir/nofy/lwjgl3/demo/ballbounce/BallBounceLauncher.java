package vendredi.soir.nofy.lwjgl3.demo.ballbounce;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import vendredi.soir.nofy.Main;
import vendredi.soir.nofy.lwjgl3.StartupHelper;

/** Launches the interactive "ball-bounce" scenario preview window. */
public class BallBounceLauncher {
  public static void main(String[] args) {
    if (StartupHelper.startNewJvmIfRequired()) return;

    Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
    configuration.setTitle("Nofy - ball-bounce preview");
    configuration.useVsync(true);
    // Square window matching the (square) box's world size, so FitViewport needs no side bands.
    configuration.setWindowedMode(600, 600);

    new Lwjgl3Application(new Main(BallBounceDemo::new), configuration);
  }
}
