package agfj.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent attachment infos
 * */
@AllArgsConstructor
@Data
public class AttachmentInfo {

    /** The side of the host item to link the attachment */
    private EntitySide hostSide;

    /** The side of the item to attach to link the attachment */
    private EntitySide selfSide;
}
