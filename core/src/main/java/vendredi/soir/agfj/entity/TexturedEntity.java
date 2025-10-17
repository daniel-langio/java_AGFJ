package vendredi.soir.agfj.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import lombok.Getter;

@Getter
public class TexturedEntity extends Sprite {
  protected final String name;

  public TexturedEntity(String name, Texture texture) {
    super(texture);
    this.name = name;
  }
}
