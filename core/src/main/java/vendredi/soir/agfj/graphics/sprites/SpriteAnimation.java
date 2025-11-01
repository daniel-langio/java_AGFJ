package vendredi.soir.agfj.graphics.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
public class SpriteAnimation {
  private final AnimationCategory category;
  private final List<TextureRegion> frames;
  private final float frameDuration;
  private int currentFrameIndex;
  @Setter private boolean loop = true;
  private float stateTime = 0;
  @Setter private boolean playing = true;

  public SpriteAnimation(
      int startFrameIndex, int fps, AnimationCategory category, List<TextureRegion> frames) {
    this.currentFrameIndex = startFrameIndex;
    this.frameDuration = 1f / fps;
    this.category = category;
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
