package com.discord.widgets.chat;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageManager$AttachmentValidationResult$FilesTooLarge extends MessageManager$AttachmentValidationResult {
    private final MessageManager$AttachmentsRequest attachmentsRequest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageManager$AttachmentValidationResult$FilesTooLarge(MessageManager$AttachmentsRequest messageManager$AttachmentsRequest) {
        super(null);
        m.checkNotNullParameter(messageManager$AttachmentsRequest, "attachmentsRequest");
        this.attachmentsRequest = messageManager$AttachmentsRequest;
    }

    public static /* synthetic */ MessageManager$AttachmentValidationResult$FilesTooLarge copy$default(MessageManager$AttachmentValidationResult$FilesTooLarge messageManager$AttachmentValidationResult$FilesTooLarge, MessageManager$AttachmentsRequest messageManager$AttachmentsRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            messageManager$AttachmentsRequest = messageManager$AttachmentValidationResult$FilesTooLarge.attachmentsRequest;
        }
        return messageManager$AttachmentValidationResult$FilesTooLarge.copy(messageManager$AttachmentsRequest);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MessageManager$AttachmentsRequest getAttachmentsRequest() {
        return this.attachmentsRequest;
    }

    public final MessageManager$AttachmentValidationResult$FilesTooLarge copy(MessageManager$AttachmentsRequest attachmentsRequest) {
        m.checkNotNullParameter(attachmentsRequest, "attachmentsRequest");
        return new MessageManager$AttachmentValidationResult$FilesTooLarge(attachmentsRequest);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MessageManager$AttachmentValidationResult$FilesTooLarge) && m.areEqual(this.attachmentsRequest, ((MessageManager$AttachmentValidationResult$FilesTooLarge) other).attachmentsRequest);
        }
        return true;
    }

    public final MessageManager$AttachmentsRequest getAttachmentsRequest() {
        return this.attachmentsRequest;
    }

    public int hashCode() {
        MessageManager$AttachmentsRequest messageManager$AttachmentsRequest = this.attachmentsRequest;
        if (messageManager$AttachmentsRequest != null) {
            return messageManager$AttachmentsRequest.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("FilesTooLarge(attachmentsRequest=");
        sbU.append(this.attachmentsRequest);
        sbU.append(")");
        return sbU.toString();
    }
}
