package vendredi.soir.agfj.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Describes how an item should be attached
 * */
@AllArgsConstructor
@Data
public class AttachedItem{

    /** Information about how to attach the item */
    private AttachmentInfo attachmentInfo;

    /** The item to attach */
    private Item item;
}
