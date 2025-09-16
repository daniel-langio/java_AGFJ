package vendredi.soir.agfj.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import lombok.Getter;

@Getter
public class TexturedEntity extends Sprite {
  protected final String name;

  public TexturedEntity(String name, Texture texture) {
    this.name = name;
    initTexture(texture);
  }

  protected void initTexture(Texture texture) {
    if (texture != null) {
      setTexture(texture);
      getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
      setPosition(0, 0);
    }
  }

  public Sprite toSprite() {
    return new Sprite(getTexture());
  }
}
