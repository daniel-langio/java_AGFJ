package agfj.core.entity;

import java.util.List;

/**
 * Represent a game item
 * */
public class Item extends Entity {

    private List<AttachedItem> attachedItems;

    public void attach(AttachmentInfo info, Item item) {
        if (!item.equals(this)) {
            attachedItems.add(
                    new AttachedItem(info, item)
            );
        }
    }
}
