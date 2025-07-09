package agfj.core.scene;

import agfj.core.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

/**
 * Represent a game scene
 * */
@AllArgsConstructor
@Data
public class Scene {

    /** Scene description */
    private String description;

    /** Entities in the scene*/
    private List<Entity> entities;
}
