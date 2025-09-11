package vendredi.soir.agfj.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.AllArgsConstructor;
import vendredi.soir.agfj.graphics.entity.AnimatedEntity;

import java.util.List;

@AllArgsConstructor
public class AnimatedEntityManager {
    private final SpriteBatch batch;
    private List<AnimatedEntity> entities;

    public void drawSprites() {
       entities.forEach(sprite -> sprite.draw(batch));
    }

    public void disposeSprites() {
        entities.forEach(AnimatedEntity::dispose);
    }
}
