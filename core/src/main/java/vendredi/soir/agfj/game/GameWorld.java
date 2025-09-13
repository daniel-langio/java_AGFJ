package vendredi.soir.agfj.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import vendredi.soir.agfj.entity.AnimatedEntity;
import vendredi.soir.agfj.entity.TexturedEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class GameWorld {
    private List<TexturedEntity> entities = new ArrayList<>();

    public void addEntity(TexturedEntity entity) {
        entities.add(entity);
    }

    public List<Sprite> getSprites() {
        return entities.stream().map(TexturedEntity::toSprite).toList();
    }

    public void draw(SpriteBatch batch) {
        entities.forEach(entity -> entity.draw(batch));
    }
}
