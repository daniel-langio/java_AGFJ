package vendredi.soir.agfj.graphics.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public record SpriteManager(SpriteBatch batch) {
    public void drawSprites(List<Sprite> sprites) {
        sprites.forEach(sprite -> sprite.draw(batch));
    }

    public void disposeSprites(List<Sprite> sprites) {
        sprites.forEach(sprite -> sprite.getTexture().dispose());
    }
}
