package vendredi.soir.agfj.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import vendredi.soir.agfj.data.VideoExportConfig;
import vendredi.soir.agfj.factory.VideoExportConfigLoader;

/** Headless entry point: renders a scene to a video file instead of an interactive window. */
public class VideoExportLauncher {
  private static final String DEFAULT_CONFIG_PATH = "assets/data/video/ball-bounce.json";

  public static void main(String[] args) {
    String configPath = args.length > 0 ? args[0] : DEFAULT_CONFIG_PATH;
    VideoExportConfig config = VideoExportConfigLoader.load(configPath);

    Lwjgl3ApplicationConfiguration appConfig = new Lwjgl3ApplicationConfiguration();
    appConfig.setTitle("AGFJ Video Export");
    appConfig.setWindowedMode(config.getWidth(), config.getHeight());
    appConfig.setInitialVisible(false);

    new Lwjgl3Application(new VideoExportApplication(config), appConfig);
  }
}
