package vendredi.soir.agfj.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VideoExportConfig {
  private String actionsDir;
  private String entitiesDir;
  private String sceneFile;
  private String outputPath;
  private int fps = 30;
  private int durationSeconds = 10;
  private int width = 600;
  private int height = 600;
  private Integer stopAfterCollisionCount;
}
