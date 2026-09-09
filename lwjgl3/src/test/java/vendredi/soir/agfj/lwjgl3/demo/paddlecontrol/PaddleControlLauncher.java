package vendredi.soir.agfj.lwjgl3.demo.paddlecontrol;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import vendredi.soir.agfj.Main;
import vendredi.soir.agfj.lwjgl3.StartupHelper;

/** Launches the interactive "paddle-control" scenario preview window. */
public class PaddleControlLauncher {
  public static void main(String[] args) {
    if (StartupHelper.startNewJvmIfRequired()) return;

    Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
    configuration.setTitle("AGFJ - paddle-control preview");
    configuration.useVsync(true);
    // Square window matching the (square) box's world size, so FitViewport needs no side bands.
    configuration.setWindowedMode(600, 600);

    new Lwjgl3Application(new Main(PaddleControlDemo::new), configuration);
  }
}
