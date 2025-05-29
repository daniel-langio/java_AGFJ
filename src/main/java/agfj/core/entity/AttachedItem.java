package agfj.core.entity;

import lombok.AllArgsConstructor;

/**
 * Represent an attached body part
 * */
@AllArgsConstructor
public class AttachedItem{
    private AttachmentInfo attachmentInfo;
    private Item item;
}
