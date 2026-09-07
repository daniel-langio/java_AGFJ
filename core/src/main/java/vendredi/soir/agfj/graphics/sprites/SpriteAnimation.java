package vendredi.soir.agfj.graphics.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
public class SpriteAnimation {
  private final String actionId;
  private final List<TextureRegion> frames;
  private final float frameDuration;
  private int currentFrameIndex;
  @Setter private boolean loop = true;
  private float stateTime = 0;
  @Setter private boolean playing = true;
  @Setter private float vx = 0f;
  @Setter private float vy = 0f;

  public SpriteAnimation(
      int startFrameIndex, int fps, String actionId, List<TextureRegion> frames) {
    this.currentFrameIndex = startFrameIndex;
    this.frameDuration = 1f / fps;
    this.actionId = actionId;
    this.frames = frames;
  }

  public TextureRegion getCurrentFrame() {
    return frames.get(currentFrameIndex);
  }

  public void animate(float deltaTime) {
    if (playing) {
      stateTime += deltaTime;

      final int frameNumber = (int) (stateTime / frameDuration);
      final int framesSize = frames.size();
      if (loop) {
        currentFrameIndex = frameNumber % framesSize;
      } else {
        currentFrameIndex = Math.min(frameNumber, framesSize - 1);
      }
    }
  }

  public void reset() {
    stateTime = 0;
    currentFrameIndex = 0;
  }
}
