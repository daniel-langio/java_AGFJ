package vendredi.soir.agfj.graphics.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;

public final class SpriteLoader {
    public static List<TextureRegion> loadSpriteSet(
        String spriteSetFilePath,
        int frameWidth, int frameHeight,
        int firstFrameX, int firstFrameY,
        int frameAmount) {
        List<TextureRegion> spriteSet = new ArrayList<>();

        Texture spriteSetAll =  new Texture(spriteSetFilePath);
        for (int i = 0; i < frameAmount; i++) {
            int x = firstFrameX + i * frameWidth;
            int y = firstFrameY;

            TextureRegion frame = new TextureRegion(spriteSetAll,  x, y, frameWidth, frameHeight);
            spriteSet.add(frame);
        }

        return spriteSet;
    }
}
