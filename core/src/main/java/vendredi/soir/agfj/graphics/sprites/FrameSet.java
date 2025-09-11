package vendredi.soir.agfj.graphics.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FrameSet {
    private final String name;
    private final List<TextureRegion> frames;

    public void draw(SpriteBatch batch, int framePosition, int x, int y) {
        batch.draw(frames.get(framePosition),  x, y);
    }
}
