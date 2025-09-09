package vendredi.soir.agfj.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Represent a game item
 * */
@EqualsAndHashCode(callSuper = true)
@Data
public class Item extends Entity {

    /** List of the item's attached items */
    private List<AttachedItem> attachedItems;

    /**
     * Creates an item
     *
     * @param name              the name of the item
     * @param description       the description of the item
     * @param attachedItems     list of items attached to the item to create */
    public Item(String name, String description, List<AttachedItem> attachedItems) {
        this.name = name;
        this.description = description;
        this.attachedItems = attachedItems;
    }

    /** Attaches an item to this item
     *
     * @param info              information about how to attach the item
     * @param item              the item to attach */
    public void attach(AttachmentInfo info, Item item) {
        if (!item.equals(this)) {
            attachedItems.add(
                    new AttachedItem(info, item)
            );
        }
    }
}
