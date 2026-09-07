package vendredi.soir.agfj.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnimationBinding {
  private String actionId;
  private String spriteSheetPath;
  private int frameWidth;
  private int frameHeight;
  private int firstFrameX = 0;
  private int firstFrameY = 0;
  private int frameCount;
  private int fps = 10;
}
